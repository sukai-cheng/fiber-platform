package com.ht.screening.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("SX_Log")
@Data
public class SxLog {

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField("lx")
    private Integer lx;

    @TableField("sxbh")
    private String sxbh;

    @TableField("xptm")
    private String xptm;

    @TableField("dpph")
    private String dpph;

    @TableField("sxjt")
    private String sxjt;

    @TableField("dates")
    private Date dates;

    @TableField("sqlError")
    private String sqlerror;

    @TableField("sql")
    private String sql;

}