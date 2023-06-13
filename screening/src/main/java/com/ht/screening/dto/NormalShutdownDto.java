package com.ht.screening.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chengsukai
 */
@Data
public class NormalShutdownDto implements Serializable {

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
    Double sxcd;

    /**
     * 用户登陆后的时候
     */
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

}
