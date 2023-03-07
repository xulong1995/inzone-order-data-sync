package com.inzone.mall.xxljob.job;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.inzone.mall.ordercenter.entity.CenterAfterSaleOrderInfo;
import com.inzone.mall.ordercenter.entity.CenterAfterSaleOrderItem;
import com.inzone.mall.ordercenter.service.CenterAfterSaleOrderInfoService;
import com.inzone.mall.ordercenter.service.CenterAfterSaleOrderItemService;
import com.inzone.mall.util.CompareUtil;
import com.inzone.mall.util.ConversionUtils;
import com.inzone.mall.yunguangjie.entity.AfterSaleOrderInfo;
import com.inzone.mall.yunguangjie.entity.AfterSaleOrderItem;
import com.inzone.mall.yunguangjie.service.AfterSaleOrderInfoService;
import com.inzone.mall.yunguangjie.service.AfterSaleOrderItemService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 订单中心 AfterSaleOrderItem表补偿逻辑
 * @author: xulong
 * @date: 2023年03月01日14:55
 */
@Component
@Slf4j
public class AfterSaleOrderItemHandleJob {
    @Autowired
    private CenterAfterSaleOrderItemService centerAfterSaleOrderItemService;
    @Autowired
    private AfterSaleOrderItemService afterSaleOrderItemService;
    @Autowired
    private ConversionUtils conversionUtils;

    @XxlJob("afterSaleOrderItemHandler")
    public ReturnT<String> afterSaleOrderItemHandler(String param) {
        // 获取当前时间
        DateTime date = DateUtil.date();
        // 半小时前
        DateTime dateTime = DateUtil.offsetMinute(date, -30);
        List<CenterAfterSaleOrderItem> afterSaleOrderItems = centerAfterSaleOrderItemService.list(new QueryWrapper<CenterAfterSaleOrderItem>().lambda().between(CenterAfterSaleOrderItem::getCreateDate, dateTime, date));
        List<AfterSaleOrderItem> centerInfos = conversionUtils.centerAfterSaleItemDetail2order(afterSaleOrderItems);
        List<AfterSaleOrderItem> orderInfos = afterSaleOrderItemService.list(new QueryWrapper<AfterSaleOrderItem>().lambda().between(AfterSaleOrderItem::getCreateDate, dateTime, date));
        if(CollectionUtils.isNotEmpty(centerInfos)){
            if(CollectionUtils.isEmpty(orderInfos)){
                log.info("增量afterSaleOrderItem:{}", JSONObject.toJSONString(centerInfos));
                centerInfos.forEach(afterSaleOrderItemService::save);
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
    private void comparisonData(List<AfterSaleOrderItem> centerInfos, List<AfterSaleOrderItem> orderInfos) {
        List<String> saleIds = orderInfos.stream().map(AfterSaleOrderItem::getAfterSaleItemId).distinct().collect(Collectors.toList());
        List<AfterSaleOrderItem> notExistList = centerInfos.stream().filter(a -> !saleIds.contains(a.getAfterSaleItemId())).collect(Collectors.toList());
        List<AfterSaleOrderItem> existList = centerInfos.stream().filter(a -> saleIds.contains(a.getAfterSaleItemId())).collect(Collectors.toList());
        if(CollectionUtils.isNotEmpty(existList)){
            Map<String, AfterSaleOrderItem> orderInfoMap = orderInfos.stream().collect(Collectors.toMap(AfterSaleOrderItem::getAfterSaleItemId, i -> i));
            centerInfos.forEach(centerOrderInfo -> {
                AfterSaleOrderItem orderInfo = orderInfoMap.get(centerOrderInfo.getAfterSaleItemId());
                if(!CompareUtil.checkObj(centerOrderInfo, orderInfo)){
                    notExistList.add(centerOrderInfo);
                }
            });
        }
        if(CollectionUtils.isNotEmpty(notExistList)){
            log.info("afterSaleItems差异数据:{}",JSONObject.toJSONString(notExistList));
            notExistList.forEach(afterSaleOrderItemService::saveOrUpdate);
        }

    }
}
