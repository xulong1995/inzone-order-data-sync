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
    * 订单售后表
    */
@ApiModel(value="订单售后表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "after_sale_order_info")
public class CenterAfterSaleOrderInfo implements Serializable {
    /**
     * 售后单号
     */
    @TableId(value = "after_sale_order_id", type = IdType.INPUT)
    @ApiModelProperty(value="售后单号")
    private String afterSaleOrderId;

    /**
     * 申请售后时间
     */
    @TableField(value = "create_date")
    @ApiModelProperty(value="申请售后时间")
    private Date createDate;

    /**
     * 订单号
     */
    @TableField(value = "order_id")
    @ApiModelProperty(value="订单号")
    private String orderId;

    /**
     * 全渠道退货单号
     */
    @TableField(value = "efuture_aftersale_id")
    @ApiModelProperty(value="全渠道退货单号")
    private String efutureAftersaleId;

    /**
     * 售后单状态(30:审核驳回;40:退款中;41:退款退货中;50:已退款;51:已退款退货;60:退款失败;61:退款退货失败;127:撤销售后申请)
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="售后单状态(30:审核驳回;40:退款中;41:退款退货中;50:已退款;51:已退款退货;60:退款失败;61:退款退货失败;127:撤销售后申请)")
    private String status;

    /**
     * 门店ID
     */
    @TableField(value = "store_id")
    @ApiModelProperty(value="门店ID")
    private String storeId;

    /**
     * 专柜ID
     */
    @TableField(value = "shopp_id")
    @ApiModelProperty(value="专柜ID")
    private String shoppId;

    /**
     * 前端应用客户ID
     */
    @TableField(value = "customer_id")
    @ApiModelProperty(value="前端应用客户ID")
    private String customerId;

    /**
     * 申请退款金额,单位分
     */
    @TableField(value = "apply_amt")
    @ApiModelProperty(value="申请退款金额,单位分")
    private String applyAmt;

    /**
     * 实际退款金额,单位分
     */
    @TableField(value = "real_refund_amt")
    @ApiModelProperty(value="实际退款金额,单位分")
    private String realRefundAmt;

    /**
     * 折扣金额（分）
     */
    @TableField(value = "discount")
    @ApiModelProperty(value="折扣金额（分）")
    private String discount;

    /**
     * 扣回金额
     */
    @TableField(value = "deduct")
    @ApiModelProperty(value="扣回金额")
    private String deduct;

    /**
     * 返利金额（分）
     */
    @TableField(value = "giftamount")
    @ApiModelProperty(value="返利金额（分）")
    private String giftamount;

    /**
     * 积分抵现金额（分）
     */
    @TableField(value = "pointscash")
    @ApiModelProperty(value="积分抵现金额（分）")
    private String pointscash;

    /**
     * 积分
     */
    @TableField(value = "consumpoints")
    @ApiModelProperty(value="积分")
    private String consumpoints;

    /**
     * 券优惠金额（分）
     */
    @TableField(value = "discoupon")
    @ApiModelProperty(value="券优惠金额（分）")
    private String discoupon;

    /**
     * 退款手续费,单位分
     */
    @TableField(value = "procedure_fee")
    @ApiModelProperty(value="退款手续费,单位分")
    private String procedureFee;

    /**
     * 运费,单位分,每个订单一个运费
     */
    @TableField(value = "delivery_fee")
    @ApiModelProperty(value="运费,单位分,每个订单一个运费")
    private String deliveryFee;

    /**
     * 包装费，单位分，每个订单一个包装费
     */
    @TableField(value = "pkg_fee")
    @ApiModelProperty(value="包装费，单位分，每个订单一个包装费")
    private String pkgFee;

    /**
     * 购买用户手机号
     */
    @TableField(value = "phone")
    @ApiModelProperty(value="购买用户手机号")
    private String phone;

    /**
     * 餐盒费，单位分，每个商品一个餐盒费
     */
    @TableField(value = "lunch_box_fee")
    @ApiModelProperty(value="餐盒费，单位分，每个商品一个餐盒费")
    private String lunchBoxFee;

    /**
     * 申请方式：买家申请buyer， 商家申请 seller
     */
    @TableField(value = "applyer_type")
    @ApiModelProperty(value="申请方式：买家申请buyer， 商家申请 seller")
    private String applyerType;

    /**
     * 申请原因
     */
    @TableField(value = "apply_reason")
    @ApiModelProperty(value="申请原因")
    private String applyReason;

    /**
     * 审核意见原因
     */
    @TableField(value = "process_reason")
    @ApiModelProperty(value="审核意见原因")
    private String processReason;

    /**
     * 审核人员工号
     */
    @TableField(value = "`operator`")
    @ApiModelProperty(value="审核人员工号")
    private String operator;

    /**
     * 凭证图片地址，多个英文逗号隔开
     */
    @TableField(value = "img_url")
    @ApiModelProperty(value="凭证图片地址，多个英文逗号隔开")
    private String imgUrl;

    /**
     * 接入方业务线标识  xyzdj, "银座超市到家" yunguangjie 云逛街  inzone-app商城
     */
    @TableField(value = "channel_id")
    @ApiModelProperty(value="接入方业务线标识  xyzdj, '银座超市到家' yunguangjie 云逛街  inzone-app商城")
    private String channelId;

    /**
     * 红冲发票状态0没有发起红冲;1红冲成功;2红冲失败;3蓝票不存在，审核通过时，会先红冲，再退款
     */
    @TableField(value = "invoice_state")
    @ApiModelProperty(value="红冲发票状态0没有发起红冲;1红冲成功;2红冲失败;3蓝票不存在，审核通过时，会先红冲，再退款")
    private String invoiceState;

    /**
     * 红冲发票时间
     */
    @TableField(value = "invoice_date")
    @ApiModelProperty(value="红冲发票时间")
    private Date invoiceDate;

    /**
     * 审核时间
     */
    @TableField(value = "audit_date")
    @ApiModelProperty(value="审核时间")
    private Date auditDate;

    /**
     * 清算时间
     */
    @TableField(value = "settle_date")
    @ApiModelProperty(value="清算时间")
    private Date settleDate;

    /**
     * 更新时间
     */
    @TableField(value = "update_date")
    @ApiModelProperty(value="更新时间")
    private Date updateDate;

    /**
     * 终端号
     */
    @TableField(value = "terminal_seril_no")
    @ApiModelProperty(value="终端号")
    private String terminalSerilNo;

    /**
     * 推送ERP时间
     */
    @TableField(value = "to_erp_time")
    @ApiModelProperty(value="推送ERP时间")
    private Date toErpTime;

    /**
     * 同步ERP状态 0未同步，1同步成功，2同步失败
     */
    @TableField(value = "to_erp_status")
    @ApiModelProperty(value="同步ERP状态 0未同步，1同步成功，2同步失败")
    private String toErpStatus;

    private static final long serialVersionUID = 1L;

    public static final String COL_AFTER_SALE_ORDER_ID = "after_sale_order_id";

    public static final String COL_CREATE_DATE = "create_date";

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_EFUTURE_AFTERSALE_ID = "efuture_aftersale_id";

    public static final String COL_STATUS = "status";

    public static final String COL_STORE_ID = "store_id";

    public static final String COL_SHOPP_ID = "shopp_id";

    public static final String COL_CUSTOMER_ID = "customer_id";

    public static final String COL_APPLY_AMT = "apply_amt";

    public static final String COL_REAL_REFUND_AMT = "real_refund_amt";

    public static final String COL_DISCOUNT = "discount";

    public static final String COL_DEDUCT = "deduct";

    public static final String COL_GIFTAMOUNT = "giftamount";

    public static final String COL_POINTSCASH = "pointscash";

    public static final String COL_CONSUMPOINTS = "consumpoints";

    public static final String COL_DISCOUPON = "discoupon";

    public static final String COL_PROCEDURE_FEE = "procedure_fee";

    public static final String COL_DELIVERY_FEE = "delivery_fee";

    public static final String COL_PKG_FEE = "pkg_fee";

    public static final String COL_PHONE = "phone";

    public static final String COL_LUNCH_BOX_FEE = "lunch_box_fee";

    public static final String COL_APPLYER_TYPE = "applyer_type";

    public static final String COL_APPLY_REASON = "apply_reason";

    public static final String COL_PROCESS_REASON = "process_reason";

    public static final String COL_OPERATOR = "operator";

    public static final String COL_IMG_URL = "img_url";

    public static final String COL_CHANNEL_ID = "channel_id";

    public static final String COL_INVOICE_STATE = "invoice_state";

    public static final String COL_INVOICE_DATE = "invoice_date";

    public static final String COL_AUDIT_DATE = "audit_date";

    public static final String COL_SETTLE_DATE = "settle_date";

    public static final String COL_UPDATE_DATE = "update_date";

    public static final String COL_TERMINAL_SERIL_NO = "terminal_seril_no";

    public static final String COL_TO_ERP_TIME = "to_erp_time";

    public static final String COL_TO_ERP_STATUS = "to_erp_status";
}