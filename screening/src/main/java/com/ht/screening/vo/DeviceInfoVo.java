package com.ht.screening.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class DeviceInfoVo implements Serializable {
    //实际速度 sjsd
    private Double actualVelocity;
    //放线长度 fxcd
    private Double payOffLength;
    //收线长度 sxcd
    private Double retractLength;
    // 剩余长度
    private Double residualLen;
    //收线长度设定 sxcdsd
    private Double assignRetractLength;
    //实际张力 sjzl
    private Double actualTension;
    //正常运行 zcyx
    private int normalRun;
    //异常停止 yctz
    private int exceptionStop;

}
