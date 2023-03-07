package com.inzone.mall.xxljob.job;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.inzone.mall.ordercenter.entity.CenterAfterSaleOrderInfo;
import com.inzone.mall.ordercenter.entity.CenterOrderDeliveryLogistics;
import com.inzone.mall.ordercenter.service.CenterAfterSaleOrderInfoService;
import com.inzone.mall.ordercenter.service.CenterOrderDeliveryLogisticsService;
import com.inzone.mall.util.CompareUtil;
import com.inzone.mall.util.ConversionUtils;
import com.inzone.mall.yunguangjie.entity.AfterSaleOrderInfo;
import com.inzone.mall.yunguangjie.entity.OrderDeliveryLogistics;
import com.inzone.mall.yunguangjie.service.AfterSaleOrderInfoService;
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
 * @Description: 订单中心 AfterSaleOrderInfo表补偿逻辑
 * @author: xulong
 * @date: 2023年03月01日14:55
 */
@Component
@Slf4j
public class AfterSaleOrderInfoHandleJob {
    @Autowired
    private CenterAfterSaleOrderInfoService centerAfterSaleOrderInfoService;
    @Autowired
    private AfterSaleOrderInfoService afterSaleOrderInfoService;
    @Autowired
    private ConversionUtils conversionUtils;

    @XxlJob("afterSaleOrderInfoHandler")
    public ReturnT<String> afterSaleOrderInfoHandler(String param) {
        // 获取当前时间
        DateTime date = DateUtil.date();
        // 半小时前
        DateTime dateTime = DateUtil.offsetMinute(date, -30);
        List<CenterAfterSaleOrderInfo> afterSaleOrderInfos = centerAfterSaleOrderInfoService.list(new QueryWrapper<CenterAfterSaleOrderInfo>().lambda().between(CenterAfterSaleOrderInfo::getCreateDate, dateTime, date));
        List<AfterSaleOrderInfo> centerInfos = conversionUtils.centerAfterSaleInfoDetail2order(afterSaleOrderInfos);
        List<AfterSaleOrderInfo> orderInfos = afterSaleOrderInfoService.list(new QueryWrapper<AfterSaleOrderInfo>().lambda().between(AfterSaleOrderInfo::getCreateDate, dateTime, date));
        if(CollectionUtils.isNotEmpty(centerInfos)){
            if(CollectionUtils.isEmpty(orderInfos)){
                log.info("增量afterSaleOrderInfo:{}", JSONObject.toJSONString(centerInfos));
                centerInfos.forEach(afterSaleOrderInfoService::save);
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
    private void comparisonData(List<AfterSaleOrderInfo> centerInfos, List<AfterSaleOrderInfo> orderInfos) {
        List<String> saleIds = orderInfos.stream().map(AfterSaleOrderInfo::getAfterSaleOrderId).distinct().collect(Collectors.toList());
        List<AfterSaleOrderInfo> notExistList = centerInfos.stream().filter(a -> !saleIds.contains(a.getAfterSaleOrderId())).collect(Collectors.toList());
        List<AfterSaleOrderInfo> existList = centerInfos.stream().filter(a -> saleIds.contains(a.getAfterSaleOrderId())).collect(Collectors.toList());
        if(CollectionUtils.isNotEmpty(existList)){
            Map<String, AfterSaleOrderInfo> orderInfoMap = orderInfos.stream().collect(Collectors.toMap(AfterSaleOrderInfo::getAfterSaleOrderId, i -> i));
            centerInfos.forEach(centerOrderInfo -> {
                AfterSaleOrderInfo orderInfo = orderInfoMap.get(centerOrderInfo.getAfterSaleOrderId());
                if(!CompareUtil.checkObj(centerOrderInfo, orderInfo)){
                    notExistList.add(centerOrderInfo);
                }
            });
        }
        if(CollectionUtils.isNotEmpty(notExistList)){
            log.info("afterSaleInfos差异数据:{}",JSONObject.toJSONString(notExistList));
            notExistList.forEach(afterSaleOrderInfoService::saveOrUpdate);
        }

    }
}
