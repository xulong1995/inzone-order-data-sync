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
    * 订单配送信息表
    */
@ApiModel(value="订单配送信息表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "order_delivery_logistics")
public class CenterOrderDeliveryLogistics implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键ID")
    private Long id;

    /**
     * 订单编号
     */
    @TableField(value = "order_id")
    @ApiModelProperty(value="订单编号")
    private String orderId;

    /**
     * 订单明细编码
     */
    @TableField(value = "order_item_id")
    @ApiModelProperty(value="订单明细编码")
    private String orderItemId;

    /**
     * 微信token
     */
    @TableField(value = "wx_token")
    @ApiModelProperty(value="微信token")
    private String wxToken;

    /**
     * 运单号
     */
    @TableField(value = "logistics_sn")
    @ApiModelProperty(value="运单号")
    private String logisticsSn;

    /**
     * 签收时间
     */
    @TableField(value = "signed_time")
    @ApiModelProperty(value="签收时间")
    private Date signedTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_date")
    @ApiModelProperty(value="更新时间")
    private Date updateDate;

    /**
     * 创建时间
     */
    @TableField(value = "create_date")
    @ApiModelProperty(value="创建时间")
    private Date createDate;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_ORDER_ITEM_ID = "order_item_id";

    public static final String COL_WX_TOKEN = "wx_token";

    public static final String COL_LOGISTICS_SN = "logistics_sn";

    public static final String COL_SIGNED_TIME = "signed_time";

    public static final String COL_UPDATE_DATE = "update_date";

    public static final String COL_CREATE_DATE = "create_date";
}