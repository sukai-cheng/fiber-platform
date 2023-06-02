package com.ht.screening.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class DeviceInfoVo implements Serializable {
    //实际速度 sjsd
    private float actualVelocity;
    //放线长度 fxcd
    private float payOffLength;
    //收线长度 sxcd
    private float retractLength;
    // 剩余长度
    private float residualLen;
    //收线长度设定 sxcdsd
    private float assignRetractLength;
    //实际张力 sjzl
    private float actualTension;
    //正常运行 zcyx
    private int normalRun;
    //异常停止 yctz
    private int exceptionStop;

}
