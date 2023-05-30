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
@TableName("SC_LS1")
@Data
public class ScLs1 {
    /**
     * 拉丝编号
     */
    @TableId(value = "LSBH", type = IdType.INPUT)
    private String lsbh;

    /**
     * 周转盘盘号
     */
    @TableField(value = "ZZPBH")
    private String zzpbh;

    /**
     * 周转盘长度
     */
    @TableField(value = "ZZPCD")
    private Object zzpcd;

    /**
     * 光棒编号
     */
    @TableField(value = "GBBH")
    private String gbbh;

    /**
     * 生产班组
     */
    @TableField(value = "SCBZ")
    private String scbz;

    /**
     * 生产日期
     */
    @TableField(value = "SCRQ")
    private Date scrq;

    /**
     * 挂棒人
     */
    @TableField(value = "GH1")
    private String gh1;

    @TableField(value = "GH2")
    private String gh2;

    @TableField(value = "GH3")
    private String gh3;

    /**
     * 设备编号
     */
    @TableField(value = "SBBH")
    private String sbbh;

    /**
     * 内涂
     */
    @TableField(value = "WLBH1")
    private String wlbh1;

    /**
     * 外涂
     */
    @TableField(value = "WLBH2")
    private String wlbh2;

    /**
     * LSTWD
     */
    @TableField(value = "LSTWD")
    private Object lstwd;

    @TableField(value = "LSTSD")
    private Object lstsd;

    @TableField(value = "SFQX")
    private String sfqx;

    @TableField(value = "ZDR")
    private String zdr;

    /**
     * 审核时间
     */
    @TableField(value = "ZDRQ")
    private Date zdrq;

    @TableField(value = "SHR")
    private String checker;

    /**
     * 审核时间
     */
    @TableField(value = "SHRQ")
    private Date shrq;

    @TableField(value = "GB")
    private String gb;

    /**
     * 是否升速
     */
    @TableField(value = "ISrise")
    private Integer isrise;

    @TableField(value = "ManufactureType")
    private String manufactureType;

    @TableField(value = "classA")
    private Double classa;

    @TableField(value = "classB")
    private Double classb;

    @TableField(value = "classC")
    private Double classc;

    @TableField(value = "velocity")
    private Integer velocity;

    /**
     * 断纤首盘
     */
    @TableField(value = "dxsp")
    private String dxsp;

    @TableField(value = "isrgl")
    private Integer isrgl;

    @TableField(value = "SBBH1")
    private String sbbh1;

    @TableField(value = "PLWXH")
    private String plwxh;

    /**
     * 制令号
     */
    @TableField(value = "zlh")
    private String zlh;

    /**
     * 任务号
     */
    @TableField(value = "MPSH")
    private String mpsh;

    @TableField(value = "NumOfSML")
    private Integer numOfSml;

    @TableField(value = "ISClareStove")
    private Integer isClareStove;

    @TableField(value = "ISClareMold")
    private Integer isClareMold;

    @TableField(value = "StrStove")
    private String strStove;

    @TableField(value = "StrMold")
    private String strMold;

    @TableField(value = "StrRise")
    private String strRise;

    @TableField(value = "YM")
    private String ym;

    @TableField(value = "ISLSOK")
    private Integer islsok;

    @TableField(value = "GROUPID")
    private Integer groupId;

    @TableField(value = "NextGPTime")
    private Date nextGptime;

    @TableField(value = "AllotCount")
    private Integer allotCount;

    @TableField(value = "IGcount")
    private Integer igCount;

    /**
     * 产量辅助计算列 - A班系数
     */
    @TableField(value = "FA")
    private Double fa;

    /**
     * 产量辅助计算列 - B班系数
     */
    @TableField(value = "FB")
    private Double fb;

    /**
     * 产量辅助计算列 - C班系数
     */
    @TableField(value = "FC")
    private Double fc;

    /**
     * 产量辅助计算列 - C班产量
     */
    @TableField(value = "FLENC")
    private Double flenc;

    /**
     * 产量辅助计算列 - B班产量
     */
    @TableField(value = "FLENB")
    private Double flenb;

    /**
     * 产量辅助计算列 - A班产量
     */
    @TableField(value = "FLENA")
    private Double flena;

    /**
     * 产量辅助计算列 - 其他拉丝班组1
     */
    @TableField(value = "StrCL")
    private String strcl;

    /**
     * 产量辅助计算列 - 其他拉丝班组2
     */
    @TableField(value = "StrCL1")
    private String strcl1;

    /**
     * 产量辅助计算列 - 其他拉丝班组3
     */
    @TableField(value = "StrCL2")
    private String strcl2;

    @TableField(value = "StrF")
    private String strf;

    /**
     * 产量辅助计算列 - 产量系数和并列
     */
    @TableField(value = "StrFormula")
    private String strFormula;

    /**
     * 产量辅助计算列 - 总产量
     */
    @TableField(value = "CLTotal")
    private Double clTotal;

    @TableField(value = "Mchange")
    private String mchange;

    @TableField(value = "LLCD")
    private Double llcd;

    @TableField(value = "sxcd")
    private Double sxcd;

    @TableField(value = "mpcd")
    private Double mpcd;

    /**
     * 盘具号
     */
    @TableField(value = "PJnum")
    private String pjnum;

    @TableField(value = "JDWZ")
    private Double jdwz;


    @TableField(value = "isout")
    private Integer isout;

    @TableField(value = "ischange")
    private Integer ischange;

    /**
     * 保温炉
     */
    @TableField(value = "bwl")
    private Integer bwl;

    /**
     * 保温炉备注
     */
    private String bwlbz;

    @TableField(value = "jsbz")
    private String jsbz;

    @TableField(value = "ismini")
    private String ismini;

    @TableField(value = "isyx")
    private String isyx;

    /**
     * 升速盘标识
     */
    @TableField(value = "isbs")
    private Integer isbs;

    /**
     * 最后更新时间
     */
    @TableField(value = "LastUpdateTime")
    private Date lastUpdateTime;

    /**
     * 修改人
     */
    @TableField(value = "LastUpdateAccountId")
    private String lastUpdateAccountId;

    /**
     * 内涂料编号
     */
    @TableField(value = "WLBH1Number")
    private String wlbh1number;

    /**
     * 外涂料编号
     */
    @TableField(value = "WLBH2Numver")
    private String wlbh2number;

    /**
     * 颜色
     */
    @TableField(value = "Color")
    private String color;

    /**
     * 是否返修；0为否；1为是
     */
    @TableField(value = "isFX")
    private Integer isfx;

    /**
     * 留纤失败；0为否；1为是
     */
    @TableField(value = "SampleKeepFailed")
    private Integer sampleKeepFailed;

    @TableField(value = "LampType")
    private String lampType;

    /**
     * 一致性检查
     */
    @TableField(value = "ConsistencyCheck")
    private Integer consistencyCheck;

    /**
     * 是否自动断纤0/1
     */
    @TableField(value = "iszddq")
    private Integer iszddq;

    /**
     * 自动断纤位置ABC
     */
    @TableField(value = "zddqwz")
    private String zddqwz;

    @TableField(value = "WLBH1ModelType")
    private String wlbh1ModelType;

    @TableField(value = "WLBH2ModelType")
    private String wlbh2ModelType;

    /**
     * 软光缆名称
     */
    @TableField(value = "rglName")
    private String rglName;
}