package com.inzone.mall.xxljob.job;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.inzone.mall.ordercenter.entity.CenterOrderInfo;
import com.inzone.mall.ordercenter.entity.CenterOrderInvoice;
import com.inzone.mall.ordercenter.service.CenterOrderInfoService;
import com.inzone.mall.util.CompareUtil;
import com.inzone.mall.util.ConversionUtils;
import com.inzone.mall.yunguangjie.entity.OrderInfo;
import com.inzone.mall.yunguangjie.service.OrderInfoService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 订单中心 orderInfo表补偿逻辑
 * @author: xulong
 * @date: 2023年03月01日14:55
 */
@Component
@Slf4j
public class OrderInfoHandleJob {
    @Autowired
    private CenterOrderInfoService centerOrderInfoService;
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private ConversionUtils conversionUtils;

    @XxlJob("orderInfoHandler")
    public ReturnT<String> orderInfoHandler(String param) {
        // 获取当前时间
        DateTime date = DateUtil.date();
        // 半小时前
        DateTime dateTime = DateUtil.offsetMinute(date, -30);
        List<CenterOrderInfo> orderCenterList = centerOrderInfoService.list(new QueryWrapper<CenterOrderInfo>().lambda().between(CenterOrderInfo::getGmtCreate, dateTime, date));
        List<OrderInfo> centerInfos = conversionUtils.centerOrder2order(orderCenterList);
        List<OrderInfo> orderInfos = orderInfoService.list(new QueryWrapper<OrderInfo>().lambda().between(OrderInfo::getGmtCreate, dateTime, date));
        if(CollectionUtils.isNotEmpty(centerInfos)){
            if(CollectionUtils.isEmpty(orderInfos)){
                log.info("增量centerInfos:{}", JSONObject.toJSONString(centerInfos));
                centerInfos.forEach(orderInfoService::save);
            }else{
                comparisonData(centerInfos, orderInfos);
            }

        }
        return ReturnT.SUCCESS;
    }

    /**
     *  对比云逛街，订单中心数据
     * @param centerInfos 订单中心数据
     * @param orderInfos 云逛街数据
     */
    private void comparisonData(List<OrderInfo> centerInfos, List<OrderInfo> orderInfos) {
        List<String> orderIds = orderInfos.stream().map(OrderInfo::getOrderId).distinct().collect(Collectors.toList());
        List<OrderInfo> notExistList = centerInfos.stream().filter(a -> !orderIds.contains(a.getOrderId())).collect(Collectors.toList());
        List<OrderInfo> existList = centerInfos.stream().filter(a -> orderIds.contains(a.getOrderId())).collect(Collectors.toList());
        if(CollectionUtils.isNotEmpty(existList)){
            Map<String, OrderInfo> orderInfoMap = orderInfos.stream().collect(Collectors.toMap(OrderInfo::getOrderId, i -> i));
            centerInfos.forEach(centerOrderInfo -> {
                OrderInfo orderInfo = orderInfoMap.get(centerOrderInfo.getOrderId());
                if(!CompareUtil.checkObj(centerOrderInfo, orderInfo)){
                    notExistList.add(centerOrderInfo);
                }
            });
        }
        if(CollectionUtils.isNotEmpty(notExistList)){
            log.info("orderInfo差异数据:{}",JSONObject.toJSONString(notExistList));
            notExistList.forEach(orderInfoService::saveOrUpdate);
        }

    }
}
