package com.ht.screening.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 筛选数据上传DTO
 *
 * @author chengsukai
 */
@Data
public class FilterDetailUploadDto implements Serializable {

    /**
     * 筛选编号
     */
    private String sxbh;
    /**
     * 序号
     */
    private String xh;
    /**
     * 小盘条码
     */
    private String xptm;
    /**
     * 开始位置
     */
    private Long ewz;
    /**
     * 盘长
     */
    private Long cd;
    /**
     * 断纤损失
     */
    private String dqqk;
    /**
     * 断纤长度
     */
    private Long dqcd;
    /**
     * 缺陷类型
     */
    private String qxlb;
    /**
     * 切割长度
     */
    private Double qgcd;
    /**
     * 不良原因
     */
    private String blyy;

    /**
     * 是否打印
     */
    private Long isfg;

    /**
     * 断纤描述长度
     */
    private Long dqmscd;

    /**
     * 用户编号
     */
    private String accoutId;

    /**
     * 班组
     */
    private String bz;

    /**
     * 大盘盘号
     */
    private String ph;

    private String username;

    /**
     * 隔离情况
     */
    private String glqk;

    /**
     * 从前端获取
     */
    private String color;

    /**
     * 开始时间从前端获取
     */
    private Date startDate;

    /**
     * 应力从前端获取
     */
    private String yl;

    /**
     * 盘具信息
     */
    private String pj;

    /**
     * 新旧
     */
    private String xj;

}
