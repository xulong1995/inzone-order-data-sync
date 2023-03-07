package com.inzone.mall.util;

import com.inzone.mall.ordercenter.entity.*;
import com.inzone.mall.yunguangjie.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @Description: TODO
 * @author: xulong
 * @date: 2023年03月02日14:54
 */
@Mapper(componentModel = "spring")
public interface ConversionUtils {
    OrderInfo centerOrder2order(CenterOrderInfo vo);
    List<OrderInfo> centerOrder2order(List<CenterOrderInfo> vos);

    OrderItem centerOrderItem2order(CenterOrderItem vo);
    List<OrderItem> centerOrderItem2order(List<CenterOrderItem> vos);

    OrderInvoice centerOrderInvoice2order(CenterOrderInvoice vo);
    List<OrderInvoice> centerOrderInvoice2order(List<CenterOrderInvoice> vos);

    OrderPaymentDetail centerOrderPayment2order(CenterOrderPaymentDetail vo);
    List<OrderPaymentDetail> centerOrderPayment2order(List<CenterOrderPaymentDetail> vos);

    OrderDeliveryDetail centerOrderDeliveryDetail2order(CenterOrderDeliveryDetail vo);
    List<OrderDeliveryDetail> centerOrderDeliveryDetail2order(List<CenterOrderDeliveryDetail> vos);

    OrderDeliveryLogistics centerOrderLogisticsDetail2order(CenterOrderDeliveryLogistics vo);
    List<OrderDeliveryLogistics> centerOrderLogisticsDetail2order(List<CenterOrderDeliveryLogistics> vos);

    AfterSaleOrderInfo centerAfterSaleInfoDetail2order(CenterAfterSaleOrderInfo vo);
    List<AfterSaleOrderInfo> centerAfterSaleInfoDetail2order(List<CenterAfterSaleOrderInfo> vos);


    @Mapping(source = "number", target = "applyNumber")
    AfterSaleOrderItem centerAfterSaleItemDetail2order(CenterAfterSaleOrderItem vo);
    @Mapping(source = "number", target = "applyNumber")
    List<AfterSaleOrderItem> centerAfterSaleItemDetail2order(List<CenterAfterSaleOrderItem> vos);
}
