package com.ht.screening.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 筛选 - 小盘的相关信息
 *
 * @author chengsukai
 */
@Data
@TableName(value = "SC_SX2")
public class ScSx2 {

    /**
     * 筛选编号
     */
    @TableId(value = "SXBH", type = IdType.INPUT)
    private String sxbh;

    /**
     * 序号
     */
    @TableField(value = "XH")
    private String xh;

    /**
     * 小盘编号
     */
    @TableField(value = "XPTM")
    private String xptm;

    /**
     * 开始位置
     */
    @TableField(value = "ewz")
    private BigDecimal ewz;

    /**
     * 盘长
     */
    @TableField(value = "CD")
    private BigDecimal cd;

    /**
     * 断纤损失
     */
    @TableField(value = "DQQK")
    private String dqqk;

    /**
     * 暂时用不到
     */
    @TableField(value = "GB")
    private String gb;

    /**
     * id
     */
    @TableField(value = "ID")
    private String id;

    /**
     * ispt
     */
    @TableField(value = "isPT")
    private Integer ispt;

    /**
     * 是否旧盘具
     */
    @TableField(value = "isoldtray")
    private Integer isoldtray;

    /**
     * isbigtray
     */
    @TableField(value = "isbigtray")
    private Integer isbigtray;

    /**
     * manufactureType
     */
    @TableField(value = "ManufactureType")
    private String manufacturetype;

    /**
     * 颜色
     */
    @TableField(value = "color")
    private String color;

    /**
     * 盘具
     */
    @TableField(value = "PTnum")
    private Integer ptnum;

    /**
     * 0 - 头
     * 1 - 尾
     */
    @TableField(value = "ISheadCauda")
    private Integer isheadcauda;

    /**
     * 断纤长度
     */
    @TableField(value = "dqcd")
    private BigDecimal dqcd;

    /**
     * 缺陷类型
     */
    @TableField(value = "qxlb")
    private String qxlb;

    /**
     * 切割长度
     */
    @TableField(value = "qgcd")
    private BigDecimal qgcd;

    /**
     * 审核
     */
    @TableField(value = "issh")
    private Integer issh;

    /**
     * 已打印次数
     */
    @TableField(value = "isdy")
    private Integer isdy;

    /**
     * 不合格原因
     */
    @TableField(value = "blyy")
    private String blyy;

    /**
     * 未知字段
     */
    @TableField(value = "labour")
    private String labour;

    /**
     * 审核人
     */
    @TableField(value = "sxr")
    private String sxr;

    /**
     * 筛选日期
     */
    @TableField(value = "crdate")
    private Date crdate;

    /**
     * 未知字段
     */
    @TableField(value = "sh_labour")
    private String shLabour;

    /**
     * 审核人
     */
    @TableField(value = "sxshr")
    private String sxshr;

    /**
     * 未知字段
     */
    @TableField(value = "xhgl")
    private Integer xhgl;

    /**
     * 未知字段
     */
    @TableField(value = "istestDC")
    private Integer istestdc;

    /**
     * 2200抽检
     */
    @TableField(value = "istest2200")
    private Integer istest2200;

    /**
     * 2400抽检
     */
    @TableField(value = "istest2400")
    private Integer istest2400;

    /**
     * 标盘长度
     */
    @TableField(value = "BPCD")
    private Double bpcd;

    /**
     * 未知字段
     */
    @TableField(value = "JDWZ")
    private Double jdwz;

    /**
     * 未知字段
     */
    @TableField(value = "lsbz")
    private String lsbz;

    /**
     * 未知字段
     */
    @TableField(value = "ss_totallen")
    private Double ssTotallen;

    /**
     * 未知字段
     */
    @TableField(value = "zzpcd")
    private Double zzpcd;

    /**
     * 未知字段
     */
    @TableField(value = "ischange")
    private Integer ischange;

    /**
     * 盘具类型
     */
    @TableField(value = "PJ")
    private String pj;

    /**
     * 新旧盘
     */
    @TableField(value = "XJ")
    private String xj;

    /**
     * 隔离描述
     */
    @TableField(value = "glqk")
    private String glqk;

    /**
     * 开始时间
     */
    @TableField(value = "stime")
    private Date stime;

    /**
     * 结束时间
     */
    @TableField(value = "etime")
    private Date etime;

    /**
     * 应力
     */
    @TableField(value = "syl")
    private String syl;

    /**
     * 筛选模式
     */
    @TableField(value = "sxms")
    private Integer sxms;

    /**
     * 全检描述
     */
    @TableField(value = "qjms")
    private String qjms;

    /**
     * 未知字段
     */
    @TableField(value = "dqjd")
    private Integer dqjd;

    /**
     * 断纤描述长度
     */
    @TableField(value = "dqmscd")
    private BigDecimal dqmscd;

    /**
     * 是否打印
     */
    @TableField(value = "isfg")
    private Integer isfg;

    /**
     * 设备编号
     */
    @TableField(value = "SBBHD")
    private String sbbhd;

    /**
     * 未知字段
     */
    @TableField(value = "dqcs")
    private Integer dqcs;

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

    /**
     * pmd抽检
     */
    @TableField(value = "istestPMD")
    private Integer istestpmd;

}