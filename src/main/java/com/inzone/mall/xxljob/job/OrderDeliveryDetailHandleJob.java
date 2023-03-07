package com.inzone.mall.xxljob.job;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.inzone.mall.ordercenter.entity.CenterOrderDeliveryDetail;
import com.inzone.mall.ordercenter.entity.CenterOrderInfo;
import com.inzone.mall.ordercenter.service.CenterOrderDeliveryDetailService;
import com.inzone.mall.ordercenter.service.CenterOrderInfoService;
import com.inzone.mall.util.CompareUtil;
import com.inzone.mall.util.ConversionUtils;
import com.inzone.mall.yunguangjie.entity.OrderDeliveryDetail;
import com.inzone.mall.yunguangjie.entity.OrderInfo;
import com.inzone.mall.yunguangjie.service.OrderDeliveryDetailService;
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
 * @Description: 订单中心 OrderDeliveryDetail表补偿逻辑
 * @author: xulong
 * @date: 2023年03月01日14:55
 */
@Component
@Slf4j
public class OrderDeliveryDetailHandleJob {
    @Autowired
    private CenterOrderDeliveryDetailService centerOrderDeliveryDetailService;
    @Autowired
    private OrderDeliveryDetailService orderDeliveryDetailService;
    @Autowired
    private ConversionUtils conversionUtils;

    @XxlJob("orderDeliveryDetailHandler")
    public ReturnT<String> orderDeliveryDetailHandler(String param) {
        // 获取当前时间
        DateTime date = DateUtil.date();
        // 半小时前
        DateTime dateTime = DateUtil.offsetMinute(date, -30);
        List<CenterOrderDeliveryDetail> orderDeliveryDetails = centerOrderDeliveryDetailService.list(new QueryWrapper<CenterOrderDeliveryDetail>().lambda().between(CenterOrderDeliveryDetail::getGmtCreate, dateTime, date));
        List<OrderDeliveryDetail> centerInfos = conversionUtils.centerOrderDeliveryDetail2order(orderDeliveryDetails);
        List<OrderDeliveryDetail> orderInfos = orderDeliveryDetailService.list(new QueryWrapper<OrderDeliveryDetail>().lambda().between(OrderDeliveryDetail::getGmtCreate, dateTime, date));
        if(CollectionUtils.isNotEmpty(centerInfos)){
            if(CollectionUtils.isEmpty(orderInfos)){
                log.info("增量centerDeliveryDetails:{}", JSONObject.toJSONString(centerInfos));
                centerInfos.forEach(orderDeliveryDetailService::save);
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
    private void comparisonData(List<OrderDeliveryDetail> centerInfos, List<OrderDeliveryDetail> orderInfos) {
        List<String> orderIds = orderInfos.stream().map(OrderDeliveryDetail::getOrderId).distinct().collect(Collectors.toList());
        List<OrderDeliveryDetail> notExistList = centerInfos.stream().filter(a -> !orderIds.contains(a.getOrderId())).collect(Collectors.toList());
        List<OrderDeliveryDetail> existList = centerInfos.stream().filter(a -> orderIds.contains(a.getOrderId())).collect(Collectors.toList());
        if(CollectionUtils.isNotEmpty(existList)){
            Map<String, OrderDeliveryDetail> orderInfoMap = orderInfos.stream().collect(Collectors.toMap(OrderDeliveryDetail::getOrderId, i -> i));
            centerInfos.forEach(centerOrderInfo -> {
                OrderDeliveryDetail orderInfo = orderInfoMap.get(centerOrderInfo.getOrderId());
                if(!CompareUtil.checkObj(centerOrderInfo, orderInfo)){
                    notExistList.add(centerOrderInfo);
                }
            });
        }
        if(CollectionUtils.isNotEmpty(notExistList)){
            log.info("orderDeliveryDetails差异数据:{}",JSONObject.toJSONString(notExistList));
            notExistList.forEach(orderDeliveryDetailService::saveOrUpdate);
        }

    }
}
