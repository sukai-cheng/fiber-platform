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
    public float payOffLength;
    //收线长度 sxcd
    public float retractLength;
    //收线长度设定 sxcdsd
    public float assignRetractLength;
    //实际张力 sjzl
    public float actualTension;
    //正常运行 zcyx
    public int normalRun;
    //异常停止 yctz
    public int exceptionStop;
}
