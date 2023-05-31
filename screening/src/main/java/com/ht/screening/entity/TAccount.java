package com.ht.screening.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author chengsukai
 */
@TableName("t_Account")
@Data
public class TAccount {

    @TableId(value = "fid", type = IdType.AUTO)
    private Integer fid;

    @TableField(value = "fAccount")
    private String fAccount;

    @TableField(value = "fName")
    private String fName;

    @TableField(value = "fPassword")
    private String fPassword;

    @TableField(value = "fIsAdmin")
    private Boolean fIsAdmin;

    @TableField(value = "State")
    private Integer state;

    /**
     * 1工段长
     */
    @TableField(value = "fSection")
    private Integer fSection;
}