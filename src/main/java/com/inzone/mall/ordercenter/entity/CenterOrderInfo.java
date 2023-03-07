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
    * 订单表
    */
@ApiModel(value="订单表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "order_info")
public class CenterOrderInfo implements Serializable {
    /**
     * 订单编号
     */
    @TableId(value = "order_id", type = IdType.INPUT)
    @ApiModelProperty(value="订单编号")
    private String orderId;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    @ApiModelProperty(value="创建时间")
    private Date gmtCreate;

    /**
     * 接入方业务线标识  xyzdj, "银座超市到家" yunguangjie 云逛街  inzone-app商城
     */
    @TableField(value = "channel_id")
    @ApiModelProperty(value="接入方业务线标识  xyzdj, '银座超市到家' yunguangjie 云逛街  inzone-app商城")
    private String channelId;

    /**
     * 入口应用标识 yunguangjieApplet，xyzdjApplet，yunguangjieApp，xyzdjApp，yunguangjieDaogou，yunguangjieH5
     */
    @TableField(value = "application_id")
    @ApiModelProperty(value="入口应用标识 yunguangjieApplet，xyzdjApplet，yunguangjieApp，xyzdjApp，yunguangjieDaogou，yunguangjieH5")
    private String applicationId;

    /**
     * 父订单编号
     */
    @TableField(value = "parent_order_id")
    @ApiModelProperty(value="父订单编号")
    private String parentOrderId;

    /**
     * 订单类型 1:一般订单  2：虚拟订单，3 预售订单  4 秒杀订单  5 拼团订单  127 其他
     */
    @TableField(value = "order_type")
    @ApiModelProperty(value="订单类型 1:一般订单  2：虚拟订单，3 预售订单  4 秒杀订单  5 拼团订单  127 其他")
    private Byte orderType;

    /**
     * 10：待付款，20：待接单，30：待发货，40：
     */
    @TableField(value = "order_status")
    @ApiModelProperty(value="10：待付款，20：待接单，30：待发货，40：")
    private Integer orderStatus;

    /**
     * 配送方式  1, "自提";  2, "快递";3, "外卖"
     */
    @TableField(value = "delivery_type")
    @ApiModelProperty(value="配送方式  1, '自提';  2, '快递';3, '外卖'")
    private Byte deliveryType;

    /**
     * 门店编号
     */
    @TableField(value = "store_id")
    @ApiModelProperty(value="门店编号")
    private String storeId;

    /**
     * 全渠道门店编码
     */
    @TableField(value = "store_code")
    @ApiModelProperty(value="全渠道门店编码")
    private String storeCode;

    /**
     * 前端应用用户ID
     */
    @TableField(value = "customer_id")
    @ApiModelProperty(value="前端应用用户ID")
    private String customerId;

    /**
     * 会员编号
     */
    @TableField(value = "cid")
    @ApiModelProperty(value="会员编号")
    private String cid;

    /**
     * 买家手机号
     */
    @TableField(value = "phone")
    @ApiModelProperty(value="买家手机号")
    private String phone;

    /**
     * 优惠前交易总金额（以分为单位存储）
     */
    @TableField(value = "total_amount")
    @ApiModelProperty(value="优惠前交易总金额（以分为单位存储）")
    private String totalAmount;

    /**
     * 实际交易支付金额
     */
    @TableField(value = "pay_amount")
    @ApiModelProperty(value="实际交易支付金额")
    private String payAmount;

    /**
     * 用户备注
     */
    @TableField(value = "user_remark")
    @ApiModelProperty(value="用户备注")
    private String userRemark;

    /**
     * 订单删除状态 0:未删除  1:已删除
     */
    @TableField(value = "delete_status")
    @ApiModelProperty(value="订单删除状态 0:未删除  1:已删除")
    private Byte deleteStatus;

    /**
     * 订单评论状态 0:未发表评论  1:已发表评论
     */
    @TableField(value = "comment_status")
    @ApiModelProperty(value="订单评论状态 0:未发表评论  1:已发表评论")
    private Byte commentStatus;

    /**
     * 返利金额（分）
     */
    @TableField(value = "giftamount")
    @ApiModelProperty(value="返利金额（分）")
    private String giftamount;

    /**
     * 积分
     */
    @TableField(value = "consumpoints")
    @ApiModelProperty(value="积分")
    private String consumpoints;

    /**
     * 优惠金额（分）
     */
    @TableField(value = "discoupon")
    @ApiModelProperty(value="优惠金额（分）")
    private String discoupon;

    /**
     * 折扣金额（分）
     */
    @TableField(value = "discount")
    @ApiModelProperty(value="折扣金额（分）")
    private String discount;

    /**
     * 积分抵现金额（分）
     */
    @TableField(value = "pointscash")
    @ApiModelProperty(value="积分抵现金额（分）")
    private String pointscash;

    /**
     * 订单取消类型  0用户手动取消  1超时未支付自动取消 2商家取消
     */
    @TableField(value = "cancel_type")
    @ApiModelProperty(value="订单取消类型  0用户手动取消  1超时未支付自动取消 2商家取消")
    private String cancelType;

    /**
     * 取消原因
     */
    @TableField(value = "cancel_reason")
    @ApiModelProperty(value="取消原因")
    private String cancelReason;

    /**
     * 提货码
     */
    @TableField(value = "pickupcode")
    @ApiModelProperty(value="提货码")
    private String pickupcode;

    /**
     * 使用的优惠券编号，多个逗号隔开
     */
    @TableField(value = "coupon_id")
    @ApiModelProperty(value="使用的优惠券编号，多个逗号隔开")
    private String couponId;

    /**
     * 专柜 id
     */
    @TableField(value = "shoppe_id")
    @ApiModelProperty(value="专柜 id")
    private String shoppeId;

    /**
     * 终端流水号
     */
    @TableField(value = "term_invoiceno")
    @ApiModelProperty(value="终端流水号")
    private String termInvoiceno;

    /**
     * 手续费
     */
    @TableField(value = "service_charge")
    @ApiModelProperty(value="手续费")
    private String serviceCharge;

    /**
     * 总运费
     */
    @TableField(value = "z_freight")
    @ApiModelProperty(value="总运费")
    private String zFreight;

    /**
     * 运费优惠(免邮券抵扣)
     */
    @TableField(value = "freight_discount")
    @ApiModelProperty(value="运费优惠(免邮券抵扣)")
    private String freightDiscount;

    /**
     * 包装费
     */
    @TableField(value = "package_fee")
    @ApiModelProperty(value="包装费")
    private String packageFee;

    /**
     * 餐盒费
     */
    @TableField(value = "lunchboxfee")
    @ApiModelProperty(value="餐盒费")
    private String lunchboxfee;

    /**
     * 扩展信息
     */
    @TableField(value = "ext_json")
    @ApiModelProperty(value="扩展信息")
    private String extJson;

    /**
     * 核销操作员手机号
     */
    @TableField(value = "write_off_phone")
    @ApiModelProperty(value="核销操作员手机号")
    private String writeOffPhone;

    /**
     * 履约渠道：dexin;
     */
    @TableField(value = "performance_channel")
    @ApiModelProperty(value="履约渠道：dexin;")
    private String performanceChannel;

    /**
     * 支付订单截止时间
     */
    @TableField(value = "expire_time")
    @ApiModelProperty(value="支付订单截止时间")
    private Date expireTime;

    /**
     * 订单取消时间
     */
    @TableField(value = "cancel_time")
    @ApiModelProperty(value="订单取消时间")
    private Date cancelTime;

    /**
     * 订单完成时间（自提收货，配送的确认收货）
     */
    @TableField(value = "finish_time")
    @ApiModelProperty(value="订单完成时间（自提收货，配送的确认收货）")
    private Date finishTime;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    @ApiModelProperty(value="更新时间")
    private Date gmtModified;

    /**
     * 推送ERP时间
     */
    @TableField(value = "to_erp_time")
    @ApiModelProperty(value="推送ERP时间")
    private Date toErpTime;

    /**
     * 同步ERP状态  0 待推送1 推送成功 2 推送失败  3 推送中
     */
    @TableField(value = "to_erp_status")
    @ApiModelProperty(value="同步ERP状态  0 待推送1 推送成功 2 推送失败  3 推送中")
    private String toErpStatus;

    /**
     * 直降
     */
    @TableField(value = "direct_descent")
    @ApiModelProperty(value="直降")
    private String directDescent;

    /**
     * 满减
     */
    @TableField(value = "full_minus")
    @ApiModelProperty(value="满减")
    private String fullMinus;

    /**
     * 满抵
     */
    @TableField(value = "full_arrival")
    @ApiModelProperty(value="满抵")
    private String fullArrival;

    /**
     * 满折
     */
    @TableField(value = "full_discount")
    @ApiModelProperty(value="满折")
    private String fullDiscount;

    /**
     * 目前认为是电子优惠券，根据后期需求进行调整
     */
    @TableField(value = "coupon_amount")
    @ApiModelProperty(value="目前认为是电子优惠券，根据后期需求进行调整")
    private String couponAmount;

    /**
     * 是否调用全渠道 0：不调用，1：调用。默认1
     */
    @TableField(value = "if_call_omni_channel")
    @ApiModelProperty(value="是否调用全渠道 0：不调用，1：调用。默认1")
    private String ifCallOmniChannel;

    /**
     * 秒杀服务订单号
     */
    @TableField(value = "order_sn")
    @ApiModelProperty(value="秒杀服务订单号")
    private String orderSn;

    private static final long serialVersionUID = 1L;

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_GMT_CREATE = "gmt_create";

    public static final String COL_CHANNEL_ID = "channel_id";

    public static final String COL_APPLICATION_ID = "application_id";

    public static final String COL_PARENT_ORDER_ID = "parent_order_id";

    public static final String COL_ORDER_TYPE = "order_type";

    public static final String COL_ORDER_STATUS = "order_status";

    public static final String COL_DELIVERY_TYPE = "delivery_type";

    public static final String COL_STORE_ID = "store_id";

    public static final String COL_STORE_CODE = "store_code";

    public static final String COL_CUSTOMER_ID = "customer_id";

    public static final String COL_CID = "cid";

    public static final String COL_PHONE = "phone";

    public static final String COL_TOTAL_AMOUNT = "total_amount";

    public static final String COL_PAY_AMOUNT = "pay_amount";

    public static final String COL_USER_REMARK = "user_remark";

    public static final String COL_DELETE_STATUS = "delete_status";

    public static final String COL_COMMENT_STATUS = "comment_status";

    public static final String COL_GIFTAMOUNT = "giftamount";

    public static final String COL_CONSUMPOINTS = "consumpoints";

    public static final String COL_DISCOUPON = "discoupon";

    public static final String COL_DISCOUNT = "discount";

    public static final String COL_POINTSCASH = "pointscash";

    public static final String COL_CANCEL_TYPE = "cancel_type";

    public static final String COL_CANCEL_REASON = "cancel_reason";

    public static final String COL_PICKUPCODE = "pickupcode";

    public static final String COL_COUPON_ID = "coupon_id";

    public static final String COL_SHOPPE_ID = "shoppe_id";

    public static final String COL_TERM_INVOICENO = "term_invoiceno";

    public static final String COL_SERVICE_CHARGE = "service_charge";

    public static final String COL_Z_FREIGHT = "z_freight";

    public static final String COL_FREIGHT_DISCOUNT = "freight_discount";

    public static final String COL_PACKAGE_FEE = "package_fee";

    public static final String COL_LUNCHBOXFEE = "lunchboxfee";

    public static final String COL_EXT_JSON = "ext_json";

    public static final String COL_WRITE_OFF_PHONE = "write_off_phone";

    public static final String COL_PERFORMANCE_CHANNEL = "performance_channel";

    public static final String COL_EXPIRE_TIME = "expire_time";

    public static final String COL_CANCEL_TIME = "cancel_time";

    public static final String COL_FINISH_TIME = "finish_time";

    public static final String COL_GMT_MODIFIED = "gmt_modified";

    public static final String COL_TO_ERP_TIME = "to_erp_time";

    public static final String COL_TO_ERP_STATUS = "to_erp_status";

    public static final String COL_DIRECT_DESCENT = "direct_descent";

    public static final String COL_FULL_MINUS = "full_minus";

    public static final String COL_FULL_ARRIVAL = "full_arrival";

    public static final String COL_FULL_DISCOUNT = "full_discount";

    public static final String COL_COUPON_AMOUNT = "coupon_amount";

    public static final String COL_IF_CALL_OMNI_CHANNEL = "if_call_omni_channel";

    public static final String COL_ORDER_SN = "order_sn";
}