package com.inzone.mall.xxljob.job;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.inzone.mall.ordercenter.entity.CenterOrderInvoice;
import com.inzone.mall.ordercenter.service.CenterOrderInvoiceService;
import com.inzone.mall.util.CompareUtil;
import com.inzone.mall.util.ConversionUtils;
import com.inzone.mall.yunguangjie.entity.OrderInvoice;
import com.inzone.mall.yunguangjie.service.OrderInvoiceService;
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
 * @Description: 订单中心 orderInvoice补偿逻辑
 * @author: xulong
 * @date: 2023年03月06日14:44
 */
@Component
@Slf4j
public class OrderInvoiceHandlerJob {
    @Autowired
    private CenterOrderInvoiceService centerOrderInvoiceService;
    @Autowired
    private OrderInvoiceService orderInvoiceService;
    @Autowired
    private ConversionUtils conversionUtils;

    @XxlJob("orderInvoiceHandler")
    public ReturnT<String> orderInvoiceHandler(String param) {
        // 获取当前时间
        DateTime date = DateUtil.date();
        // 半小时前
        DateTime dateTime = DateUtil.offsetMinute(date, -30);
        List<CenterOrderInvoice> orderCenterList = centerOrderInvoiceService.list(new QueryWrapper<CenterOrderInvoice>().lambda().between(CenterOrderInvoice::getCreatedTime, dateTime, date));
        List<OrderInvoice> centerInvoices = conversionUtils.centerOrderInvoice2order(orderCenterList);
        List<OrderInvoice> orderInvoices = orderInvoiceService.list(new QueryWrapper<OrderInvoice>().lambda().between(OrderInvoice::getCreatedTime, dateTime, date));
        if(CollectionUtils.isNotEmpty(centerInvoices)){
            if(CollectionUtils.isEmpty(orderInvoices)){
                log.info("增量centerInvoices:{}", JSONObject.toJSONString(centerInvoices));
                centerInvoices.forEach(orderInvoiceService::save);
            }else{
                comparisonData(centerInvoices, orderInvoices);
            }
        }
        return ReturnT.SUCCESS;
    }

    /**
     *  对比云逛街，订单中心数据
     * @param centerInvoices 订单中心数据
     * @param orderInvoices 云逛街数据
     */
    private void comparisonData(List<OrderInvoice> centerInvoices, List<OrderInvoice> orderInvoices) {
        List<BigDecimal> ids = orderInvoices.stream().map(OrderInvoice::getId).distinct().collect(Collectors.toList());
        List<OrderInvoice> notExistList = centerInvoices.stream().filter(a -> !ids.contains(a.getId())).collect(Collectors.toList());
        List<OrderInvoice> existList = centerInvoices.stream().filter(a -> ids.contains(a.getId())).collect(Collectors.toList());
        if(CollectionUtils.isNotEmpty(existList)){
            Map<BigDecimal, OrderInvoice> orderInvoiceMap = orderInvoices.stream().collect(Collectors.toMap(OrderInvoice::getId, i -> i));
            centerInvoices.forEach(centerOrderInvoice -> {
                OrderInvoice orderInvoice = orderInvoiceMap.get(centerOrderInvoice.getId());
                if(!CompareUtil.checkObj(centerOrderInvoice, orderInvoice)){
                    notExistList.add(centerOrderInvoice);
                }
            });
        }
        if(CollectionUtils.isNotEmpty(notExistList)){
            log.info("centerInvoices差异数据:{}",JSONObject.toJSONString(notExistList));
            notExistList.forEach(orderInvoiceService::saveOrUpdate);
        }
    }
}
