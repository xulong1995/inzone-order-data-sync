package com.inzone.mall.ordercenter.service;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inzone.mall.ordercenter.entity.CenterOrderInfo;
import com.inzone.mall.ordercenter.mapper.CenterOrderInfoMapper;

@Service
public class CenterOrderInfoServiceImpl extends ServiceImpl<CenterOrderInfoMapper, CenterOrderInfo> implements CenterOrderInfoService {

}
