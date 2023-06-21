package com.ht.screening.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class DeviceDataDto implements Serializable {
    String pyccd;
    Double hlcd;
    /**
     * 筛选长度 payOffLength
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
}
