package com.ht.screening.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chengsukai
 */
@Data
public class FiberFilterMainDiskVo implements Serializable {

    /**
     * 筛选编号
     */
    private String sxbh;

    /**
     * 原始盘号, 大盘编号
     */
    private String ysph;

    /**
     * 生产班组
     */
    private String scbz;

    /**
     * 生产日期
     */
    private Date scrq;

    /**
     * 设备编号
     */
    private String sbbh;

    /**
     * 工号
     */
    private String gh;

    /**
     * 放线张力
     */
    private Object fxzl;

    /**
     * 设备状况
     */
    private String sbzk;

    /**
     * 收线张力
     */
    private Object sxzl;

    /**
     * 收线速度
     */
    private Object sxsd;

    /**
     * 是否缺陷
     */
    private String sfqx;

    /**
     * 暂不需要
     */
    private String sfdq;

    /**
     * 制单人
     */
    private String zdr;

    /**
     * 制单日期
     */
    private Date zdrq;

    /**
     * 审核人
     */
    private String checker;

    /**
     * 审核日期
     */
    @TableField(value = "SHRQ")
    private Date shrq;

    /**
     * 光纤长度
     */
    private Double gqcd;

    /**
     * 应力
     */
    private String yl;

    /**
     * 暂不需要
     */
    private String lsrate;

    /**
     * 未知字段
     */
    private String mpsh;

    /**
     * 暂不需要
     */
    private String zlh;

    /**
     * 类别
     */
    private String categoryName;

}
