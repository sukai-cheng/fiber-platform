package com.ht.screening.vo;

import java.io.Serializable;

/**
 * 断纤信息
 *
 * @author chengsukai
 */
public class FiberCutVo implements Serializable {

    /**
     * 开始位置
     */
    String startPos;

    /**
     * 结束位置
     */
    String endPos;

    /**
     * 分切长度
     */
    Double slitterLen;

    /**
     * 拉丝编号
     */
    String fiberDrawingNum;

    /**
     * 缺陷类型
     */
    String defectType;

    /**
     * 拉丝起始位置
     */
    String fiberDrawingStartPos;

    /**
     * 拉丝终止位置
     */
    String fiberDrawingEndPos;

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
