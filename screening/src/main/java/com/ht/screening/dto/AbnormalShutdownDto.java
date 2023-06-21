package com.ht.screening.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ht.base.utils.DateUtils;
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
     * 筛选长度
     */
    Double sxcd;

    /**
     * 已筛长度 retractLength
     */
    Double yscd;

    /**
     * 剩余长度 residualLen
     */
    Double sycd;

    /**
     * 初始化时间
     */
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    Date initialTime;

    /**
     * 断纤长度
     */
    Double dqcd;

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
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
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
