package com.ht.screening.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


/**
 * 筛选大盘的表
 * @author chengsukai
 */
@Data
@TableName("SC_SX")
public class ScSx {

    /**
     * 筛选编号
     */
    @TableId(value = "XSBH", type = IdType.INPUT)
    private String sxbh;

    /**
     * 原始盘号, 大盘编号
     */
    @TableField(value = "YSPH")
    private String ysph;

    /**
     * 生产班组
     */
    @TableField(value = "SCBZ")
    private String scbz;

    /**
     * 生产日期
     */
    @TableField(value = "SCRQ")
    private Date scrq;

    /**
     * 设备编号
     */
    @TableField(value = "SBBH")
    private String sbbh;

    /**
     * 工号
     */
    @TableField(value = "GH")
    private String gh;

    /**
     * 放线张力
     */
    @TableField(value = "fxzl")
    private Object fxzl;

    /**
     * 设备状况
     */
    @TableField(value = "SBZK")
    private String sbzk;

    /**
     * 收线张力
     */
    @TableField(value = "SXZL")
    private Object sxzl;

    /**
     * 收线速度
     */
    @TableField(value = "SXSD")
    private Object sxsd;

    /**
     * 是否缺陷
     */
    @TableField(value = "SFQX")
    private String sfqx;

    /**
     * 暂不需要
     */
    @TableField(value = "SFDQ")
    private String sfdq;

    /**
     * 制单人
     */
    @TableField(value = "ZDR")
    private String zdr;

    /**
     * 制单日期
     */
    @TableField(value = "ZDRQ")
    private Date zdrq;

    /**
     * 审核人
     */
    @TableField(value = "SHR")
    private String checker;

    /**
     * 审核日期
     */
    @TableField(value = "SHRQ")
    private Date shrq;

    /**
     * 光纤长度
     */
    @TableField(value = "GQCD")
    private Double gqcd;

    /**
     * 应力
     */
    @TableField(value = "yl")
    private String yl;

    /**
     * 暂不需要
     */
    @TableField(value = "lsrate")
    private String lsrate;

    /**
     * 未知字段
     */
    @TableField(value = "MPSH")
    private String mpsh;

    /**
     * 暂不需要
     */
    @TableField(value = "ZLH")
    private String zlh;

    /**
     * 暂不需要
     */
    @TableField(value = "ISrise")
    private Integer isrise;

    /**
     *暂不需要
     */
    @TableField(value = "ischange")
    private Integer ischange;

    /**
     * 暂不需要
     */
    @TableField(value = "sxts")
    private Integer sxts;

    /**
     * 颜色
     */
    @TableField(value = "color")
    private String color;

    /**
     * 盘具
     */
    @TableField("PJ")
    private String pj;

    /**
     * 新旧盘
     */
    @TableField(value = "XJ")
    private String xj;

    /**
     * 暂不需要
     */
    @TableField(value = "SHRQH")
    private Date shrqh;

    /**
    * 最后更新时间
    */
    @TableField(value = "LastUpdateTime")
    private Date lastupdatetime;

    /**
     * 更改人
     */
    @TableField(value = "LastUpdateAccountId")
    private String lastupdateaccountid;

}