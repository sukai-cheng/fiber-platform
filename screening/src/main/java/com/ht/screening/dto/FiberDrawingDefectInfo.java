package com.ht.screening.dto;

import lombok.Data;

/**
 * 拉丝缺陷信息
 *
 * @author chengsukai
 */
@Data
public class FiberDrawingDefectInfo {

    /**
     * 开始位置
     */
    Double startPos;

    /**
     * 结束位置
     */
    Double endPos;

    /**
     * 分切长度
     */
    Double slitterLen;


    /**
     * 缺陷类型
     */
    String defectType;

    /**
     * 拉丝起始位置
     */
    Double fiberDrawingStartPos;

    /**
     * 拉丝终止位置
     */
    Double fiberDrawingEndPos;

    /**
     * 是否切除
     */
    String isExcision;

    /**
     * 是否隔离
     */
    String isIsolation;

    /**
     * 隔离原因
     */
    String isolationReason;

    /**
     * 是否判不良
     */
    String isDefective;

    /**
     * 不良原因
     */
    String defectiveReason;


}
