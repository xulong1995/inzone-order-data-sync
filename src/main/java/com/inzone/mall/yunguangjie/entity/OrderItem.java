package com.inzone.mall.yunguangjie.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

import lombok.*;

/**
    * 订单条目表
    */
@ApiModel(value="订单条目表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "ORDER_ITEM")
@EqualsAndHashCode
public class OrderItem implements Serializable {
    /**
     * 订单明细编号
     */
    @TableId(value = "ORDER_ITEM_ID", type = IdType.INPUT)
    @ApiModelProperty(value="订单明细编号")
    private String orderItemId;

    /**
     * 创建时间
     */
    @TableField(value = "GMT_CREATE")
    @ApiModelProperty(value="创建时间")
    private Date gmtCreate;

    /**
     * 订单编号
     */
    @TableField(value = "ORDER_ID")
    @ApiModelProperty(value="订单编号")
    private String orderId;

    /**
     * 商品类型 1:普通商品,2:预售商品 3:组合商品
     */
    @TableField(value = "PRODUCT_TYPE")
    @ApiModelProperty(value="商品类型 1:普通商品,2:预售商品 3:组合商品")
    private Short productType;

    /**
     * 订单来源途径: 01自发;02分销;03直播;04导购订单来源
     */
    @TableField(value = "PRODUCT_SOURCE")
    @ApiModelProperty(value="订单来源途径: 01自发;02分销;03直播;04导购订单来源")
    private String productSource;

    /**
     * 商品id
     */
    @TableField(value = "SPU_ID")
    @ApiModelProperty(value="商品id")
    private String spuId;

    /**
     * 商品名称
     */
    @TableField(value = "SKU_NAME")
    @ApiModelProperty(value="商品名称")
    private String skuName;

    /**
     * 分销门店（销售门店）
     */
    @TableField(value = "FX_STORE_ID")
    @ApiModelProperty(value="分销门店（销售门店）")
    private String fxStoreId;

    /**
     * 商品编号
     */
    @TableField(value = "SKU_ID")
    @ApiModelProperty(value="商品编号")
    private String skuId;

    /**
     * 全渠道商品编码
     */
    @TableField(value = "SKU_NUM")
    @ApiModelProperty(value="全渠道商品编码")
    private String skuNum;

    /**
     * 销售数量
     */
    @TableField(value = "SALE_QUANTITY")
    @ApiModelProperty(value="销售数量")
    private String saleQuantity;

    /**
     * 销售单价
     */
    @TableField(value = "SALE_PRICE")
    @ApiModelProperty(value="销售单价")
    private String salePrice;

    /**
     * 商品单位
     */
    @TableField(value = "PRODUCT_UNIT")
    @ApiModelProperty(value="商品单位")
    private String productUnit;

    /**
     * 当前商品支付原总价
     */
    @TableField(value = "ORIGIN_AMOUNT")
    @ApiModelProperty(value="当前商品支付原总价")
    private String originAmount;

    /**
     * 实际交易支付金额
     */
    @TableField(value = "PAY_AMOUNT")
    @ApiModelProperty(value="实际交易支付金额")
    private String payAmount;

    /**
     * 更新时间
     */
    @TableField(value = "GMT_MODIFIED")
    @ApiModelProperty(value="更新时间")
    private Date gmtModified;

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
     * 返利金额
     */
    @TableField(value = "GIFTAMOUNT")
    @ApiModelProperty(value="返利金额")
    private String giftamount;

    /**
     * 商品行号
     */
    @TableField(value = "ROW_NO")
    @ApiModelProperty(value="商品行号")
    private String rowNo;

    /**
     * Erp库位id
     */
    @TableField(value = "LOCATION_ID")
    @ApiModelProperty(value="Erp库位id")
    private String locationId;

    /**
     * 优惠券id
     */
    @TableField(value = "COUPON_ID")
    @ApiModelProperty(value="优惠券id")
    private String couponId;

    /**
     * 直播间id
     */
    @TableField(value = "LIVE_ROOM_ID")
    @ApiModelProperty(value="直播间id")
    private String liveRoomId;

    /**
     * 牵牛花用
     */
    @TableField(value = "DWZHXS")
    @ApiModelProperty(value="牵牛花用")
    private String dwzhxs;

    /**
     * 包装数
     */
    @TableField(value = "PK_NUMBER")
    @ApiModelProperty(value="包装数")
    private String pkNumber;

    /**
     * 扩展信息
     */
    @TableField(value = "EXT_JSON")
    @ApiModelProperty(value="扩展信息")
    private String extJson;

    /**
     * 餐盒费
     */
    @TableField(value = "LUNCHBOXFEE")
    @ApiModelProperty(value="餐盒费")
    private String lunchboxfee;

    /**
     * spu名称
     */
    @TableField(value = "SPU_NAME")
    @ApiModelProperty(value="spu名称")
    private String spuName;

    /**
     * 供应商
     */
    @TableField(value = "SUPPLIER")
    @ApiModelProperty(value="供应商")
    private String supplier;

    /**
     * 柜组
     */
    @TableField(value = "GZ")
    @ApiModelProperty(value="柜组")
    private String gz;

    /**
     * 品牌
     */
    @TableField(value = "BRAND")
    @ApiModelProperty(value="品牌")
    private String brand;

    /**
     * 品类
     */
    @TableField(value = "CATEGORY")
    @ApiModelProperty(value="品类")
    private String category;

    /**
     * 商品图片
     */
    @TableField(value = "PRODUCT_IMG")
    @ApiModelProperty(value="商品图片")
    private String productImg;

    /**
     * 0退款中1部分退款2已退款
     */
    @TableField(value = "ORDER_ITEM_STATUS")
    @ApiModelProperty(value="0退款中1部分退款2已退款")
    private Long orderItemStatus;

    /**
     * 商品条码
     */
    @TableField(value = "BARCODE")
    @ApiModelProperty(value="商品条码")
    private String barcode;

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
     * 分销人手机号
     */
    @TableField(value = "FX_PER_PHONE")
    @ApiModelProperty(value="分销人手机号")
    private String fxPerPhone;

    /**
     * 个人提取方式
     */
    @TableField(value = "PER_EXTRACT_METHOD")
    @ApiModelProperty(value="个人提取方式")
    private String perExtractMethod;

    /**
     * 个人提取比例
     */
    @TableField(value = "PER_EXTRACT_RATIO")
    @ApiModelProperty(value="个人提取比例")
    private String perExtractRatio;

    /**
     * 门店提取方式
     */
    @TableField(value = "STORE_EXTRACT_METHOD")
    @ApiModelProperty(value="门店提取方式")
    private String storeExtractMethod;

    /**
     * 门店提取比例
     */
    @TableField(value = "STORE_EXTRACT_RATIO")
    @ApiModelProperty(value="门店提取比例")
    private String storeExtractRatio;

    /**
     * 货号
     */
    @TableField(value = "SKU_NO")
    @ApiModelProperty(value="货号")
    private String skuNo;

    private static final long serialVersionUID = 1L;

    public static final String COL_ORDER_ITEM_ID = "ORDER_ITEM_ID";

    public static final String COL_GMT_CREATE = "GMT_CREATE";

    public static final String COL_ORDER_ID = "ORDER_ID";

    public static final String COL_PRODUCT_TYPE = "PRODUCT_TYPE";

    public static final String COL_PRODUCT_SOURCE = "PRODUCT_SOURCE";

    public static final String COL_SPU_ID = "SPU_ID";

    public static final String COL_SKU_NAME = "SKU_NAME";

    public static final String COL_FX_STORE_ID = "FX_STORE_ID";

    public static final String COL_SKU_ID = "SKU_ID";

    public static final String COL_SKU_NUM = "SKU_NUM";

    public static final String COL_SALE_QUANTITY = "SALE_QUANTITY";

    public static final String COL_SALE_PRICE = "SALE_PRICE";

    public static final String COL_PRODUCT_UNIT = "PRODUCT_UNIT";

    public static final String COL_ORIGIN_AMOUNT = "ORIGIN_AMOUNT";

    public static final String COL_PAY_AMOUNT = "PAY_AMOUNT";

    public static final String COL_GMT_MODIFIED = "GMT_MODIFIED";

    public static final String COL_CONSUMPOINTS = "CONSUMPOINTS";

    public static final String COL_DISCOUNT = "DISCOUNT";

    public static final String COL_DISCOUPON = "DISCOUPON";

    public static final String COL_POINTSCASH = "POINTSCASH";

    public static final String COL_GIFTAMOUNT = "GIFTAMOUNT";

    public static final String COL_ROW_NO = "ROW_NO";

    public static final String COL_LOCATION_ID = "LOCATION_ID";

    public static final String COL_COUPON_ID = "COUPON_ID";

    public static final String COL_LIVE_ROOM_ID = "LIVE_ROOM_ID";

    public static final String COL_DWZHXS = "DWZHXS";

    public static final String COL_PK_NUMBER = "PK_NUMBER";

    public static final String COL_EXT_JSON = "EXT_JSON";

    public static final String COL_LUNCHBOXFEE = "LUNCHBOXFEE";

    public static final String COL_SPU_NAME = "SPU_NAME";

    public static final String COL_SUPPLIER = "SUPPLIER";

    public static final String COL_GZ = "GZ";

    public static final String COL_BRAND = "BRAND";

    public static final String COL_CATEGORY = "CATEGORY";

    public static final String COL_PRODUCT_IMG = "PRODUCT_IMG";

    public static final String COL_ORDER_ITEM_STATUS = "ORDER_ITEM_STATUS";

    public static final String COL_BARCODE = "BARCODE";

    public static final String COL_DIRECT_DESCENT = "DIRECT_DESCENT";

    public static final String COL_FULL_MINUS = "FULL_MINUS";

    public static final String COL_FULL_ARRIVAL = "FULL_ARRIVAL";

    public static final String COL_FULL_DISCOUNT = "FULL_DISCOUNT";

    public static final String COL_COUPON_AMOUNT = "COUPON_AMOUNT";

    public static final String COL_FX_PER_PHONE = "FX_PER_PHONE";

    public static final String COL_PER_EXTRACT_METHOD = "PER_EXTRACT_METHOD";

    public static final String COL_PER_EXTRACT_RATIO = "PER_EXTRACT_RATIO";

    public static final String COL_STORE_EXTRACT_METHOD = "STORE_EXTRACT_METHOD";

    public static final String COL_STORE_EXTRACT_RATIO = "STORE_EXTRACT_RATIO";

    public static final String COL_SKU_NO = "SKU_NO";
}