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
    * 订单售后条目表
    */
@ApiModel(value="订单售后条目表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "AFTER_SALE_ORDER_ITEM")
public class AfterSaleOrderItem implements Serializable {
    /**
     * 订单id
     */
    @TableId(value = "AFTER_SALE_ITEM_ID", type = IdType.INPUT)
    @ApiModelProperty(value="订单id")
    private String afterSaleItemId;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_DATE")
    @ApiModelProperty(value="创建时间")
    private Date createDate;

    /**
     * 售后id
     */
    @TableField(value = "AFTER_SALE_ORDER_ID")
    @ApiModelProperty(value="售后id")
    private String afterSaleOrderId;

    /**
     * 订单详情编码
     */
    @TableField(value = "ORDER_ITEM_ID")
    @ApiModelProperty(value="订单详情编码")
    private String orderItemId;

    /**
     * 订单编码
     */
    @TableField(value = "ORDER_ID")
    @ApiModelProperty(value="订单编码")
    private String orderId;

    /**
     * sku编码
     */
    @TableField(value = "SKU_ID")
    @ApiModelProperty(value="sku编码")
    private String skuId;

    /**
     * 全渠道/ERP的商品编码
     */
    @TableField(value = "SKU_CODE")
    @ApiModelProperty(value="全渠道/ERP的商品编码")
    private String skuCode;

    /**
     * sku商品名称
     */
    @TableField(value = "SKU_NAME")
    @ApiModelProperty(value="sku商品名称")
    private String skuName;

    /**
     * spu编码
     */
    @TableField(value = "SPU_ID")
    @ApiModelProperty(value="spu编码")
    private String spuId;

    /**
     * spu名称
     */
    @TableField(value = "SPU_NAME")
    @ApiModelProperty(value="spu名称")
    private String spuName;

    /**
     * spu图片链接
     */
    @TableField(value = "SPU_IMG_URL")
    @ApiModelProperty(value="spu图片链接")
    private String spuImgUrl;

    /**
     * 商品价格
     */
    @TableField(value = "SKU_PRICE")
    @ApiModelProperty(value="商品价格")
    private String skuPrice;

    /**
     * 单位
     */
    @TableField(value = "UNIT")
    @ApiModelProperty(value="单位")
    private String unit;

    /**
     * 申请售后金额,单位分
     */
    @TableField(value = "APPLY_AMT")
    @ApiModelProperty(value="申请售后金额,单位分")
    private String applyAmt;

    /**
     * 实际退款金额,单位分
     */
    @TableField(value = "REAL_REFUND_AMT")
    @ApiModelProperty(value="实际退款金额,单位分")
    private String realRefundAmt;

    /**
     * 餐盒费,单位分
     */
    @TableField(value = "LUNCH_BOX_FEE")
    @ApiModelProperty(value="餐盒费,单位分")
    private String lunchBoxFee;

    /**
     * 更新时间
     */
    @TableField(value = "UPDATE_DATE")
    @ApiModelProperty(value="更新时间")
    private Date updateDate;

    /**
     *  1:普通商品,2:预售商品 3:组合商品
     */
    @TableField(value = "PRODUCT_TYPE")
    @ApiModelProperty(value=" 1:普通商品,2:预售商品 3:组合商品")
    private String productType;

    /**
     * 消费积分数量
     */
    @TableField(value = "CONSUMPOINTS")
    @ApiModelProperty(value="消费积分数量")
    private String consumpoints;

    /**
     * 商品促销活动折扣金额
     */
    @TableField(value = "DISCOUNT")
    @ApiModelProperty(value="商品促销活动折扣金额")
    private String discount;

    /**
     * 商品使用优惠券，优惠分摊金额
     */
    @TableField(value = "DISCOUPON")
    @ApiModelProperty(value="商品使用优惠券，优惠分摊金额")
    private String discoupon;

    /**
     * 积分抵现金额，单位分
     */
    @TableField(value = "POINTSCASH")
    @ApiModelProperty(value="积分抵现金额，单位分")
    private String pointscash;

    /**
     * 申请售后的数量
     */
    @TableField(value = "APPLY_NUMBER")
    @ApiModelProperty(value="申请售后的数量")
    private String applyNumber;

    private static final long serialVersionUID = 1L;

    public static final String COL_AFTER_SALE_ITEM_ID = "AFTER_SALE_ITEM_ID";

    public static final String COL_CREATE_DATE = "CREATE_DATE";

    public static final String COL_AFTER_SALE_ORDER_ID = "AFTER_SALE_ORDER_ID";

    public static final String COL_ORDER_ITEM_ID = "ORDER_ITEM_ID";

    public static final String COL_ORDER_ID = "ORDER_ID";

    public static final String COL_SKU_ID = "SKU_ID";

    public static final String COL_SKU_CODE = "SKU_CODE";

    public static final String COL_SKU_NAME = "SKU_NAME";

    public static final String COL_SPU_ID = "SPU_ID";

    public static final String COL_SPU_NAME = "SPU_NAME";

    public static final String COL_SPU_IMG_URL = "SPU_IMG_URL";

    public static final String COL_SKU_PRICE = "SKU_PRICE";

    public static final String COL_UNIT = "UNIT";

    public static final String COL_APPLY_AMT = "APPLY_AMT";

    public static final String COL_REAL_REFUND_AMT = "REAL_REFUND_AMT";

    public static final String COL_LUNCH_BOX_FEE = "LUNCH_BOX_FEE";

    public static final String COL_UPDATE_DATE = "UPDATE_DATE";

    public static final String COL_PRODUCT_TYPE = "PRODUCT_TYPE";

    public static final String COL_CONSUMPOINTS = "CONSUMPOINTS";

    public static final String COL_DISCOUNT = "DISCOUNT";

    public static final String COL_DISCOUPON = "DISCOUPON";

    public static final String COL_POINTSCASH = "POINTSCASH";

    public static final String COL_APPLY_NUMBER = "APPLY_NUMBER";
}