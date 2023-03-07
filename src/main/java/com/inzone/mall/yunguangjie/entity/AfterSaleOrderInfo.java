package com.inzone.mall.yunguangjie.entity;

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
    * 订单售后表
    */
@ApiModel(value="订单售后表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "AFTER_SALE_ORDER_INFO")
public class AfterSaleOrderInfo implements Serializable {
    /**
     * 售后单号
     */
    @TableId(value = "AFTER_SALE_ORDER_ID", type = IdType.INPUT)
    @ApiModelProperty(value="售后单号")
    private String afterSaleOrderId;

    /**
     * 申请售后时间
     */
    @TableField(value = "CREATE_DATE")
    @ApiModelProperty(value="申请售后时间")
    private Date createDate;

    /**
     * 订单号
     */
    @TableField(value = "ORDER_ID")
    @ApiModelProperty(value="订单号")
    private String orderId;

    /**
     * 全渠道退货单号
     */
    @TableField(value = "EFUTURE_AFTERSALE_ID")
    @ApiModelProperty(value="全渠道退货单号")
    private String efutureAftersaleId;

    /**
     * 售后单状态(30:审核驳回;40:退款中;41:退款退货中;50:已退款;51:已退款退货;60:退款失败;61:退款退货失败;127:撤销售后申请)
     */
    @TableField(value = "\"STATUS\"")
    @ApiModelProperty(value="售后单状态(30:审核驳回;40:退款中;41:退款退货中;50:已退款;51:已退款退货;60:退款失败;61:退款退货失败;127:撤销售后申请)")
    private String status;

    /**
     * 申请退款金额,单位分
     */
    @TableField(value = "APPLY_AMT")
    @ApiModelProperty(value="申请退款金额,单位分")
    private String applyAmt;

    /**
     * 实际退款金额,单位分
     */
    @TableField(value = "REAL_REFUND_AMT")
    @ApiModelProperty(value="实际退款金额,单位分")
    private String realRefundAmt;

    /**
     * 折扣金额（分）
     */
    @TableField(value = "DISCOUNT")
    @ApiModelProperty(value="折扣金额（分）")
    private String discount;

    /**
     * 返利金额（分）
     */
    @TableField(value = "GIFTAMOUNT")
    @ApiModelProperty(value="返利金额（分）")
    private String giftamount;

    /**
     * 积分抵现金额（分）
     */
    @TableField(value = "POINTSCASH")
    @ApiModelProperty(value="积分抵现金额（分）")
    private String pointscash;

    /**
     * 积分
     */
    @TableField(value = "CONSUMPOINTS")
    @ApiModelProperty(value="积分")
    private String consumpoints;

    /**
     * 券优惠金额（分）
     */
    @TableField(value = "DISCOUPON")
    @ApiModelProperty(value="券优惠金额（分）")
    private String discoupon;

    /**
     * 退款手续费,单位分
     */
    @TableField(value = "PROCEDURE_FEE")
    @ApiModelProperty(value="退款手续费,单位分")
    private String procedureFee;

    /**
     * 运费,单位分,每个订单一个运费
     */
    @TableField(value = "DELIVERY_FEE")
    @ApiModelProperty(value="运费,单位分,每个订单一个运费")
    private String deliveryFee;

    /**
     * 包装费，单位分，每个订单一个包装费
     */
    @TableField(value = "PKG_FEE")
    @ApiModelProperty(value="包装费，单位分，每个订单一个包装费")
    private String pkgFee;

    /**
     * 购买用户手机号
     */
    @TableField(value = "PHONE")
    @ApiModelProperty(value="购买用户手机号")
    private String phone;

    /**
     * 餐盒费，单位分，每个商品一个餐盒费
     */
    @TableField(value = "LUNCH_BOX_FEE")
    @ApiModelProperty(value="餐盒费，单位分，每个商品一个餐盒费")
    private String lunchBoxFee;

    /**
     * 申请方式：买家申请buyer， 商家申请 seller
     */
    @TableField(value = "APPLYER_TYPE")
    @ApiModelProperty(value="申请方式：买家申请buyer， 商家申请 seller")
    private String applyerType;

    /**
     * 申请原因
     */
    @TableField(value = "APPLY_REASON")
    @ApiModelProperty(value="申请原因")
    private String applyReason;

    /**
     * 审核意见原因
     */
    @TableField(value = "PROCESS_REASON")
    @ApiModelProperty(value="审核意见原因")
    private String processReason;

    /**
     * 审核人员工号
     */
    @TableField(value = "\"OPERATOR\"")
    @ApiModelProperty(value="审核人员工号")
    private String operator;

    /**
     * 凭证图片地址，多个英文逗号隔开
     */
    @TableField(value = "IMG_URL")
    @ApiModelProperty(value="凭证图片地址，多个英文逗号隔开")
    private String imgUrl;

    /**
     * 接入方业务线标识  xyzdj, "银座超市到家" yunguangjie 云逛街  inzone-app商城
     */
    @TableField(value = "CHANNEL_ID")
    @ApiModelProperty(value="接入方业务线标识  xyzdj, '银座超市到家' yunguangjie 云逛街  inzone-app商城")
    private String channelId;

    /**
     * 红冲发票状态0没有发起红冲;1红冲成功;2红冲失败;3蓝票不存在，审核通过时，会先红冲，再退款
     */
    @TableField(value = "INVOICE_STATE")
    @ApiModelProperty(value="红冲发票状态0没有发起红冲;1红冲成功;2红冲失败;3蓝票不存在，审核通过时，会先红冲，再退款")
    private String invoiceState;

    /**
     * 红冲发票时间
     */
    @TableField(value = "INVOICE_DATE")
    @ApiModelProperty(value="红冲发票时间")
    private Date invoiceDate;

    /**
     * 审核时间
     */
    @TableField(value = "AUDIT_DATE")
    @ApiModelProperty(value="审核时间")
    private Date auditDate;

    /**
     * 清算时间
     */
    @TableField(value = "SETTLE_DATE")
    @ApiModelProperty(value="清算时间")
    private Date settleDate;

    /**
     * 更新时间
     */
    @TableField(value = "UPDATE_DATE")
    @ApiModelProperty(value="更新时间")
    private Date updateDate;

    /**
     * 终端号
     */
    @TableField(value = "TERMINAL_SERIL_NO")
    @ApiModelProperty(value="终端号")
    private String terminalSerilNo;

    /**
     * 推送ERP时间
     */
    @TableField(value = "TO_ERP_TIME")
    @ApiModelProperty(value="推送ERP时间")
    private Date toErpTime;

    /**
     * 同步ERP状态 0未同步，1同步成功，2同步失败
     */
    @TableField(value = "TO_ERP_STATUS")
    @ApiModelProperty(value="同步ERP状态 0未同步，1同步成功，2同步失败")
    private String toErpStatus;

    private static final long serialVersionUID = 1L;

    public static final String COL_AFTER_SALE_ORDER_ID = "AFTER_SALE_ORDER_ID";

    public static final String COL_CREATE_DATE = "CREATE_DATE";

    public static final String COL_ORDER_ID = "ORDER_ID";

    public static final String COL_EFUTURE_AFTERSALE_ID = "EFUTURE_AFTERSALE_ID";

    public static final String COL_STATUS = "STATUS";

    public static final String COL_APPLY_AMT = "APPLY_AMT";

    public static final String COL_REAL_REFUND_AMT = "REAL_REFUND_AMT";

    public static final String COL_DISCOUNT = "DISCOUNT";

    public static final String COL_GIFTAMOUNT = "GIFTAMOUNT";

    public static final String COL_POINTSCASH = "POINTSCASH";

    public static final String COL_CONSUMPOINTS = "CONSUMPOINTS";

    public static final String COL_DISCOUPON = "DISCOUPON";

    public static final String COL_PROCEDURE_FEE = "PROCEDURE_FEE";

    public static final String COL_DELIVERY_FEE = "DELIVERY_FEE";

    public static final String COL_PKG_FEE = "PKG_FEE";

    public static final String COL_PHONE = "PHONE";

    public static final String COL_LUNCH_BOX_FEE = "LUNCH_BOX_FEE";

    public static final String COL_APPLYER_TYPE = "APPLYER_TYPE";

    public static final String COL_APPLY_REASON = "APPLY_REASON";

    public static final String COL_PROCESS_REASON = "PROCESS_REASON";

    public static final String COL_OPERATOR = "OPERATOR";

    public static final String COL_IMG_URL = "IMG_URL";

    public static final String COL_CHANNEL_ID = "CHANNEL_ID";

    public static final String COL_INVOICE_STATE = "INVOICE_STATE";

    public static final String COL_INVOICE_DATE = "INVOICE_DATE";

    public static final String COL_AUDIT_DATE = "AUDIT_DATE";

    public static final String COL_SETTLE_DATE = "SETTLE_DATE";

    public static final String COL_UPDATE_DATE = "UPDATE_DATE";

    public static final String COL_TERMINAL_SERIL_NO = "TERMINAL_SERIL_NO";

    public static final String COL_TO_ERP_TIME = "TO_ERP_TIME";

    public static final String COL_TO_ERP_STATUS = "TO_ERP_STATUS";
}