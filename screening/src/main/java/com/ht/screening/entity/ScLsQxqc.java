package com.ht.screening.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName(value = "sc_ls_qxqc")
public class ScLsQxqc {
    @TableId(value = "LSBH", type = IdType.INPUT)
    private String lsbh;

    @TableField(value = "xh")
    private Integer xh;

    @TableField(value = "zzpbh")
    private String zzpbh;

    @TableField(value = "qxdlx")
    private String qxdlx;

    @TableField(value = "qswz")
    private BigDecimal qswz;

    @TableField(value = "zzwz")
    private BigDecimal zzwz;

    @TableField(value = "sfqc")
    private String sfqc;

    @TableField(value = "sfgl")
    private String sfgl;

    @TableField(value = "glyy")
    private String glyy;

    @TableField(value = "sfpbl")
    private String sfpbl;

    @TableField(value = "blyy")
    private String blyy;

    @TableField(value = "LastUpdateTime")
    private Date lastUpdateTime;

    @TableField(value = "LastUpdateAccountId")
    private String lastUpdateAccountId;

}