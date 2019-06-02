package com.griftt.eurekaclient.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name = "sa_order")
@Data
public class Order {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 购买人ID
     */
    private Integer playerId;

    /**
     * 拼单id
     */
    private Integer mergeId;

    /**
     * 订单总金额
     */
    private BigDecimal totalPrice;

    /**
     * 订单商品总金额
     */
    private BigDecimal totalGoodsPrice;


    /**
     * 原始订单商品总金额  original_total_goods_price
     */
    private BigDecimal originalTotalGoodsPrice;

    /**
     * 支付现金
     */
    private BigDecimal payPrice;

    /**
     * 支付积分
     */
    private Integer payScore;

    /**
     * 积分抵扣金额
     */
    private BigDecimal payScorePrice;

    /**
     * 优惠券抵扣金额
     */
    private BigDecimal deductionPrice;
    /**
     * 运费
     */
    private BigDecimal shipFee;

    /**
     * 收货人
     */
    private String receiverName;

    /**
     * 收货电话
     */
    private String receiverPhone;

    /**
     * 收货地址
     */
    private String receiverAddr;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品主图
     */
    private String headpic;

    /**
     * Sku组装信息
     */
    private String skus;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 此订单使用的优惠券id  use_discount_id
     */
    private Integer useDiscountId;

    /**
     * 支付状态
     */
    private Integer payStatus;

    /**
     * 支付方式
     */
    private String payType;

    /**
     * 物流公司
     */
    private String shipCompany;
    /**
     * 是否拼单订单
     */
    private Integer mergeOrder;

    /**
     * 物流单号
     */
    private String shipNo;

    /**
     * 物流新增信息
     */
    private String shipDeliveryStatus;
    private String shipMsg;
    private String shipInfo;
    private Date shipQueryTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 二维码
     */
    private String qrcode;

    /**
     * 代理商id
     */
    private Integer agentId;

    /**
     * 部门id
     */
    private Integer deptid;

    /**
     * 过期时间
     */
    private Date expireDate;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 发货时间
     */
    private Date shipTime;

    private String handlePerson;

    /**
     * 收货时间
     */
    private Date receiveTime;

    /**
     * 新增时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 记录状态 0- 删除 1- 正常 2- 前端不显示
     */
    private Integer recordStatus;
}
