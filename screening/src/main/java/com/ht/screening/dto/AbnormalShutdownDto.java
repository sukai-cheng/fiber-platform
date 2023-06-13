package com.ht.screening.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chengsukai
 */
@Data
public class AbnormalShutdownDto implements Serializable {

    /**
     * 盘号
     */
    String ph;

    /**
     * 筛选编号
     */
    String sxbh;

    /**
     * 已筛长度
     */
    Double cd;

    /**
     * 初始化时间
     */
    Date initialTime;

    /**
     * 断纤长度
     */
    Long dqcd;

    /**
     * 用户编号
     */
    private String accoutId;

    /**
     * 不良原因
     */
    private String blyy;

    /**
     * 班组
     */
    private String bz;

    /**
     * 用户名
     */
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

    /**
     * 收线长度设定
     */
    private String pyccd;

    /**
     * 后轮长度
     */
    private String hlcd;

}
