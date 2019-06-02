package com.griftt.eurekaclient.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data


public class Goods {


    private Integer id;

    /**
     * 商品编号
     */
    private String goodsNo;

    /**
     * 商品中文名
     */
    private String name;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品主图
     */
    private String headpic;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 图文详情
     */
    private String description;

    /**
     * 排序权重
     */
    private Integer weigh;

    /**
     * 使用说明内容id
     */
    private Integer instructionsId;

    /**
     * 溯源内容id
     */
    private Integer traceabilityId;

    /**
     * 微信公众号内容id
     */
    private Integer weixinId;

    /**
     * 是否拼单商品
     */
    private Integer productMerge;

    /**
     * 运费
     */
    private BigDecimal shipFee;
    /**
     * 价格范围
     */
    private String priceRange;

    /**
     * 拼单价格范围
     */
    private  String mergePriceRange;

    /**
     * 部门id
     */
    private Integer deptid;

    /**
     * 1 - 上架；0 - 下架；
     */
    private Integer status;

    /**
     * 热销商品
     */
    private Integer productHot;

    /**
     * 新品
     */
    private Integer productNew;

    /**
     * 新增时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 记录状态
     */
    private Integer recordStatus;
}
