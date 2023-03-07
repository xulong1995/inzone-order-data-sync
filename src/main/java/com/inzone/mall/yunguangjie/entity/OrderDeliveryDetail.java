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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 订单配送信息表
    */
@ApiModel(value="订单配送信息表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "ORDER_DELIVERY_DETAIL")
public class OrderDeliveryDetail implements Serializable {
    /**
     * 订单编号
     */
    @TableId(value = "ORDER_ID", type = IdType.INPUT)
    @ApiModelProperty(value="订单编号")
    private String orderId;

    /**
     * 配送类型 1自提 2 快递 3 美团配送 4商家自配送 
     */
    @TableField(value = "DELIVERY_TYPE")
    @ApiModelProperty(value="配送类型 1自提 2 快递 3 美团配送 4商家自配送 ")
    private Short deliveryType;

    /**
     * 省
     */
    @TableField(value = "PROVINCE")
    @ApiModelProperty(value="省")
    private String province;

    /**
     * 市
     */
    @TableField(value = "CITY")
    @ApiModelProperty(value="市")
    private String city;

    /**
     * 区
     */
    @TableField(value = "AREA")
    @ApiModelProperty(value="区")
    private String area;

    /**
     * 街道
     */
    @TableField(value = "STREET")
    @ApiModelProperty(value="街道")
    private String street;

    /**
     * 详细地址
     */
    @TableField(value = "DETAIL_ADDRESS")
    @ApiModelProperty(value="详细地址")
    private String detailAddress;

    /**
     * 经度
     */
    @TableField(value = "LON")
    @ApiModelProperty(value="经度")
    private BigDecimal lon;

    /**
     * 维度
     */
    @TableField(value = "LAT")
    @ApiModelProperty(value="维度")
    private BigDecimal lat;

    /**
     * 收货人姓名
     */
    @TableField(value = "RECEIVER_NAME")
    @ApiModelProperty(value="收货人姓名")
    private String receiverName;

    /**
     * 收货人电话
     */
    @TableField(value = "RECEIVER_PHONE")
    @ApiModelProperty(value="收货人电话")
    private String receiverPhone;

    /**
     * 调整地址次数
     */
    @TableField(value = "MODIFY_ADDRESS_COUNT")
    @ApiModelProperty(value="调整地址次数")
    private Short modifyAddressCount;

    /**
     * 操作人手机号
     */
    @TableField(value = "\"OPERATOR\"")
    @ApiModelProperty(value="操作人手机号")
    private String operator;

    /**
     * 配送员编号
     */
    @TableField(value = "DELIVERER_NO")
    @ApiModelProperty(value="配送员编号")
    private String delivererNo;

    /**
     * 配送员姓名
     */
    @TableField(value = "DELIVERER_NAME")
    @ApiModelProperty(value="配送员姓名")
    private String delivererName;

    /**
     * 配送员手机号
     */
    @TableField(value = "DELIVERER_PHONE")
    @ApiModelProperty(value="配送员手机号")
    private String delivererPhone;

    /**
     * 出库时间
     */
    @TableField(value = "OUT_STOCK_TIME")
    @ApiModelProperty(value="出库时间")
    private Date outStockTime;

    /**
     * 配送时间
     */
    @TableField(value = "DELIVERER_TIME")
    @ApiModelProperty(value="配送时间")
    private Date delivererTime;

    /**
     * 期望配送时间
     */
    @TableField(value = "EXPECTED_DELIVERER_TIME")
    @ApiModelProperty(value="期望配送时间")
    private Date expectedDelivererTime;

    /**
     * 接单时间
     */
    @TableField(value = "RECEIVING_TIME")
    @ApiModelProperty(value="接单时间")
    private Date receivingTime;

    /**
     * 签收时间
     */
    @TableField(value = "SIGNED_TIME")
    @ApiModelProperty(value="签收时间")
    private Date signedTime;

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

    public static final String COL_ORDER_ID = "ORDER_ID";

    public static final String COL_DELIVERY_TYPE = "DELIVERY_TYPE";

    public static final String COL_PROVINCE = "PROVINCE";

    public static final String COL_CITY = "CITY";

    public static final String COL_AREA = "AREA";

    public static final String COL_STREET = "STREET";

    public static final String COL_DETAIL_ADDRESS = "DETAIL_ADDRESS";

    public static final String COL_LON = "LON";

    public static final String COL_LAT = "LAT";

    public static final String COL_RECEIVER_NAME = "RECEIVER_NAME";

    public static final String COL_RECEIVER_PHONE = "RECEIVER_PHONE";

    public static final String COL_MODIFY_ADDRESS_COUNT = "MODIFY_ADDRESS_COUNT";

    public static final String COL_OPERATOR = "OPERATOR";

    public static final String COL_DELIVERER_NO = "DELIVERER_NO";

    public static final String COL_DELIVERER_NAME = "DELIVERER_NAME";

    public static final String COL_DELIVERER_PHONE = "DELIVERER_PHONE";

    public static final String COL_OUT_STOCK_TIME = "OUT_STOCK_TIME";

    public static final String COL_DELIVERER_TIME = "DELIVERER_TIME";

    public static final String COL_EXPECTED_DELIVERER_TIME = "EXPECTED_DELIVERER_TIME";

    public static final String COL_RECEIVING_TIME = "RECEIVING_TIME";

    public static final String COL_SIGNED_TIME = "SIGNED_TIME";

    public static final String COL_GMT_CREATE = "GMT_CREATE";

    public static final String COL_GMT_MODIFIED = "GMT_MODIFIED";

    public static final String COL_TO_ERP_TIME = "TO_ERP_TIME";

    public static final String COL_TO_ERP_STATUS = "TO_ERP_STATUS";
}