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

import lombok.*;

/**
    * 记录创建时间时间
    */
@ApiModel(value="记录创建时间时间")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "ORDER_INVOICE")
@EqualsAndHashCode
public class OrderInvoice implements Serializable {
    @TableField(value = "ID")
    @ApiModelProperty(value="")
    private BigDecimal id;

    /**
     * 订单编号或售后单码
     */
    @TableField(value = "ORDER_ID")
    @ApiModelProperty(value="订单编号或售后单码")
    private String orderId;

    /**
     * 发票类型  0 电子发票, 1 增值税发票（专票）
     */
    @TableField(value = "INVOICE_TYPE")
    @ApiModelProperty(value="发票类型  0 电子发票, 1 增值税发票（专票）")
    private String invoiceType;

    /**
     * 发票抬头名称
     */
    @TableField(value = "INVOICE_TITLE")
    @ApiModelProperty(value="发票抬头名称")
    private String invoiceTitle;

    /**
     * 发票抬头内容
     */
    @TableField(value = "INVOICE_CONTENT")
    @ApiModelProperty(value="发票抬头内容")
    private String invoiceContent;

    /**
     * 发票金额
     */
    @TableField(value = "INVOICE_AMOUNT")
    @ApiModelProperty(value="发票金额")
    private String invoiceAmount;

    /**
     * 开票税金
     */
    @TableField(value = "INVOICE_TAX")
    @ApiModelProperty(value="开票税金")
    private String invoiceTax;

    /**
     * 发票税号
     */
    @TableField(value = "INVOICE_TAX_NO")
    @ApiModelProperty(value="发票税号")
    private String invoiceTaxNo;

    /**
     * 公司名称[增值税]
     */
    @TableField(value = "VAT_COMPANY_NAME")
    @ApiModelProperty(value="公司名称[增值税]")
    private String vatCompanyName;

    /**
     * 联系电话[增值税]
     */
    @TableField(value = "VAT_TELPHONE")
    @ApiModelProperty(value="联系电话[增值税]")
    private String vatTelphone;

    /**
     * 开户银行[增值税]
     */
    @TableField(value = "VAT_BANK_NAME")
    @ApiModelProperty(value="开户银行[增值税]")
    private String vatBankName;

    /**
     * 发票提取码
     */
    @TableField(value = "INVOICE_EXTRACTION_CODE")
    @ApiModelProperty(value="发票提取码")
    private String invoiceExtractionCode;

    /**
     * 银行帐号[增值税]
     */
    @TableField(value = "VAT_BANK_ACCOUNT")
    @ApiModelProperty(value="银行帐号[增值税]")
    private String vatBankAccount;

    /**
     * 款机号
     */
    @TableField(value = "PAY_MACHINE_NO")
    @ApiModelProperty(value="款机号")
    private String payMachineNo;

    /**
     * 发票状态  0开票状态：0未开票，1已开票，3开票失败，2开票中
     */
    @TableField(value = "INVOICE_STATUS")
    @ApiModelProperty(value="发票状态  0开票状态：0未开票，1已开票，3开票失败，2开票中")
    private String invoiceStatus;

    /**
     * 订单对应的红冲掉发票的售后单编码
     */
    @TableField(value = "FLUSH_AFTER_SALE_ID")
    @ApiModelProperty(value="订单对应的红冲掉发票的售后单编码")
    private String flushAfterSaleId;

    /**
     * 红冲状态  红冲发票状态 0开票了，但是没有发起红冲;1红冲成功;2红冲失败;3蓝票不存在（也就是没开票）
     */
    @TableField(value = "RED_FLUSH_STATUS")
    @ApiModelProperty(value="红冲状态  红冲发票状态 0开票了，但是没有发起红冲;1红冲成功;2红冲失败;3蓝票不存在（也就是没开票）")
    private String redFlushStatus;

    /**
     * 红冲时间
     */
    @TableField(value = "RED_FLUSH_TIME")
    @ApiModelProperty(value="红冲时间")
    private Date redFlushTime;

    @TableField(value = "CREATED_TIME")
    @ApiModelProperty(value="")
    private Date createdTime;

    /**
     * 小票流水号，正向与逆向单的号是不一样的
     */
    @TableField(value = "INVOICE_SERIAL_NO")
    @ApiModelProperty(value="小票流水号，正向与逆向单的号是不一样的")
    private String invoiceSerialNo;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "ID";

    public static final String COL_ORDER_ID = "ORDER_ID";

    public static final String COL_INVOICE_TYPE = "INVOICE_TYPE";

    public static final String COL_INVOICE_TITLE = "INVOICE_TITLE";

    public static final String COL_INVOICE_CONTENT = "INVOICE_CONTENT";

    public static final String COL_INVOICE_AMOUNT = "INVOICE_AMOUNT";

    public static final String COL_INVOICE_TAX = "INVOICE_TAX";

    public static final String COL_INVOICE_TAX_NO = "INVOICE_TAX_NO";

    public static final String COL_VAT_COMPANY_NAME = "VAT_COMPANY_NAME";

    public static final String COL_VAT_TELPHONE = "VAT_TELPHONE";

    public static final String COL_VAT_BANK_NAME = "VAT_BANK_NAME";

    public static final String COL_INVOICE_EXTRACTION_CODE = "INVOICE_EXTRACTION_CODE";

    public static final String COL_VAT_BANK_ACCOUNT = "VAT_BANK_ACCOUNT";

    public static final String COL_PAY_MACHINE_NO = "PAY_MACHINE_NO";

    public static final String COL_INVOICE_STATUS = "INVOICE_STATUS";

    public static final String COL_FLUSH_AFTER_SALE_ID = "FLUSH_AFTER_SALE_ID";

    public static final String COL_RED_FLUSH_STATUS = "RED_FLUSH_STATUS";

    public static final String COL_RED_FLUSH_TIME = "RED_FLUSH_TIME";

    public static final String COL_CREATED_TIME = "CREATED_TIME";

    public static final String COL_INVOICE_SERIAL_NO = "INVOICE_SERIAL_NO";
}