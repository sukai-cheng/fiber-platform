package com.ht.screening.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("JC_yzb")
public class JcYzb {

    @TableId(value = "GSid",type = IdType.INPUT)
    private String gsid;

    @TableField("paperno")
    private String paperno;

    @TableField("itemid")
    private Integer itemid;

    @TableField("id")
    private String id;

    @TableField("customerid")
    private String customerid;

    @TableField("username")
    private String username;

    /**
    * 入库时间
    */
    @TableField("indate")
    private Date indate;

    @TableField("availabilityCD")
    private BigDecimal availabilitycd;

    @TableField("heft")
    private BigDecimal heft;

    @TableField("JZBC")
    private String jzbc;

    @TableField("fjfcd")
    private BigDecimal fjfcd;

    @TableField("theoryCD")
    private BigDecimal theorycd;

    @TableField("diaMax")
    private BigDecimal diamax;

    @TableField("diaMin")
    private BigDecimal diamin;

    @TableField("diaPJ")
    private BigDecimal diapj;

    @TableField("type")
    private String type;

    @TableField("Mstatus")
    private String mstatus;

    @TableField("ManufactureType")
    private String manufacturetype;

    @TableField("isTE")
    private Integer iste;

    @TableField("wlbh")
    private String wlbh;

    @TableField("glzzwz")
    private BigDecimal glzzwz;

    @TableField("glkswz")
    private BigDecimal glkswz;

    @TableField("sybgl")
    private Integer sybgl;

    @TableField("lswc")
    private Integer lswc;

    @TableField("sxwc")
    private Integer sxwc;

    @TableField("jcwc")
    private Integer jcwc;

    @TableField("lssspcd")
    private BigDecimal lssspcd;

    @TableField("sxsspcd")
    private BigDecimal sxsspcd;

    @TableField("jcsspcd")
    private BigDecimal jcsspcd;

    @TableField("isclose")
    private Integer isclose;

    @TableField("TotalLen")
    private Double totallen;

    @TableField("CutLen")
    private Double cutlen;

    @TableField("IsLX")
    private Integer islx;

    @TableField("total_islen")
    private Double totalLslen;

    @TableField("total_SXlen")
    private Double totalSxlen;

    @TableField("total_RiseLen")
    private Double totalRiselen;

    @TableField("ischange")
    private Integer ischange;

    @TableField("Rbang")
    private String rbang;

    @TableField("Hjdcd")
    private String hjdcd;

    @TableField("fId")
    private Long fid;

    /**
    * 最后更新时间
    */
    @TableField("LastUpdateTime")
    private Date lastupdatetime;

    @TableField("SCZC")
    private BigDecimal sczc;

    @TableField("Ratio")
    private BigDecimal ratio;

    @TableField("TypeMark")
    private String typemark;

    /**
    * 供应商批次号
    */
    @TableField("SupplierLot")
    private String supplierlot;

    /**
    * 进入研发产品库标识
    */
    @TableField("YF")
    private String yf;

}