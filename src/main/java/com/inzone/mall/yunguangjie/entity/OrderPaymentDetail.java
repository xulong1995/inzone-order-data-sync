package com.inzone.mall.yunguangjie.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.*;

/**
    * 订单支付明细表
    */
@ApiModel(value="订单支付明细表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "ORDER_PAYMENT_DETAIL")
@EqualsAndHashCode
public class OrderPaymentDetail implements Serializable {
    @TableId(value = "ID", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private BigDecimal id;

    /**
     * 支付流水号
     */
    @TableField(value = "PAY_ID")
    @ApiModelProperty(value="支付流水号")
    private String payId;

    /**
     * 订单编号
     */
    @TableField(value = "ORDER_ID")
    @ApiModelProperty(value="订单编号")
    private String orderId;

    /**
     * 支付类型  10:微信支付, 20:支付宝支付 30：贵宾卡支付 40 云卡支付 50 一卡通支付
     */
    @TableField(value = "PAY_TYPE")
    @ApiModelProperty(value="支付类型  10:微信支付, 20:支付宝支付 30：贵宾卡支付 40 云卡支付 50 一卡通支付")
    private Short payType;

    /**
     * 支付金额
     */
    @TableField(value = "PAY_AMOUNT")
    @ApiModelProperty(value="支付金额")
    private String payAmount;

    /**
     * 创建时间
     */
    @TableField(value = "GMT_CREATE")
    @ApiModelProperty(value="创建时间")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "GMT_MODIFIED")
    @ApiModelProperty(value="更新时间")
    private Date gmtModified;

    /**
     * 父订单编号
     */
    @TableField(value = "PARENT_ORDER_ID")
    @ApiModelProperty(value="父订单编号")
    private String parentOrderId;

    @TableField(value = "YIN_DOU")
    @ApiModelProperty(value="")
    private String yinDou;

    @TableField(value = "MAN_YI_DOU")
    @ApiModelProperty(value="")
    private String manYiDou;

    @TableField(value = "FAN_LI")
    @ApiModelProperty(value="")
    private String fanLi;

    /**
     * 手续费
     */
    @TableField(value = "FEE")
    @ApiModelProperty(value="手续费")
    private String fee;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "ID";

    public static final String COL_PAY_ID = "PAY_ID";

    public static final String COL_ORDER_ID = "ORDER_ID";

    public static final String COL_PAY_TYPE = "PAY_TYPE";

    public static final String COL_PAY_AMOUNT = "PAY_AMOUNT";

    public static final String COL_GMT_CREATE = "GMT_CREATE";

    public static final String COL_GMT_MODIFIED = "GMT_MODIFIED";

    public static final String COL_PARENT_ORDER_ID = "PARENT_ORDER_ID";

    public static final String COL_YIN_DOU = "YIN_DOU";

    public static final String COL_MAN_YI_DOU = "MAN_YI_DOU";

    public static final String COL_FAN_LI = "FAN_LI";

    public static final String COL_FEE = "FEE";
}