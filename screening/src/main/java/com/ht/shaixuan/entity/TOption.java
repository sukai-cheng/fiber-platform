package com.ht.shaixuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author chengsukai
 */
@Data
@TableName("T_Option")
public class TOption {

    @TableId(value = "fid", type = IdType.AUTO)
    private Integer fid;

    @TableField(value = "Action")
    private String action;

    @TableField(value = "Option")
    private String option;

    @TableField(value = "OptionValue")
    private String optionValue;

    @TableField(value = "Bz")
    private String bz;

    @TableField(value = "Creator")
    private String creator;

    @TableField(value = "Account")
    private String account;

    @TableField(value = "Time")
    private Date time;
}