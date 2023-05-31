package com.ht.screening.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chengsukai
 */
@Data
@TableName("SC_LS_QXQC")
public class ScLsQxqc {
    /**
     * 拉丝编号
     */
    @TableId(value = "LSBH", type = IdType.INPUT)
    private String lsbh;

    /**
     * 型号
     */
    @TableField(value = "xh")
    private Integer xh;

    /**
     * 周转盘编号
     */
    @TableField(value = "zzpbh")
    private String zzpbh;

    /**
     * 缺陷类型
     */
    @TableField(value = "qxdlx")
    private String qxdlx;

    /**
     * 起始位置
     */
    @TableField(value = "qswz")
    private BigDecimal qswz;

    /**
     * 终止位置
     */
    @TableField(value = "zzwz")
    private BigDecimal zzwz;

    /**
     * 是否切除
     */
    @TableField(value = "sfqc")
    private String sfqc;

    /**
     * 是否隔离
     */
    @TableField(value = "sfql")
    private String sfgl;

    /**
     * 隔离原因
     */
    @TableField(value = "glyy")
    private String glyy;

    /**
     * 是否判不良
     */
    @TableField(value = "sfpbl")
    private String sfpbl;

    /**
     * 不良原因
     */
    @TableField(value = "blyy")
    private String blyy;

    /**
     * 最新更新时间
     */
    @TableField(value = "LastUpdateTime")
    private Date lastUpdateTime;

    /**
     * 最新更新的账户ID
     */
    @TableField(value = "LastUpdateAccountId")
    private String lastUpdateAccountId;

}