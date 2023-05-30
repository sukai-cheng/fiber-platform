package com.ht.shaixuan.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


/**
 * @author chengsukai
 */
@Data
@TableName("SC_SX")
public class ScSx {

    /**
     * 筛选编号
     */
    private String sxbh;

    /**
     *
     */
    private String ysph;

    private String scbz;

    private Date scrq;

    private String sbbh;

    private String gh;

    private Object fxzl;

    private String sbzk;

    private Object sxzl;

    private Object sxsd;

    private String sfqx;

    private String sfdq;

    private String zdr;

    private Date zdrq;

    private String shr;

    private Date shrq;

    private Double gqcd;

    private String yl;

    private String lsrate;

    private String mpsh;

    private String zlh;

    private Integer isrise;

    private Integer ischange;

    private Integer sxts;

    private String color;

    private String pj;

    private String xj;

    private Date shrqh;

    /**
    * 最后更新时间
    */
    private Date lastupdatetime;

    private String lastupdateaccountid;

}