package com.inzone.mall.yunguangjie.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import lombok.*;

/**
    * 订单表
    */
@ApiModel(value="订单表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "ORDER_INFO")
@EqualsAndHashCode
public class OrderInfo implements Serializable {
    /**
     * 订单编号
     */
    @TableId(value = "ORDER_ID", type = IdType.INPUT)
    @ApiModelProperty(value="订单编号")
    private String orderId;

    /**
     * 创建时间
     */
    @TableField(value = "GMT_CREATE")
    @ApiModelProperty(value="创建时间")
    private Date gmtCreate;

    /**
     * 接入方业务线标识  xyzdj, "银座超市到家" yunguangjie 云逛街  inzone-app商城
     */
    @TableField(value = "CHANNEL_ID")
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
    @TableField(value = "PARENT_ORDER_ID")
    @ApiModelProperty(value="父订单编号")
    private String parentOrderId;

    /**
     * 订单类型 1:一般订单  2：虚拟订单，3 预售订单  4 秒杀订单  5 拼团订单  127 其他
     */
    @TableField(value = "ORDER_TYPE")
    @ApiModelProperty(value="订单类型 1:一般订单  2：虚拟订单，3 预售订单  4 秒杀订单  5 拼团订单  127 其他")
    private Short orderType;

    /**
     * 10：待付款，20：待接单，30：待发货，40：
     */
    @TableField(value = "ORDER_STATUS")
    @ApiModelProperty(value="10：待付款，20：待接单，30：待发货，40：")
    private Long orderStatus;

    /**
     * 配送方式  1, "自提";  2, "快递";3, "外卖"
     */
    @TableField(value = "DELIVERY_TYPE")
    @ApiModelProperty(value="配送方式  1, '自提';  2, '快递';3, '外卖'")
    private Short deliveryType;

    /**
     * 门店编号
     */
    @TableField(value = "STORE_ID")
    @ApiModelProperty(value="门店编号")
    private String storeId;

    /**
     * 全渠道门店编码
     */
    @TableField(value = "STORE_CODE")
    @ApiModelProperty(value="全渠道门店编码")
    private String storeCode;

    /**
     * 前端应用用户ID
     */
    @TableField(value = "CUSTOMER_ID")
    @ApiModelProperty(value="前端应用用户ID")
    private String customerId;

    /**
     * 会员编号
     */
    @TableField(value = "CID")
    @ApiModelProperty(value="会员编号")
    private String cid;

    /**
     * 买家手机号
     */
    @TableField(value = "PHONE")
    @ApiModelProperty(value="买家手机号")
    private String phone;

    /**
     * 优惠前交易总金额（以分为单位存储）
     */
    @TableField(value = "TOTAL_AMOUNT")
    @ApiModelProperty(value="优惠前交易总金额（以分为单位存储）")
    private String totalAmount;

    /**
     * 实际交易支付金额
     */
    @TableField(value = "PAY_AMOUNT")
    @ApiModelProperty(value="实际交易支付金额")
    private String payAmount;

    /**
     * 用户备注
     */
    @TableField(value = "USER_REMARK")
    @ApiModelProperty(value="用户备注")
    private String userRemark;

    /**
     * 订单删除状态 0:未删除  1:已删除
     */
    @TableField(value = "DELETE_STATUS")
    @ApiModelProperty(value="订单删除状态 0:未删除  1:已删除")
    private Short deleteStatus;

    /**
     * 订单评论状态 0:未发表评论  1:已发表评论
     */
    @TableField(value = "COMMENT_STATUS")
    @ApiModelProperty(value="订单评论状态 0:未发表评论  1:已发表评论")
    private Short commentStatus;

    /**
     * 返利金额（分）
     */
    @TableField(value = "GIFTAMOUNT")
    @ApiModelProperty(value="返利金额（分）")
    private String giftamount;

    /**
     * 积分
     */
    @TableField(value = "CONSUMPOINTS")
    @ApiModelProperty(value="积分")
    private String consumpoints;

    /**
     * 优惠金额（分）
     */
    @TableField(value = "DISCOUPON")
    @ApiModelProperty(value="优惠金额（分）")
    private String discoupon;

    /**
     * 折扣金额（分）
     */
    @TableField(value = "DISCOUNT")
    @ApiModelProperty(value="折扣金额（分）")
    private String discount;

    /**
     * 积分抵现金额（分）
     */
    @TableField(value = "POINTSCASH")
    @ApiModelProperty(value="积分抵现金额（分）")
    private String pointscash;

    /**
     * 订单取消类型  0用户手动取消  1超时未支付自动取消 2商家取消
     */
    @TableField(value = "CANCEL_TYPE")
    @ApiModelProperty(value="订单取消类型  0用户手动取消  1超时未支付自动取消 2商家取消")
    private String cancelType;

    /**
     * 取消原因
     */
    @TableField(value = "CANCEL_REASON")
    @ApiModelProperty(value="取消原因")
    private String cancelReason;

    /**
     * 提货码
     */
    @TableField(value = "PICKUPCODE")
    @ApiModelProperty(value="提货码")
    private String pickupcode;

    /**
     * 使用的优惠券编号，多个逗号隔开
     */
    @TableField(value = "COUPON_ID")
    @ApiModelProperty(value="使用的优惠券编号，多个逗号隔开")
    private String couponId;

    /**
     * 专柜 id
     */
    @TableField(value = "SHOPPE_ID")
    @ApiModelProperty(value="专柜 id")
    private String shoppeId;

    /**
     * 终端流水号
     */
    @TableField(value = "TERM_INVOICENO")
    @ApiModelProperty(value="终端流水号")
    private String termInvoiceno;

    /**
     * 手续费
     */
    @TableField(value = "SERVICE_CHARGE")
    @ApiModelProperty(value="手续费")
    private String serviceCharge;

    /**
     * 总运费
     */
    @TableField(value = "Z_FREIGHT")
    @ApiModelProperty(value="总运费")
    private String zFreight;

    /**
     * 运费优惠(免邮券抵扣)
     */
    @TableField(value = "FREIGHT_DISCOUNT")
    @ApiModelProperty(value="运费优惠(免邮券抵扣)")
    private String freightDiscount;

    /**
     * 包装费
     */
    @TableField(value = "PACKAGE_FEE")
    @ApiModelProperty(value="包装费")
    private String packageFee;

    /**
     * 餐盒费
     */
    @TableField(value = "LUNCHBOXFEE")
    @ApiModelProperty(value="餐盒费")
    private String lunchboxfee;

    /**
     * 扩展信息
     */
    @TableField(value = "EXT_JSON")
    @ApiModelProperty(value="扩展信息")
    private String extJson;

    /**
     * 核销操作员手机号
     */
    @TableField(value = "WRITE_OFF_PHONE")
    @ApiModelProperty(value="核销操作员手机号")
    private String writeOffPhone;

    /**
     * 履约渠道：dexin;
     */
    @TableField(value = "PERFORMANCE_CHANNEL")
    @ApiModelProperty(value="履约渠道：dexin;")
    private String performanceChannel;

    /**
     * 支付订单截止时间
     */
    @TableField(value = "EXPIRE_TIME")
    @ApiModelProperty(value="支付订单截止时间")
    private Date expireTime;

    /**
     * 订单取消时间
     */
    @TableField(value = "CANCEL_TIME")
    @ApiModelProperty(value="订单取消时间")
    private Date cancelTime;

    /**
     * 订单完成时间（自提收货，配送的确认收货）
     */
    @TableField(value = "FINISH_TIME")
    @ApiModelProperty(value="订单完成时间（自提收货，配送的确认收货）")
    private Date finishTime;

    /**
     * 更新时间
     */
    @TableField(value = "GMT_MODIFIED")
    @ApiModelProperty(value="更新时间")
    private Date gmtModified;

    /**
     * 推送ERP时间
     */
    @TableField(value = "TO_ERP_TIME")
    @ApiModelProperty(value="推送ERP时间")
    private Date toErpTime;

    /**
     * 同步ERP状态  0 待推送1 推送成功 2 推送失败  3 推送中
     */
    @TableField(value = "TO_ERP_STATUS")
    @ApiModelProperty(value="同步ERP状态  0 待推送1 推送成功 2 推送失败  3 推送中")
    private String toErpStatus;

    /**
     * 直降
     */
    @TableField(value = "DIRECT_DESCENT")
    @ApiModelProperty(value="直降")
    private String directDescent;

    /**
     * 满减
     */
    @TableField(value = "FULL_MINUS")
    @ApiModelProperty(value="满减")
    private String fullMinus;

    /**
     * 满抵
     */
    @TableField(value = "FULL_ARRIVAL")
    @ApiModelProperty(value="满抵")
    private String fullArrival;

    /**
     * 满折
     */
    @TableField(value = "FULL_DISCOUNT")
    @ApiModelProperty(value="满折")
    private String fullDiscount;

    /**
     * 目前认为是电子优惠券，根据后期需求进行调整
     */
    @TableField(value = "COUPON_AMOUNT")
    @ApiModelProperty(value="目前认为是电子优惠券，根据后期需求进行调整")
    private String couponAmount;

    /**
     * 是否调用全渠道 0：不调用，1：调用。默认1
     */
    @TableField(value = "IF_CALL_OMNI_CHANNEL")
    @ApiModelProperty(value="是否调用全渠道 0：不调用，1：调用。默认1")
    private String ifCallOmniChannel;

    /**
     * 秒杀服务订单号
     */
    @TableField(value = "ORDER_SN")
    @ApiModelProperty(value="秒杀服务订单号")
    private String orderSn;

    private static final long serialVersionUID = 1L;

    public static final String COL_ORDER_ID = "ORDER_ID";

    public static final String COL_GMT_CREATE = "GMT_CREATE";

    public static final String COL_CHANNEL_ID = "CHANNEL_ID";

    public static final String COL_PARENT_ORDER_ID = "PARENT_ORDER_ID";

    public static final String COL_ORDER_TYPE = "ORDER_TYPE";

    public static final String COL_ORDER_STATUS = "ORDER_STATUS";

    public static final String COL_DELIVERY_TYPE = "DELIVERY_TYPE";

    public static final String COL_STORE_ID = "STORE_ID";

    public static final String COL_STORE_CODE = "STORE_CODE";

    public static final String COL_CUSTOMER_ID = "CUSTOMER_ID";

    public static final String COL_CID = "CID";

    public static final String COL_PHONE = "PHONE";

    public static final String COL_TOTAL_AMOUNT = "TOTAL_AMOUNT";

    public static final String COL_PAY_AMOUNT = "PAY_AMOUNT";

    public static final String COL_USER_REMARK = "USER_REMARK";

    public static final String COL_DELETE_STATUS = "DELETE_STATUS";

    public static final String COL_COMMENT_STATUS = "COMMENT_STATUS";

    public static final String COL_GIFTAMOUNT = "GIFTAMOUNT";

    public static final String COL_CONSUMPOINTS = "CONSUMPOINTS";

    public static final String COL_DISCOUPON = "DISCOUPON";

    public static final String COL_DISCOUNT = "DISCOUNT";

    public static final String COL_POINTSCASH = "POINTSCASH";

    public static final String COL_CANCEL_TYPE = "CANCEL_TYPE";

    public static final String COL_CANCEL_REASON = "CANCEL_REASON";

    public static final String COL_PICKUPCODE = "PICKUPCODE";

    public static final String COL_COUPON_ID = "COUPON_ID";

    public static final String COL_SHOPPE_ID = "SHOPPE_ID";

    public static final String COL_TERM_INVOICENO = "TERM_INVOICENO";

    public static final String COL_SERVICE_CHARGE = "SERVICE_CHARGE";

    public static final String COL_Z_FREIGHT = "Z_FREIGHT";

    public static final String COL_FREIGHT_DISCOUNT = "FREIGHT_DISCOUNT";

    public static final String COL_PACKAGE_FEE = "PACKAGE_FEE";

    public static final String COL_LUNCHBOXFEE = "LUNCHBOXFEE";

    public static final String COL_EXT_JSON = "EXT_JSON";

    public static final String COL_WRITE_OFF_PHONE = "WRITE_OFF_PHONE";

    public static final String COL_PERFORMANCE_CHANNEL = "PERFORMANCE_CHANNEL";

    public static final String COL_EXPIRE_TIME = "EXPIRE_TIME";

    public static final String COL_CANCEL_TIME = "CANCEL_TIME";

    public static final String COL_FINISH_TIME = "FINISH_TIME";

    public static final String COL_GMT_MODIFIED = "GMT_MODIFIED";

    public static final String COL_TO_ERP_TIME = "TO_ERP_TIME";

    public static final String COL_TO_ERP_STATUS = "TO_ERP_STATUS";

    public static final String COL_DIRECT_DESCENT = "DIRECT_DESCENT";

    public static final String COL_FULL_MINUS = "FULL_MINUS";

    public static final String COL_FULL_ARRIVAL = "FULL_ARRIVAL";

    public static final String COL_FULL_DISCOUNT = "FULL_DISCOUNT";

    public static final String COL_COUPON_AMOUNT = "COUPON_AMOUNT";

    public static final String COL_IF_CALL_OMNI_CHANNEL = "IF_CALL_OMNI_CHANNEL";

    public static final String COL_ORDER_SN = "ORDER_SN";
}