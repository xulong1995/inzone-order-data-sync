package com.inzone.mall.yunguangjie.service;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inzone.mall.yunguangjie.mapper.OrderInfoMapper;
import com.inzone.mall.yunguangjie.entity.OrderInfo;

@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService{

}
