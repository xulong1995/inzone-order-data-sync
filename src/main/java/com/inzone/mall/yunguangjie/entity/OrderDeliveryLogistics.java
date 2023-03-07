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
@TableName(value = "ORDER_DELIVERY_LOGISTICS")
public class OrderDeliveryLogistics implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.INPUT)
    @ApiModelProperty(value="主键ID")
    private BigDecimal id;

    /**
     * 订单编号
     */
    @TableField(value = "ORDER_ID")
    @ApiModelProperty(value="订单编号")
    private String orderId;

    /**
     * 订单明细编码
     */
    @TableField(value = "ORDER_ITEM_ID")
    @ApiModelProperty(value="订单明细编码")
    private String orderItemId;

    /**
     * 微信token
     */
    @TableField(value = "WX_TOKEN")
    @ApiModelProperty(value="微信token")
    private String wxToken;

    /**
     * 运单号
     */
    @TableField(value = "LOGISTICS_SN")
    @ApiModelProperty(value="运单号")
    private String logisticsSn;

    /**
     * 签收时间
     */
    @TableField(value = "SIGNED_TIME")
    @ApiModelProperty(value="签收时间")
    private Date signedTime;

    /**
     * 更新时间
     */
    @TableField(value = "UPDATE_DATE")
    @ApiModelProperty(value="更新时间")
    private Date updateDate;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_DATE")
    @ApiModelProperty(value="创建时间")
    private Date createDate;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "ID";

    public static final String COL_ORDER_ID = "ORDER_ID";

    public static final String COL_ORDER_ITEM_ID = "ORDER_ITEM_ID";

    public static final String COL_WX_TOKEN = "WX_TOKEN";

    public static final String COL_LOGISTICS_SN = "LOGISTICS_SN";

    public static final String COL_SIGNED_TIME = "SIGNED_TIME";

    public static final String COL_UPDATE_DATE = "UPDATE_DATE";

    public static final String COL_CREATE_DATE = "CREATE_DATE";
}