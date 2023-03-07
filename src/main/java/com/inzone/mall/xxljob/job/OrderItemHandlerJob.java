package com.inzone.mall.xxljob.job;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.inzone.mall.ordercenter.entity.CenterOrderInfo;
import com.inzone.mall.ordercenter.entity.CenterOrderItem;
import com.inzone.mall.ordercenter.service.CenterOrderItemService;
import com.inzone.mall.util.CompareUtil;
import com.inzone.mall.util.ConversionUtils;
import com.inzone.mall.yunguangjie.entity.OrderInfo;
import com.inzone.mall.yunguangjie.entity.OrderItem;
import com.inzone.mall.yunguangjie.service.OrderItemService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 订单中心 orderItem表补偿逻辑
 * @author: xulong
 * @date: 2023年03月06日14:08
 */
@Component
@Slf4j
public class OrderItemHandlerJob {
    @Autowired
    private CenterOrderItemService centerOrderItemService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private ConversionUtils conversionUtils;

    @XxlJob("orderItemHandler")
    public ReturnT<String> orderItemHandler(String param) {
        // 获取当前时间
        DateTime date = DateUtil.date();
        // 半小时前
        DateTime dateTime = DateUtil.offsetMinute(date, -30);
        List<CenterOrderItem> orderCenterList = centerOrderItemService.list(new QueryWrapper<CenterOrderItem>().lambda().between(CenterOrderItem::getGmtCreate, dateTime, date));
        List<OrderItem> centerItems = conversionUtils.centerOrderItem2order(orderCenterList);
        List<OrderItem> orderItems = orderItemService.list(new QueryWrapper<OrderItem>().lambda().between(OrderItem::getGmtCreate, dateTime, date));
        if(CollectionUtils.isNotEmpty(centerItems)){
            if(CollectionUtils.isEmpty(orderItems)){
                log.info("增量centerItems:{}", JSONObject.toJSONString(centerItems));
                centerItems.forEach(orderItemService::save);
            }else{
                comparisonData(centerItems, orderItems);
            }

        }
        return ReturnT.SUCCESS;
    }


    /**
     *  对比云逛街，订单中心数据
     * @param centerItems 订单中心数据
     * @param orderItems 云逛街数据
     */
    private void comparisonData(List<OrderItem> centerItems, List<OrderItem> orderItems) {
        List<String> orderItemIds = orderItems.stream().map(OrderItem::getOrderItemId).distinct().collect(Collectors.toList());
        List<OrderItem> notExistList = centerItems.stream().filter(a -> !orderItemIds.contains(a.getOrderItemId())).collect(Collectors.toList());
        List<OrderItem> existList = centerItems.stream().filter(a -> orderItemIds.contains(a.getOrderItemId())).collect(Collectors.toList());
        if(CollectionUtils.isNotEmpty(existList)){
            Map<String, OrderItem> orderItemMap = orderItems.stream().collect(Collectors.toMap(OrderItem::getOrderItemId, i -> i));
            centerItems.forEach(centerOrderItem -> {
                OrderItem orderItem = orderItemMap.get(centerOrderItem.getOrderItemId());
                if(!CompareUtil.checkObj(centerOrderItem, orderItem)){
                    notExistList.add(centerOrderItem);
                }
            });
        }
        if(CollectionUtils.isNotEmpty(notExistList)){
            log.info("centerItems差异数据:{}",JSONObject.toJSONString(notExistList));
            notExistList.forEach(orderItemService::saveOrUpdate);
        }
    }


}
