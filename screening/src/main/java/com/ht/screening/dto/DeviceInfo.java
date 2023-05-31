package com.ht.screening.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 获取设备信息
 *
 * @author chengsukai
 */
@Data
@Setter
@Getter
public class DeviceInfo implements Serializable {
    //实际速度
    public float actualVelocity;
    //设定速度1
    public float assignSpeed1;
    //设定速度2
    public float assignSpeed2;
    //放线长度
    public float payOffLength;
    //收线长度
    public float retractLength;
    //收线长度设定
    public float assignRetractLength;
    //设定张力
    public float assignTension;
    //实际张力
    public float actualTension;
    //收线剩余时间
    public float retractRemainTime;
    //筛选模式
    public int filterPattern;
    //复绕模式
    public int rewoundMode;
    //收线节距
    public float retractPitch;
    //放线节距
    public float payOffPitch;
    //正常运行
    public int normalRun;
    //异常停止
    public int exceptionStop;
    //收线清零
    public int retractClearZero;
    //放线清零
    public int payOffClearZero;
    //收线夹紧
    public int retractClamping;
    //放线夹紧
    public int payOffClamping;
    //收线盘直径
    public float reelDiameter;
    //放线盘直径
    public float payOffDiameter;
    //收线编码器故障
    public int cableEncoderFaulty;
    //放线牵引编码器故障
    public int payOffTractionEncoderFaulty;
    //收线排线编码器故障
    public int routingReceivingEncoderFaulty;
    //放线伺服报警
    public int payOffServoAlarm;
    //收线伺服报警
    public int retractingServoAlarm;
    //放线牵引伺服报警
    public int payOffTractionServoAlarm;
    //收线牵引伺服报警
    public int drawingServoAlarm;
    //放线排线伺服报警
    public int wireLayingServoAlarm;
    //收线排线伺服报警
    public int wireRewindingServoAlarm;
    //气压故障
    public int pneumaticFailure;
    //收线牵引计米故障
    public int lineDrawingMeterFaulty;
    //张力故障
    public int tensionFault;
    //收线排线右限位
    public int limitRightWindingLine;
    //收线排线左限位
    public int limitLeftWindingLine;
    //放线排线前进
    public int assignOutLineForward;
    //放线排线后退
    public int assignOutLineBack;
    //收线排线前进
    public int lineUpForward;
    //收线排线后退
    public int lineUpBack;
}
