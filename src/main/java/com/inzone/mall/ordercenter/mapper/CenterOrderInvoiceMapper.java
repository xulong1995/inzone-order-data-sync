package com.inzone.mall.ordercenter.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inzone.mall.ordercenter.entity.CenterOrderInvoice;
@DS("orderCenter")
public interface CenterOrderInvoiceMapper extends BaseMapper<CenterOrderInvoice> {
}