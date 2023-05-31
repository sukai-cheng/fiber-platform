package com.ht.screening.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author chengsukai
 */
@Data
@TableName(value = "sx_ls")
public class SxLs {

    @TableId(value = "ID", type = IdType.INPUT)
    private Object id;

    private String sx;

    private String ls;

    private String pp;

    private String createdbyusername;

    private Date createddatetime;

    private Integer isdelete;

    private String lastupdatedusername;

    private Date lastupdateddatetime;

}