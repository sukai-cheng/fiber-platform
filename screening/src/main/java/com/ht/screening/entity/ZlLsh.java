package com.ht.screening.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author chengsukai
 */
@TableName("ZL_LSH")
@Data
public class ZlLsh {
    @TableId(value = "JYDH", type = IdType.AUTO)
    private String jydh;

    @TableField("JYRQ")
    private Date jyrq;

    @TableField("SCBZ")
    private String scbz;

    @TableField("JYJG")
    private String jyjg;

    @TableField("GH")
    private String gh;

    @TableField("GQPH")
    private String gqph;

    @TableField("WLBH")
    private String wlbh;

    @TableField("ZDR")
    private String zdr;

    @TableField("ZDRQ")
    private Date zdrq;

    @TableField("SHR")
    private String checker;

    @TableField("SHRQ")
    private Date shrq;

    @TableField("bhg")
    private Integer bhg;

    @TableField("ManufactureType")
    private String manufacturetype;

    @TableField("ISOK_pk2200")
    private Integer isokPk2200;

    @TableField("ISOK_pk2400")
    private Integer isokPk2400;

    @TableField("isYB")
    private Integer isyb;

    @TableField("ischange")
    private Integer ischange;

    @TableField("GLPH")
    private String glph;

    @TableField("ismini")
    private String ismini;

    @TableField("isYellow")
    private Integer isyellow;

    @TableField("isCoatingYC")
    private Integer iscoatingyc;


}