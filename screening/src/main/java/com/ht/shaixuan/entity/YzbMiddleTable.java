package com.ht.shaixuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 预制棒中间表(江苏亨通光导新材料有限公司)
 *
 * @author chengsukai
 */
@Data
@TableName("yzb_MiddleTable")
public class YzbMiddleTable {
    /**
     * 自编ID
     */
    @TableId(value = "GSID",type = IdType.INPUT)
    private String gsid;

    /**
     * 自增ID
     */
    @TableField(value = "fId")
    private Integer fid;

    /**
     * 单号
     */
    @TableField(value = "ORDERNO")
    private String orderno;

    /**
     * 物料编码
     */
    @TableField(value = "MATNR")
    private String matnr;

    /**
     * 公司编号
     */
    @TableField(value = "LIFNR")
    private String lifnr;

    /**
     * 最后发货时间
     */
    @TableField(value = "LastUpdateTime")
    private Date lastupdatetime;

    /**
     * 原始ID号
     */
    @TableField(value = "IniID")
    private String iniid;

    /**
     * 有效长度
     */
    @TableField(value = "AvailbaleCD")
    private BigDecimal availbalecd;

    /**
     * 销售重量
     */
    @TableField(value = "heft")
    private BigDecimal heft;

    /**
     * 截止波长
     */
    @TableField(value = "jzbc")
    private String jzbc;

    /**
     * 理论长度
     */
    @TableField(value = "ThearyCD")
    private BigDecimal thearycd;

    /**
     * 最大直径
     */
    @TableField(value = "diaMax")
    private BigDecimal diamax;

    /**
     * 最小直径
     */
    @TableField(value = "diaMin")
    private BigDecimal diamin;

    /**
     * MFD
     */
    @TableField(value = "MFD")
    private String mfd;

    /**
     * 产品类别
     */
    @TableField(value = "ManufactureType")
    private String manufacturetype;

    /**
     * 类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 在线1，离线0
     */
    @TableField(value = "Mstatus")
    private Integer mstatus;

    /**
     * 隔离开始位置
     */
    @TableField(value = "glkswz")
    private BigDecimal glkswz;

    /**
     * 隔离终止位置
     */
    @TableField(value = "glzzwz")
    private BigDecimal glzzwz;

    /**
     * 非计费重量
     */
    @TableField(value = "fjfheft")
    private BigDecimal fjfheft;

    /**
     * 平均直径
     */
    @TableField(value = "diaPJ")
    private BigDecimal diapj;

    /**
     * 状态（R,T棒等。。。）
     */
    @TableField(value = "Status")
    private String status;

    /**
     * 亨通棒实际拉丝长度
     */
    @TableField(value = "ActualLen")
    private BigDecimal actuallen;

    /**
     * 光棒信息（备注）
     */
    @TableField(value = "Remark")
    private String remark;

    /**
     * 节点信息
     */
    @TableField(value = "NodeInfo")
    private String nodeinfo;

    /**
     * 是否删除
     */
    @TableField(value = "IS_Delete")
    private String isDelete;

    /**
     * 重量
     */
    @TableField(value = "StandBy1")
    private BigDecimal standby1;

    /**
     * 预留栏位2
     */
    @TableField(value = "StandBy2")
    private String standby2;

    /**
     * 预留栏位3
     */
    @TableField(value = "StandBy3")
    private String standby3;

    /**
     * 导入时间
     */
    @TableField(value = "ImportTime")
    private Date importtime;

    /**
     * 外包层类型
     */
    @TableField(value = "TOutCald")
    private String toutcald;

    /**
     * 类型备注
     */
    @TableField(value = "TypeMark")
    private String typemark;

    @TableField(value = "jdzbN")
    private String jzbcn;

    /**
     * 静置时间
     */
    @TableField(value = "RestTime")
    private BigDecimal resttime;

}