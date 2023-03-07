package com.inzone.mall.xxljob.job;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.inzone.mall.ordercenter.entity.CenterOrderDeliveryDetail;
import com.inzone.mall.ordercenter.entity.CenterOrderDeliveryLogistics;
import com.inzone.mall.ordercenter.service.CenterOrderDeliveryDetailService;
import com.inzone.mall.ordercenter.service.CenterOrderDeliveryLogisticsService;
import com.inzone.mall.util.CompareUtil;
import com.inzone.mall.util.ConversionUtils;
import com.inzone.mall.yunguangjie.entity.OrderDeliveryDetail;
import com.inzone.mall.yunguangjie.entity.OrderDeliveryLogistics;
import com.inzone.mall.yunguangjie.service.OrderDeliveryDetailService;
import com.inzone.mall.yunguangjie.service.OrderDeliveryLogisticsService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 订单中心 OrderDeliveryLogistics表补偿逻辑
 * @author: xulong
 * @date: 2023年03月01日14:55
 */
@Component
@Slf4j
public class OrderDeliveryLogisticsHandleJob {
    @Autowired
    private CenterOrderDeliveryLogisticsService centerOrderDeliveryLogisticsService;
    @Autowired
    private OrderDeliveryLogisticsService orderDeliveryLogisticsService;
    @Autowired
    private ConversionUtils conversionUtils;

    @XxlJob("orderDeliveryLogisticsHandler")
    public ReturnT<String> orderDeliveryLogisticsHandler(String param) {
        // 获取当前时间
        DateTime date = DateUtil.date();
        // 半小时前
        DateTime dateTime = DateUtil.offsetMinute(date, -30);
        List<CenterOrderDeliveryLogistics> orderDeliveryLogistics = centerOrderDeliveryLogisticsService.list(new QueryWrapper<CenterOrderDeliveryLogistics>().lambda().between(CenterOrderDeliveryLogistics::getCreateDate, dateTime, date));
        List<OrderDeliveryLogistics> centerInfos = conversionUtils.centerOrderLogisticsDetail2order(orderDeliveryLogistics);
        List<OrderDeliveryLogistics> orderInfos = orderDeliveryLogisticsService.list(new QueryWrapper<OrderDeliveryLogistics>().lambda().between(OrderDeliveryLogistics::getCreateDate, dateTime, date));
        if(CollectionUtils.isNotEmpty(centerInfos)){
            if(CollectionUtils.isEmpty(orderInfos)){
                log.info("增量centerDeliveryLogistics:{}", JSONObject.toJSONString(centerInfos));
                centerInfos.forEach(orderDeliveryLogisticsService::save);
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
    private void comparisonData(List<OrderDeliveryLogistics> centerInfos, List<OrderDeliveryLogistics> orderInfos) {
        List<BigDecimal> ids = orderInfos.stream().map(OrderDeliveryLogistics::getId).distinct().collect(Collectors.toList());
        List<OrderDeliveryLogistics> notExistList = centerInfos.stream().filter(a -> !ids.contains(a.getId())).collect(Collectors.toList());
        List<OrderDeliveryLogistics> existList = centerInfos.stream().filter(a -> ids.contains(a.getId())).collect(Collectors.toList());
        if(CollectionUtils.isNotEmpty(existList)){
            Map<BigDecimal, OrderDeliveryLogistics> orderInfoMap = orderInfos.stream().collect(Collectors.toMap(OrderDeliveryLogistics::getId, i -> i));
            centerInfos.forEach(centerOrderInfo -> {
                OrderDeliveryLogistics orderInfo = orderInfoMap.get(centerOrderInfo.getId());
                if(!CompareUtil.checkObj(centerOrderInfo, orderInfo)){
                    notExistList.add(centerOrderInfo);
                }
            });
        }
        if(CollectionUtils.isNotEmpty(notExistList)){
            log.info("orderDeliveryLogistics差异数据:{}",JSONObject.toJSONString(notExistList));
            notExistList.forEach(orderDeliveryLogisticsService::saveOrUpdate);
        }

    }
}
