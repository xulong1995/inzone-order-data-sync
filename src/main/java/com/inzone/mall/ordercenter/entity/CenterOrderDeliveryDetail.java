package com.inzone.mall.ordercenter.entity;

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
@TableName(value = "order_delivery_detail")
public class CenterOrderDeliveryDetail implements Serializable {
    /**
     * 订单编号
     */
    @TableId(value = "order_id", type = IdType.INPUT)
    @ApiModelProperty(value="订单编号")
    private String orderId;

    /**
     * 配送类型 1自提 2 快递 3 美团配送 4商家自配送 
     */
    @TableField(value = "delivery_type")
    @ApiModelProperty(value="配送类型 1自提 2 快递 3 美团配送 4商家自配送 ")
    private Byte deliveryType;

    /**
     * 省
     */
    @TableField(value = "province")
    @ApiModelProperty(value="省")
    private String province;

    /**
     * 市
     */
    @TableField(value = "city")
    @ApiModelProperty(value="市")
    private String city;

    /**
     * 区
     */
    @TableField(value = "area")
    @ApiModelProperty(value="区")
    private String area;

    /**
     * 街道
     */
    @TableField(value = "street")
    @ApiModelProperty(value="街道")
    private String street;

    /**
     * 详细地址
     */
    @TableField(value = "detail_address")
    @ApiModelProperty(value="详细地址")
    private String detailAddress;

    /**
     * 经度
     */
    @TableField(value = "lon")
    @ApiModelProperty(value="经度")
    private BigDecimal lon;

    /**
     * 维度
     */
    @TableField(value = "lat")
    @ApiModelProperty(value="维度")
    private BigDecimal lat;

    /**
     * 收货人姓名
     */
    @TableField(value = "receiver_name")
    @ApiModelProperty(value="收货人姓名")
    private String receiverName;

    /**
     * 收货人电话
     */
    @TableField(value = "receiver_phone")
    @ApiModelProperty(value="收货人电话")
    private String receiverPhone;

    /**
     * 调整地址次数
     */
    @TableField(value = "modify_address_count")
    @ApiModelProperty(value="调整地址次数")
    private Byte modifyAddressCount;

    /**
     * 操作人手机号
     */
    @TableField(value = "`operator`")
    @ApiModelProperty(value="操作人手机号")
    private String operator;

    /**
     * 配送员编号
     */
    @TableField(value = "deliverer_no")
    @ApiModelProperty(value="配送员编号")
    private String delivererNo;

    /**
     * 配送员姓名
     */
    @TableField(value = "deliverer_name")
    @ApiModelProperty(value="配送员姓名")
    private String delivererName;

    /**
     * 配送员手机号
     */
    @TableField(value = "deliverer_phone")
    @ApiModelProperty(value="配送员手机号")
    private String delivererPhone;

    /**
     * 出库时间
     */
    @TableField(value = "out_stock_time")
    @ApiModelProperty(value="出库时间")
    private Date outStockTime;

    /**
     * 配送时间
     */
    @TableField(value = "deliverer_time")
    @ApiModelProperty(value="配送时间")
    private Date delivererTime;

    /**
     * 期望配送时间
     */
    @TableField(value = "expected_deliverer_time")
    @ApiModelProperty(value="期望配送时间")
    private Date expectedDelivererTime;

    /**
     * 接单时间
     */
    @TableField(value = "receiving_time")
    @ApiModelProperty(value="接单时间")
    private Date receivingTime;

    /**
     * 签收时间
     */
    @TableField(value = "signed_time")
    @ApiModelProperty(value="签收时间")
    private Date signedTime;

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

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_DELIVERY_TYPE = "delivery_type";

    public static final String COL_PROVINCE = "province";

    public static final String COL_CITY = "city";

    public static final String COL_AREA = "area";

    public static final String COL_STREET = "street";

    public static final String COL_DETAIL_ADDRESS = "detail_address";

    public static final String COL_LON = "lon";

    public static final String COL_LAT = "lat";

    public static final String COL_RECEIVER_NAME = "receiver_name";

    public static final String COL_RECEIVER_PHONE = "receiver_phone";

    public static final String COL_MODIFY_ADDRESS_COUNT = "modify_address_count";

    public static final String COL_OPERATOR = "operator";

    public static final String COL_DELIVERER_NO = "deliverer_no";

    public static final String COL_DELIVERER_NAME = "deliverer_name";

    public static final String COL_DELIVERER_PHONE = "deliverer_phone";

    public static final String COL_OUT_STOCK_TIME = "out_stock_time";

    public static final String COL_DELIVERER_TIME = "deliverer_time";

    public static final String COL_EXPECTED_DELIVERER_TIME = "expected_deliverer_time";

    public static final String COL_RECEIVING_TIME = "receiving_time";

    public static final String COL_SIGNED_TIME = "signed_time";

    public static final String COL_GMT_CREATE = "gmt_create";

    public static final String COL_GMT_MODIFIED = "gmt_modified";

    public static final String COL_TO_ERP_TIME = "to_erp_time";

    public static final String COL_TO_ERP_STATUS = "to_erp_status";
}