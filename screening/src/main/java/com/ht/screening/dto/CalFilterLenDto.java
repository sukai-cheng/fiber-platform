package com.ht.screening.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class CalFilterLenDto implements Serializable {
    /**
     * 筛选总长度
     */
    String totalLen;
    /**
     * 光纤盘号
     */
    String fiberDiskNum;
    /**
     * 切割长度
     */
    String cutLen;
    /**
     * 大盘长度
     */
    String mainPlateLen;

    /**
     * 缺陷信息
     */
    FiberDrawingDefectInfo rstqx;

    /**
     * 筛选长度
     */
    String filterLen;
}
