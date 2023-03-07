package com.inzone.mall.ordercenter.service;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inzone.mall.ordercenter.mapper.CenterOrderItemMapper;
import com.inzone.mall.ordercenter.entity.CenterOrderItem;

@Service
public class CenterOrderItemServiceImpl extends ServiceImpl<CenterOrderItemMapper, CenterOrderItem> implements CenterOrderItemService {

}
