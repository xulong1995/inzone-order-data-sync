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
    * 订单条目表
    */
@ApiModel(value="订单条目表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "order_item")
public class CenterOrderItem implements Serializable {
    /**
     * 订单明细编号
     */
    @TableId(value = "order_item_id", type = IdType.INPUT)
    @ApiModelProperty(value="订单明细编号")
    private String orderItemId;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    @ApiModelProperty(value="创建时间")
    private Date gmtCreate;

    /**
     * 订单编号
     */
    @TableField(value = "order_id")
    @ApiModelProperty(value="订单编号")
    private String orderId;

    /**
     * 商品类型 1:普通商品,2:预售商品 3:组合商品
     */
    @TableField(value = "product_type")
    @ApiModelProperty(value="商品类型 1:普通商品,2:预售商品 3:组合商品")
    private String productType;

    /**
     * 订单来源途径: 01自发;02分销;03直播;04导购订单来源
     */
    @TableField(value = "product_source")
    @ApiModelProperty(value="订单来源途径: 01自发;02分销;03直播;04导购订单来源")
    private String productSource;

    /**
     * 商品id
     */
    @TableField(value = "spu_id")
    @ApiModelProperty(value="商品id")
    private String spuId;

    /**
     * 商品名称
     */
    @TableField(value = "sku_name")
    @ApiModelProperty(value="商品名称")
    private String skuName;

    /**
     * 分销门店（销售门店）
     */
    @TableField(value = "fx_store_id")
    @ApiModelProperty(value="分销门店（销售门店）")
    private String fxStoreId;

    /**
     * 商品编号
     */
    @TableField(value = "sku_id")
    @ApiModelProperty(value="商品编号")
    private String skuId;

    /**
     * 全渠道商品编码
     */
    @TableField(value = "sku_num")
    @ApiModelProperty(value="全渠道商品编码")
    private String skuNum;

    /**
     * 销售数量
     */
    @TableField(value = "sale_quantity")
    @ApiModelProperty(value="销售数量")
    private String saleQuantity;

    /**
     * 销售单价
     */
    @TableField(value = "sale_price")
    @ApiModelProperty(value="销售单价")
    private String salePrice;

    /**
     * 商品单位
     */
    @TableField(value = "product_unit")
    @ApiModelProperty(value="商品单位")
    private String productUnit;

    /**
     * 当前商品支付原总价
     */
    @TableField(value = "origin_amount")
    @ApiModelProperty(value="当前商品支付原总价")
    private String originAmount;

    /**
     * 实际交易支付金额
     */
    @TableField(value = "pay_amount")
    @ApiModelProperty(value="实际交易支付金额")
    private String payAmount;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    @ApiModelProperty(value="更新时间")
    private Date gmtModified;

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

    /**
     * 返利金额
     */
    @TableField(value = "giftamount")
    @ApiModelProperty(value="返利金额")
    private String giftamount;

    /**
     * 商品行号
     */
    @TableField(value = "row_no")
    @ApiModelProperty(value="商品行号")
    private String rowNo;

    /**
     * Erp库位id
     */
    @TableField(value = "location_id")
    @ApiModelProperty(value="Erp库位id")
    private String locationId;

    /**
     * 优惠券id
     */
    @TableField(value = "coupon_id")
    @ApiModelProperty(value="优惠券id")
    private String couponId;

    /**
     * 直播间id
     */
    @TableField(value = "live_room_id")
    @ApiModelProperty(value="直播间id")
    private String liveRoomId;

    /**
     * 牵牛花用
     */
    @TableField(value = "dwzhxs")
    @ApiModelProperty(value="牵牛花用")
    private String dwzhxs;

    /**
     * 包装数
     */
    @TableField(value = "pk_number")
    @ApiModelProperty(value="包装数")
    private String pkNumber;

    /**
     * 扩展信息
     */
    @TableField(value = "ext_json")
    @ApiModelProperty(value="扩展信息")
    private String extJson;

    /**
     * 餐盒费
     */
    @TableField(value = "lunchboxfee")
    @ApiModelProperty(value="餐盒费")
    private String lunchboxfee;

    /**
     * spu名称
     */
    @TableField(value = "spu_name")
    @ApiModelProperty(value="spu名称")
    private String spuName;

    /**
     * 供应商
     */
    @TableField(value = "supplier")
    @ApiModelProperty(value="供应商")
    private String supplier;

    /**
     * 柜组
     */
    @TableField(value = "gz")
    @ApiModelProperty(value="柜组")
    private String gz;

    /**
     * 品牌
     */
    @TableField(value = "brand")
    @ApiModelProperty(value="品牌")
    private String brand;

    /**
     * 品类
     */
    @TableField(value = "category")
    @ApiModelProperty(value="品类")
    private String category;

    /**
     * 商品图片
     */
    @TableField(value = "product_img")
    @ApiModelProperty(value="商品图片")
    private String productImg;

    /**
     * 0退款中1部分退款2已退款
     */
    @TableField(value = "order_item_status")
    @ApiModelProperty(value="0退款中1部分退款2已退款")
    private Integer orderItemStatus;

    /**
     * 商品条码
     */
    @TableField(value = "barcode")
    @ApiModelProperty(value="商品条码")
    private String barcode;

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
     * 分销人手机号
     */
    @TableField(value = "fx_per_phone")
    @ApiModelProperty(value="分销人手机号")
    private String fxPerPhone;

    /**
     * 个人提取方式
     */
    @TableField(value = "per_extract_method")
    @ApiModelProperty(value="个人提取方式")
    private String perExtractMethod;

    /**
     * 个人提取比例
     */
    @TableField(value = "per_extract_ratio")
    @ApiModelProperty(value="个人提取比例")
    private String perExtractRatio;

    /**
     * 门店提取方式
     */
    @TableField(value = "store_extract_method")
    @ApiModelProperty(value="门店提取方式")
    private String storeExtractMethod;

    /**
     * 门店提取比例
     */
    @TableField(value = "store_extract_ratio")
    @ApiModelProperty(value="门店提取比例")
    private String storeExtractRatio;

    /**
     * 货号
     */
    @TableField(value = "sku_no")
    @ApiModelProperty(value="货号")
    private String skuNo;

    private static final long serialVersionUID = 1L;

    public static final String COL_ORDER_ITEM_ID = "order_item_id";

    public static final String COL_GMT_CREATE = "gmt_create";

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_PRODUCT_TYPE = "product_type";

    public static final String COL_PRODUCT_SOURCE = "product_source";

    public static final String COL_SPU_ID = "spu_id";

    public static final String COL_SKU_NAME = "sku_name";

    public static final String COL_FX_STORE_ID = "fx_store_id";

    public static final String COL_SKU_ID = "sku_id";

    public static final String COL_SKU_NUM = "sku_num";

    public static final String COL_SALE_QUANTITY = "sale_quantity";

    public static final String COL_SALE_PRICE = "sale_price";

    public static final String COL_PRODUCT_UNIT = "product_unit";

    public static final String COL_ORIGIN_AMOUNT = "origin_amount";

    public static final String COL_PAY_AMOUNT = "pay_amount";

    public static final String COL_GMT_MODIFIED = "gmt_modified";

    public static final String COL_CONSUMPOINTS = "consumpoints";

    public static final String COL_DISCOUNT = "discount";

    public static final String COL_DISCOUPON = "discoupon";

    public static final String COL_POINTSCASH = "pointscash";

    public static final String COL_GIFTAMOUNT = "giftamount";

    public static final String COL_ROW_NO = "row_no";

    public static final String COL_LOCATION_ID = "location_id";

    public static final String COL_COUPON_ID = "coupon_id";

    public static final String COL_LIVE_ROOM_ID = "live_room_id";

    public static final String COL_DWZHXS = "dwzhxs";

    public static final String COL_PK_NUMBER = "pk_number";

    public static final String COL_EXT_JSON = "ext_json";

    public static final String COL_LUNCHBOXFEE = "lunchboxfee";

    public static final String COL_SPU_NAME = "spu_name";

    public static final String COL_SUPPLIER = "supplier";

    public static final String COL_GZ = "gz";

    public static final String COL_BRAND = "brand";

    public static final String COL_CATEGORY = "category";

    public static final String COL_PRODUCT_IMG = "product_img";

    public static final String COL_ORDER_ITEM_STATUS = "order_item_status";

    public static final String COL_BARCODE = "barcode";

    public static final String COL_DIRECT_DESCENT = "direct_descent";

    public static final String COL_FULL_MINUS = "full_minus";

    public static final String COL_FULL_ARRIVAL = "full_arrival";

    public static final String COL_FULL_DISCOUNT = "full_discount";

    public static final String COL_COUPON_AMOUNT = "coupon_amount";

    public static final String COL_FX_PER_PHONE = "fx_per_phone";

    public static final String COL_PER_EXTRACT_METHOD = "per_extract_method";

    public static final String COL_PER_EXTRACT_RATIO = "per_extract_ratio";

    public static final String COL_STORE_EXTRACT_METHOD = "store_extract_method";

    public static final String COL_STORE_EXTRACT_RATIO = "store_extract_ratio";

    public static final String COL_SKU_NO = "sku_no";
}