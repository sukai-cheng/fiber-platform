package com.ht.shaixuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author chengsukai
 */
@Data
public class ScLsYcdj {
    @TableId(value = "fid",type = IdType.AUTO)
    private Integer fid;

    private Date zdrq;

    private String ycxm;

    private String ycsz;

    private String gcs;

    private String gcsgh;

    private Date qrrq;

    private String qrsm;

    private String ycxb;

    private String yclb;

    private String zdr;

    private String ycbz;

    private String flag;

    private String updateuser;

    private Date updatedate;

}