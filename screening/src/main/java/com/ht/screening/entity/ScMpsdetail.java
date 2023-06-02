package com.ht.screening.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author chengsukai
 */
@Data
@TableName("sc_mpsdetail")
public class ScMpsdetail {
    /**
     * 单据号
     */
    @TableId("paperno")
    private String receiptNo;

    /**
     * 序号
     */
    @TableField(value = "itemid")
    private Integer itemId;

    /**
     * 生产线
     */
    @TableField(value = "productline")
    private String productLine;

    /**
     * 制令号
     */
    @TableField(value = "zlh")
    private String commandNum;

    /**
     * 本次下达数量
     */
    @TableField(value = "qty")
    private Double deliveredQuantity;

    /**
     * 段长
     */
    @TableField(value = "dc")
    private Double segmentLen;

    /**
     * 切割长度
     */
    @TableField(value = "qiegecd")
    private Double cutLen;

    /**
     * 备注
     */
    @TableField(value = "note")
    private String note;

    /**
     * 要求日期
     */
    @TableField(value = "yqrq")
    private Date requiredDate;

    /**
     * 入库数量
     */
    @TableField(value = "rkqty")
    private Double stockedNum;

    /**
     * 完成日期
     */
    @TableField(value = "wcrq")
    private Date completeDate;

    /**
     * 产品
     */
    @TableField(value = "ManufactureType")
    private String manufactureType;

    /**
     * 等级
     */
    @TableField(value = "JYJG")
    private String grade;

    /**
     * 拉丝数量
     */
    @TableField(value = "LSSL")
    private Double drawingNumber;

    /**
     * 是否关闭
     */
    @TableField(value = "isclose")
    private Integer isClose;

    /**
     * 暂停
     */
    @TableField(value = "iscrease")
    private Integer isPause;

    /**
     * 暂停时间
     */
    @TableField(value = "ztsj")
    private Date pauseTime;

    /**
     * 任务单号
     */
    @TableField(value = "MPSH")
    private String taskNum;

}