package com.ht.screening.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chengsukai
 */
@Data
public class NormalShutdownDto implements Serializable {

    String ph;
    String sxbh;
    /**
     * 已筛长度
     */
    Double cd;

    Date initialTime;

    Long dqcd;

    /**
     * 用户编号
     */
    private String accoutId;

    /**
     * 班组
     */
    private String bz;

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
