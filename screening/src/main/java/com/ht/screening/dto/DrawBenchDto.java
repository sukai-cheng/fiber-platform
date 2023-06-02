package com.ht.screening.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class DrawBenchDto implements Serializable {

    /**
     * 光纤盘号
     */
    String diskNum;
    /**
     * 大盘长度
     */
    String mainDiskLen;

    /**
     * 制令号
     */
    String commandOrder;

    /**
     * 生产计划号
     */
    String productPlanNum;

    /**
     * 拉丝班组
     */
    String drawBenchGroup;

    /**
     * 拉丝人
     */
    String drawBenchPerson;

    /**
     * 段长
     */
    Double segmentLen;

    /**
     * 切割长度
     */
    Double cutLen;


}
