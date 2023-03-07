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
    * 订单售后条目表
    */
@ApiModel(value="订单售后条目表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "after_sale_order_item")
public class CenterAfterSaleOrderItem implements Serializable {
    /**
     * 订单id
     */
    @TableId(value = "after_sale_item_id", type = IdType.INPUT)
    @ApiModelProperty(value="订单id")
    private String afterSaleItemId;

    /**
     * 创建时间
     */
    @TableField(value = "create_date")
    @ApiModelProperty(value="创建时间")
    private Date createDate;

    /**
     * 售后id
     */
    @TableField(value = "after_sale_order_id")
    @ApiModelProperty(value="售后id")
    private String afterSaleOrderId;

    /**
     * 订单详情编码
     */
    @TableField(value = "order_item_id")
    @ApiModelProperty(value="订单详情编码")
    private String orderItemId;

    /**
     * 订单编码
     */
    @TableField(value = "order_id")
    @ApiModelProperty(value="订单编码")
    private String orderId;

    /**
     * sku编码
     */
    @TableField(value = "sku_id")
    @ApiModelProperty(value="sku编码")
    private String skuId;

    /**
     * 全渠道/ERP的商品编码
     */
    @TableField(value = "sku_code")
    @ApiModelProperty(value="全渠道/ERP的商品编码")
    private String skuCode;

    /**
     * sku商品名称
     */
    @TableField(value = "sku_name")
    @ApiModelProperty(value="sku商品名称")
    private String skuName;

    /**
     * spu编码
     */
    @TableField(value = "spu_id")
    @ApiModelProperty(value="spu编码")
    private String spuId;

    /**
     * spu名称
     */
    @TableField(value = "spu_name")
    @ApiModelProperty(value="spu名称")
    private String spuName;

    /**
     * spu图片链接
     */
    @TableField(value = "spu_img_url")
    @ApiModelProperty(value="spu图片链接")
    private String spuImgUrl;

    /**
     * 商品价格
     */
    @TableField(value = "sku_price")
    @ApiModelProperty(value="商品价格")
    private String skuPrice;

    /**
     * 申请售后的数量
     */
    @TableField(value = "`number`")
    @ApiModelProperty(value="申请售后的数量")
    private String number;

    /**
     * 单位
     */
    @TableField(value = "unit")
    @ApiModelProperty(value="单位")
    private String unit;

    /**
     * 申请售后金额,单位分
     */
    @TableField(value = "apply_amt")
    @ApiModelProperty(value="申请售后金额,单位分")
    private String applyAmt;

    /**
     * 实际退款金额,单位分
     */
    @TableField(value = "real_refund_amt")
    @ApiModelProperty(value="实际退款金额,单位分")
    private String realRefundAmt;

    /**
     * 餐盒费,单位分
     */
    @TableField(value = "lunch_box_fee")
    @ApiModelProperty(value="餐盒费,单位分")
    private String lunchBoxFee;

    /**
     * 更新时间
     */
    @TableField(value = "update_date")
    @ApiModelProperty(value="更新时间")
    private Date updateDate;

    /**
     *  1:普通商品,2:预售商品 3:组合商品
     */
    @TableField(value = "product_type")
    @ApiModelProperty(value=" 1:普通商品,2:预售商品 3:组合商品")
    private String productType;

    /**
     * 消费积分数量
     */
    @TableField(value = "consumpoints")
    @ApiModelProperty(value="消费积分数量")
    private String consumpoints;

    /**
     * 商品促销活动折扣金额
     */
    @TableField(value = "discount")
    @ApiModelProperty(value="商品促销活动折扣金额")
    private String discount;

    /**
     * 商品使用优惠券，优惠分摊金额
     */
    @TableField(value = "discoupon")
    @ApiModelProperty(value="商品使用优惠券，优惠分摊金额")
    private String discoupon;

    /**
     * 积分抵现金额，单位分
     */
    @TableField(value = "pointscash")
    @ApiModelProperty(value="积分抵现金额，单位分")
    private String pointscash;

    private static final long serialVersionUID = 1L;

    public static final String COL_AFTER_SALE_ITEM_ID = "after_sale_item_id";

    public static final String COL_CREATE_DATE = "create_date";

    public static final String COL_AFTER_SALE_ORDER_ID = "after_sale_order_id";

    public static final String COL_ORDER_ITEM_ID = "order_item_id";

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_SKU_ID = "sku_id";

    public static final String COL_SKU_CODE = "sku_code";

    public static final String COL_SKU_NAME = "sku_name";

    public static final String COL_SPU_ID = "spu_id";

    public static final String COL_SPU_NAME = "spu_name";

    public static final String COL_SPU_IMG_URL = "spu_img_url";

    public static final String COL_SKU_PRICE = "sku_price";

    public static final String COL_NUMBER = "number";

    public static final String COL_UNIT = "unit";

    public static final String COL_APPLY_AMT = "apply_amt";

    public static final String COL_REAL_REFUND_AMT = "real_refund_amt";

    public static final String COL_LUNCH_BOX_FEE = "lunch_box_fee";

    public static final String COL_UPDATE_DATE = "update_date";

    public static final String COL_PRODUCT_TYPE = "product_type";

    public static final String COL_CONSUMPOINTS = "consumpoints";

    public static final String COL_DISCOUNT = "discount";

    public static final String COL_DISCOUPON = "discoupon";

    public static final String COL_POINTSCASH = "pointscash";
}