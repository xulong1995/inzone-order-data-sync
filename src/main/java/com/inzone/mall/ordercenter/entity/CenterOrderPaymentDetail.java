package com.inzone.mall.ordercenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 订单支付明细表
    */
@ApiModel(value="订单支付明细表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "order_payment_detail")
public class CenterOrderPaymentDetail implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 支付流水号
     */
    @TableField(value = "pay_id")
    @ApiModelProperty(value="支付流水号")
    private String payId;

    /**
     * 订单编号
     */
    @TableField(value = "order_id")
    @ApiModelProperty(value="订单编号")
    private String orderId;

    /**
     * 支付类型  10:微信支付, 20:支付宝支付 30：贵宾卡支付 40 云卡支付 50 一卡通支付
     */
    @TableField(value = "pay_type")
    @ApiModelProperty(value="支付类型  10:微信支付, 20:支付宝支付 30：贵宾卡支付 40 云卡支付 50 一卡通支付")
    private Byte payType;

    /**
     * 支付金额
     */
    @TableField(value = "pay_amount")
    @ApiModelProperty(value="支付金额")
    private String payAmount;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    @ApiModelProperty(value="创建时间")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    @ApiModelProperty(value="更新时间")
    private Date gmtModified;

    /**
     * 父订单编号
     */
    @TableField(value = "parent_order_id")
    @ApiModelProperty(value="父订单编号")
    private String parentOrderId;

    @TableField(value = "yin_dou")
    @ApiModelProperty(value="")
    private String yinDou;

    @TableField(value = "man_yi_dou")
    @ApiModelProperty(value="")
    private String manYiDou;

    @TableField(value = "fan_li")
    @ApiModelProperty(value="")
    private String fanLi;

    /**
     * 手续费
     */
    @TableField(value = "fee")
    @ApiModelProperty(value="手续费")
    private String fee;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_PAY_ID = "pay_id";

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_PAY_TYPE = "pay_type";

    public static final String COL_PAY_AMOUNT = "pay_amount";

    public static final String COL_GMT_CREATE = "gmt_create";

    public static final String COL_GMT_MODIFIED = "gmt_modified";

    public static final String COL_PARENT_ORDER_ID = "parent_order_id";

    public static final String COL_YIN_DOU = "yin_dou";

    public static final String COL_MAN_YI_DOU = "man_yi_dou";

    public static final String COL_FAN_LI = "fan_li";

    public static final String COL_FEE = "fee";
}