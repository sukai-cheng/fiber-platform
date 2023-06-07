package com.ht.screening.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@Data
@TableName("")
public class Procstock {
    /**
     * 产品编号
     */
    @TableId("productid")
    private String productid;

    /**
     * 工序编号
     */
    @TableField("procid")
    private String procid;

    /**
     * 产品类型
     */
    @TableField("producttype")
    private Integer producttype;

    /**
     * 备注
     */
    @TableField("note")
    private String note;

    /**
     * 数量
     */
    @TableField("gqcd")
    private Double gqcd;

    /**
     * 来源编号
     */
    @TableField("sourceid")
    private String sourceid;

    /**
     * 光棒编号
     */
    @TableField("gsid")
    private String gsid;

    /**
     * 状态
     */
    @TableField("state")
    private Integer state;

    /**
     * 创建时间
     */
    @TableField("crdate")
    private Date crdate;

    /**
     * 原因
     */
    @TableField("cause")
    private String cause;

    /**
     * 用户信息
     */
    @TableField("username")
    private String username;

    @TableField("OkSL")
    private Double oksl;

    @TableField("DisSL")
    private Double dissl;

    @TableField("zlh")
    private String zlh;
    @TableField("MPSH")
    private String mpsh;

    @TableField("ManufactureType")
    private String manufacturetype;

    /**
     * 父工序节点信息
     */
    @TableField("ParentProcid")
    private String parentprocid;

    @TableField("LastUpdateAccountID")
    private String lastupdateaccountid;

    @TableField("LastUpdateTime")
    private Date lastupdatetime;
}