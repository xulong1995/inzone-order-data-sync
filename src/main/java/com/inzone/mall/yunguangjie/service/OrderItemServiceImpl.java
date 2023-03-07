package com.inzone.mall.yunguangjie.service;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inzone.mall.yunguangjie.mapper.OrderItemMapper;
import com.inzone.mall.yunguangjie.entity.OrderItem;

@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService{

}
