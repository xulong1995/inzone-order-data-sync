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

@ApiModel(value="order_invoice")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "order_invoice")
public class CenterOrderInvoice implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 订单编号或售后单码
     */
    @TableField(value = "order_id")
    @ApiModelProperty(value="订单编号或售后单码")
    private String orderId;

    /**
     * 发票类型  0 电子发票, 1 增值税发票（专票）
     */
    @TableField(value = "invoice_type")
    @ApiModelProperty(value="发票类型  0 电子发票, 1 增值税发票（专票）")
    private String invoiceType;

    /**
     * 发票抬头名称
     */
    @TableField(value = "invoice_title")
    @ApiModelProperty(value="发票抬头名称")
    private String invoiceTitle;

    /**
     * 发票抬头内容
     */
    @TableField(value = "invoice_content")
    @ApiModelProperty(value="发票抬头内容")
    private String invoiceContent;

    /**
     * 发票金额
     */
    @TableField(value = "invoice_amount")
    @ApiModelProperty(value="发票金额")
    private String invoiceAmount;

    /**
     * 开票税金
     */
    @TableField(value = "invoice_tax")
    @ApiModelProperty(value="开票税金")
    private String invoiceTax;

    /**
     * 发票税号
     */
    @TableField(value = "invoice_tax_no")
    @ApiModelProperty(value="发票税号")
    private String invoiceTaxNo;

    /**
     * 公司名称[增值税]
     */
    @TableField(value = "vat_company_name")
    @ApiModelProperty(value="公司名称[增值税]")
    private String vatCompanyName;

    /**
     * 联系电话[增值税]
     */
    @TableField(value = "vat_telphone")
    @ApiModelProperty(value="联系电话[增值税]")
    private String vatTelphone;

    /**
     * 开户银行[增值税]
     */
    @TableField(value = "vat_bank_name")
    @ApiModelProperty(value="开户银行[增值税]")
    private String vatBankName;

    /**
     * 发票提取码
     */
    @TableField(value = "invoice_extraction_code")
    @ApiModelProperty(value="发票提取码")
    private String invoiceExtractionCode;

    /**
     * 银行帐号[增值税]
     */
    @TableField(value = "vat_bank_account")
    @ApiModelProperty(value="银行帐号[增值税]")
    private String vatBankAccount;

    /**
     * 款机号
     */
    @TableField(value = "pay_machine_no")
    @ApiModelProperty(value="款机号")
    private String payMachineNo;

    /**
     * 发票状态  0开票状态：0未开票，1已开票，3开票失败，2开票中
     */
    @TableField(value = "invoice_status")
    @ApiModelProperty(value="发票状态  0开票状态：0未开票，1已开票，3开票失败，2开票中")
    private String invoiceStatus;

    /**
     * 订单对应的红冲掉发票的售后单编码
     */
    @TableField(value = "flush_after_sale_id")
    @ApiModelProperty(value="订单对应的红冲掉发票的售后单编码")
    private String flushAfterSaleId;

    /**
     * 红冲状态  红冲发票状态 0开票了，但是没有发起红冲;1红冲成功;2红冲失败;3蓝票不存在（也就是没开票）
     */
    @TableField(value = "red_flush_status")
    @ApiModelProperty(value="红冲状态  红冲发票状态 0开票了，但是没有发起红冲;1红冲成功;2红冲失败;3蓝票不存在（也就是没开票）")
    private String redFlushStatus;

    /**
     * 红冲时间
     */
    @TableField(value = "red_flush_time")
    @ApiModelProperty(value="红冲时间")
    private Date redFlushTime;

    /**
     * 记录创建时间时间
     */
    @TableField(value = "created_time")
    @ApiModelProperty(value="记录创建时间时间")
    private Date createdTime;

    /**
     * 小票流水号，正向与逆向单的号是不一样的
     */
    @TableField(value = "invoice_serial_no")
    @ApiModelProperty(value="小票流水号，正向与逆向单的号是不一样的")
    private String invoiceSerialNo;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_INVOICE_TYPE = "invoice_type";

    public static final String COL_INVOICE_TITLE = "invoice_title";

    public static final String COL_INVOICE_CONTENT = "invoice_content";

    public static final String COL_INVOICE_AMOUNT = "invoice_amount";

    public static final String COL_INVOICE_TAX = "invoice_tax";

    public static final String COL_INVOICE_TAX_NO = "invoice_tax_no";

    public static final String COL_VAT_COMPANY_NAME = "vat_company_name";

    public static final String COL_VAT_TELPHONE = "vat_telphone";

    public static final String COL_VAT_BANK_NAME = "vat_bank_name";

    public static final String COL_INVOICE_EXTRACTION_CODE = "invoice_extraction_code";

    public static final String COL_VAT_BANK_ACCOUNT = "vat_bank_account";

    public static final String COL_PAY_MACHINE_NO = "pay_machine_no";

    public static final String COL_INVOICE_STATUS = "invoice_status";

    public static final String COL_FLUSH_AFTER_SALE_ID = "flush_after_sale_id";

    public static final String COL_RED_FLUSH_STATUS = "red_flush_status";

    public static final String COL_RED_FLUSH_TIME = "red_flush_time";

    public static final String COL_CREATED_TIME = "created_time";

    public static final String COL_INVOICE_SERIAL_NO = "invoice_serial_no";
}