package com.inzone.mall.xxljob.job;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.db.sql.Order;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.inzone.mall.ordercenter.entity.CenterOrderPaymentDetail;
import com.inzone.mall.ordercenter.service.CenterOrderPaymentDetailService;
import com.inzone.mall.util.CompareUtil;
import com.inzone.mall.util.ConversionUtils;
import com.inzone.mall.yunguangjie.entity.OrderPaymentDetail;
import com.inzone.mall.yunguangjie.service.OrderPaymentDetailService;
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
 * @Description: 订单中心 orderPaymentDetails表补偿逻辑
 * @author: xulong
 * @date: 2023年03月06日15:38
 */
@Component
@Slf4j
public class OrderPaymentHandlerJob {
    @Autowired
    private CenterOrderPaymentDetailService centerOrderPaymentDetailService;
    @Autowired
    private OrderPaymentDetailService orderPaymentDetailService;
    @Autowired
    private ConversionUtils conversionUtils;

    @XxlJob("orderPaymentHandler")
    public ReturnT<String> orderPaymentHandler(String param) {
        // 获取当前时间
        DateTime date = DateUtil.date();
        // 半小时前
        DateTime dateTime = DateUtil.offsetMinute(date, -30);
        List<CenterOrderPaymentDetail> orderCenterList = centerOrderPaymentDetailService.list(new QueryWrapper<CenterOrderPaymentDetail>().lambda().between(CenterOrderPaymentDetail::getGmtCreate, dateTime, date));
        List<OrderPaymentDetail> centerInfos = conversionUtils.centerOrderPayment2order(orderCenterList);
        List<OrderPaymentDetail> orderInfos = orderPaymentDetailService.list(new QueryWrapper<OrderPaymentDetail>().lambda().between(OrderPaymentDetail::getGmtCreate, dateTime, date));
        if(CollectionUtils.isNotEmpty(centerInfos)){
            if(CollectionUtils.isEmpty(orderInfos)){
                log.info("增量centerOrderPaymentInfos:{}", JSONObject.toJSONString(centerInfos));
                centerInfos.forEach(orderPaymentDetailService::save);
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
    private void comparisonData(List<OrderPaymentDetail> centerInfos, List<OrderPaymentDetail> orderInfos) {
        List<BigDecimal> ids = orderInfos.stream().map(OrderPaymentDetail::getId).distinct().collect(Collectors.toList());
        List<OrderPaymentDetail> notExistList = centerInfos.stream().filter(a -> !ids.contains(a.getId())).collect(Collectors.toList());
        List<OrderPaymentDetail> existList = centerInfos.stream().filter(a -> ids.contains(a.getId())).collect(Collectors.toList());
        if(CollectionUtils.isNotEmpty(existList)){
            Map<BigDecimal, OrderPaymentDetail> orderInfoMap = orderInfos.stream().collect(Collectors.toMap(OrderPaymentDetail::getId, i -> i));
            centerInfos.forEach(centerOrderInfo -> {
                OrderPaymentDetail orderInfo = orderInfoMap.get(centerOrderInfo.getId());
                if(!CompareUtil.checkObj(centerOrderInfo, orderInfo)){
                    notExistList.add(centerOrderInfo);
                }
            });
        }
        if(CollectionUtils.isNotEmpty(notExistList)){
            log.info("orderPaymentInfo差异数据:{}",JSONObject.toJSONString(notExistList));
            notExistList.forEach(orderPaymentDetailService::saveOrUpdate);
        }

    }
}
