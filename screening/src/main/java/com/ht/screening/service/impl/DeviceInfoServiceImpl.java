package com.ht.screening.service.impl;

import HslCommunication.Core.Types.OperateResultExOne;
import HslCommunication.Profinet.Siemens.SiemensS7Net;
import com.ht.base.exception.ServiceException;
import com.ht.base.utils.DateUtils;
import com.ht.base.utils.NumberUtils;
import com.ht.base.utils.bean.BeanUtils;
import com.ht.screening.dto.DeviceInfo;
import com.ht.screening.dto.DrawBenchDto;
import com.ht.screening.dto.FilterUploadDto;
import com.ht.screening.entity.ScSx;
import com.ht.screening.entity.ScSx2;
import com.ht.screening.mapper.*;
import com.ht.screening.service.DeviceInfoService;
import com.ht.screening.vo.DeviceInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.logging.Filter;

/**
 * 获取设备信息
 *
 * @author chengsukai
 */
@Service
@Slf4j
public class DeviceInfoServiceImpl implements DeviceInfoService {

    @Resource
    private DeviceConnectServiceImpl deviceConnectService;

    @Resource
    private ScSxMapper scSxMapper;

    @Resource
    private ScLsQxqcMapper scLsQxqcMapper;

    @Resource
    ScLs1Mapper scLs1Mapper;
    @Resource
    private ScSx2Mapper scSx2Mapper;


    @Resource
    private SxLogMapper sxLogMapper;

    @Override
    public DeviceInfoVo getDeviceInfo(String fiberDiskNum) {

        DeviceInfo deviceInfo = new DeviceInfo();
        // 通过西门子S7-S1500协议模块连接设备
        try {
            SiemensS7Net siemensS7Net = deviceConnectService.getLongSiemensS7Net("10.6.185.214", 102);
            OperateResultExOne<byte[]> read = siemensS7Net.Read("DB22.DBD158", (short) 105);
            if (read.IsSuccess) {
                //实际速度
                System.out.println("实际速度");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD0").Content);
                deviceInfo.setActualVelocity(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD0").Content));
                //设定速度1
                System.out.println("设定速度1");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD48").Content);
                deviceInfo.setAssignSpeed1(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD48").Content));
                //设定速度2
                System.out.println("设定速度2");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD52").Content);
                deviceInfo.setAssignSpeed2(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD52").Content));
                //放线长度
                System.out.println("放线长度");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD4").Content);
                deviceInfo.setPayOffLength(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD4").Content));
                //收线长度
                System.out.println("收线长度");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD158").Content);
                deviceInfo.setRetractLength(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD158").Content));
                //收线长度设定
                System.out.println("收线长度设定");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD8").Content);
                deviceInfo.setAssignRetractLength(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD8").Content));
                //设定张力
                System.out.println("设定张力");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD24").Content);
                deviceInfo.setAssignTension(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD24").Content));
                //实际张力
                System.out.println("实际张力");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD36").Content);
                deviceInfo.setActualTension(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD36").Content));
                //收线剩余时间
                System.out.println("收线剩余时间");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBW124").Content);
                deviceInfo.setRetractRemainTime(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBW124").Content));
                //筛选模式
                System.out.println("筛选模式");
                System.out.println(siemensS7Net.ReadBool("DB22.DBX118.0").Content ? 1 : 0);
                deviceInfo.setFilterPattern(siemensS7Net.ReadBool("DB22.DBX118.0").Content ? 1 : 0);
                //复绕模式
                System.out.println("复绕模式");
                System.out.println(siemensS7Net.ReadBool("DB22.DBX118.0").Content ? 1 : 0);
                deviceInfo.setRewoundMode(siemensS7Net.ReadBool("DB22.DBX118.0").Content ? 1 : 0);
                //收线节距
                System.out.println("收线节距");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD88").Content);
                deviceInfo.setRetractPitch(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD88").Content));
                //放线节距
                System.out.println("放线节距");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD20").Content);
                deviceInfo.setPayOffPitch(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD20").Content));
                //正常运行
                System.out.println("正常运行"); //DB2.DBX1.1
                System.out.println(siemensS7Net.ReadBool("DB2.DBX1.3").Content ? 1 : 0);
                deviceInfo.setNormalRun(siemensS7Net.ReadBool("DB2.DBX1.3").Content ? 1 : 0);
                //异常停止
                System.out.println("异常停止"); //DB2.DBX0.2
                System.out.println(siemensS7Net.ReadBool("DB2.DBX1.5").Content ? 1 : 0);
                deviceInfo.setExceptionStop(siemensS7Net.ReadBool("DB2.DBX1.5").Content ? 1 : 0);
                //收线清零
                System.out.println("收线清零");
                System.out.println(siemensS7Net.ReadBool("DB22.DBX140.4").Content ? 1 : 0);
                deviceInfo.setRetractClearZero(siemensS7Net.ReadBool("DB22.DBX140.4").Content ? 1 : 0);
                //放线清零
                System.out.println("放线清零");
                System.out.println(siemensS7Net.ReadBool("DB22.DBX117.2").Content ? 1 : 0);
                deviceInfo.setPayOffClearZero(siemensS7Net.ReadBool("DB22.DBX117.2").Content ? 1 : 0);
                //收线夹紧
                System.out.println("收线夹紧");
                System.out.println(siemensS7Net.ReadBool("DB2.DBX2.5").Content ? 1 : 0);
                deviceInfo.setRetractClamping(siemensS7Net.ReadBool("DB2.DBX2.5").Content ? 1 : 0);
                //放线夹紧
                System.out.println("放线夹紧");
                System.out.println(siemensS7Net.ReadBool("DB2.DBX1.2").Content ? 1 : 0);
                deviceInfo.setPayOffClamping(siemensS7Net.ReadBool("DB2.DBX1.2").Content ? 1 : 0);
                //收线盘直径
                System.out.println("收线盘直径");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD44").Content);
                deviceInfo.setReelDiameter(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD44").Content));
                //放线盘直径
                System.out.println("放线盘直径");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD16").Content);
                deviceInfo.setPayOffDiameter(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD16").Content));
                //收线编码器故障
                System.out.println("收线编码器故障");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX2.1").Content ? 1 : 0);
                deviceInfo.setCableEncoderFaulty(siemensS7Net.ReadBool("DB21.DBX2.1").Content ? 1 : 0);
                //放线牵引编码器故障
                System.out.println("放线牵引编码器故障");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX1.5").Content ? 1 : 0);
                deviceInfo.setPayOffTractionEncoderFaulty(siemensS7Net.ReadBool("DB21.DBX1.5").Content ? 1 : 0);
                //收线排线编码器故障
                System.out.println("收线排线编码器故障");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX2.5").Content ? 1 : 0);
                deviceInfo.setRoutingReceivingEncoderFaulty(siemensS7Net.ReadBool("DB21.DBX2.5").Content ? 1 : 0);
                //放线伺服报警
                System.out.println("放线伺服报警");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX0.0").Content ? 1 : 0);
                deviceInfo.setPayOffServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.0").Content ? 1 : 0);
                //收线伺服报警
                System.out.println("收线伺服报警");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX0.4").Content ? 1 : 0);
                deviceInfo.setRetractingServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.4").Content ? 1 : 0);
                //放线牵引伺服报警
                System.out.println("放线牵引伺服报警");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX0.2").Content ? 1 : 0);
                deviceInfo.setPayOffTractionServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.2").Content ? 1 : 0);
                //收线牵引伺服报警
                System.out.println("收线牵引伺服报警");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX0.3").Content ? 1 : 0);
                deviceInfo.setDrawingServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.3").Content ? 1 : 0);
                //放线排线伺服报警
                System.out.println("放线排线伺服报警");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX0.1").Content ? 1 : 0);
                deviceInfo.setWireLayingServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.1").Content ? 1 : 0);
                //收线排线伺服报警
                System.out.println("收线排线伺服报警");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX0.5").Content ? 1 : 0);
                deviceInfo.setWireRewindingServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.5").Content ? 1 : 0);
                //气压故障
                System.out.println("气压故障");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX6.7").Content ? 1 : 0);
                deviceInfo.setPneumaticFailure(siemensS7Net.ReadBool("DB21.DBX6.7").Content ? 1 : 0);
                //收线牵引计米故障
                System.out.println("收线牵引计米故障");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX1.4").Content ? 1 : 0);
                deviceInfo.setLineDrawingMeterFaulty(siemensS7Net.ReadBool("DB21.DBX1.4").Content ? 1 : 0);
                //张力故障
                System.out.println("张力故障");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX6.4").Content ? 1 : 0);
                deviceInfo.setTensionFault(siemensS7Net.ReadBool("DB21.DBX6.4").Content ? 1 : 0);
                //收线排线右限位
                System.out.println("收线排线右限位");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX6.3").Content ? 1 : 0);
                deviceInfo.setLimitRightWindingLine(siemensS7Net.ReadBool("DB21.DBX6.3").Content ? 1 : 0);
                //收线排线左限位
                System.out.println("收线排线左限位");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX6.2").Content ? 1 : 0);
                deviceInfo.setLimitLeftWindingLine(siemensS7Net.ReadBool("DB21.DBX6.2").Content ? 1 : 0);
                //放线排线前进
                System.out.println("放线排线前进");
                System.out.println(siemensS7Net.ReadBool("DB22.DBX116.3").Content ? 1 : 0);
                deviceInfo.setAssignOutLineForward(siemensS7Net.ReadBool("DB22.DBX116.3").Content ? 1 : 0);
                //放线排线后退
                System.out.println("放线排线后退");
                System.out.println(siemensS7Net.ReadBool("DB22.DBX116.2").Content ? 1 : 0);
                deviceInfo.setAssignOutLineBack(siemensS7Net.ReadBool("DB22.DBX116.2").Content ? 1 : 0);
                //收线排线前进
                System.out.println("收线排线前进");
                System.out.println(siemensS7Net.ReadBool("DB22.DBX116.5").Content ? 1 : 0);
                deviceInfo.setLineUpForward(siemensS7Net.ReadBool("DB22.DBX116.5").Content ? 1 : 0);
                //收线排线后退
                System.out.println("收线排线后退");
                System.out.println(siemensS7Net.ReadBool("DB22.DBX116.4").Content ? 1 : 0);
                deviceInfo.setLineUpBack(siemensS7Net.ReadBool("DB22.DBX116.4").Content ? 1 : 0);
            }
        } catch (Exception e) {
            log.error("connect failed");
            throw new ServiceException("E1001");
        }

        DeviceInfoVo deviceInfoVo = new DeviceInfoVo();
        deviceInfoVo.setActualVelocity(deviceInfo.getActualVelocity());
        deviceInfoVo.setPayOffLength(deviceInfo.getPayOffLength());
        deviceInfoVo.setRetractLength(deviceInfo.getRetractLength());
        deviceInfoVo.setAssignRetractLength(deviceInfo.getAssignRetractLength());
        deviceInfoVo.setActualTension(deviceInfo.getActualTension());
        deviceInfoVo.setNormalRun(deviceInfo.getNormalRun());
        deviceInfoVo.setExceptionStop(deviceInfo.getExceptionStop());
        DrawBenchDto drawBenchInfo = scLs1Mapper.getDrawBenchInfo(fiberDiskNum);
        Double cutLen = drawBenchInfo.getCutLen();// 切割长度
        deviceInfoVo.setResidualLen((float) (cutLen - deviceInfo.getRetractLength()));

        return deviceInfoVo;
    }


    /**
     * 异常停机 todo
     *
     * @param mainDiskNum 大盘号
     * @param deviceInfo  设备信息
     * @param initialTime 小盘开始拉时间
     * @return
     */
    @Override
    @Transactional
    public Boolean abnormalStop(String mainDiskNum, DeviceInfo deviceInfo, Date initialTime) {

        String filterCode = getFilterCodeByMainDiskCode(mainDiskNum);
        float stryscd = deviceInfo.getRetractLength();
        float fxcd = deviceInfo.getPayOffLength();
        List<ScSx2> scSx2List = scSx2Mapper.findByFilterCode(filterCode);
        Boolean SFFQ = uploadDataCheckFQ(mainDiskNum);
        Boolean SFGL = uploadDataCheckGL(mainDiskNum);
        if (SFFQ || NumberUtils.scale(stryscd) < 2.05) {
            if (scSx2List.size() >= 1) {
                scSx2Mapper.getMaxId(filterCode);
                if (SFFQ == false) {


                }
            }
        }


        return null;

    }

    private String getFilterCodeByMainDiskCode(String mainDiskCode) {
        return scSx2Mapper.getFilterCodeByMainDiskCode(mainDiskCode);
    }

    /**
     * 定时任务轮训查询设备信息
     */
    public DeviceInfo deviceInfoSchedule() {

        DeviceInfo deviceInfo = new DeviceInfo();
        // 通过西门子S7-S1500协议模块连接设备
        try {
            SiemensS7Net siemensS7Net = deviceConnectService.getLongSiemensS7Net("10.6.185.214", 102);
            OperateResultExOne<byte[]> read = siemensS7Net.Read("DB22.DBD158", (short) 105);
            if (read.IsSuccess) {
                //实际速度
                System.out.println("实际速度");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD0").Content);
                deviceInfo.setActualVelocity(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD0").Content));
                //设定速度1
                System.out.println("设定速度1");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD48").Content);
                deviceInfo.setAssignSpeed1(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD48").Content));
                //设定速度2
                System.out.println("设定速度2");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD52").Content);
                deviceInfo.setAssignSpeed2(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD52").Content));
                //放线长度
                System.out.println("放线长度");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD4").Content);
                deviceInfo.setPayOffLength(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD4").Content));
                //收线长度
                System.out.println("收线长度");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD158").Content);
                deviceInfo.setRetractLength(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD158").Content));
                //收线长度设定
                System.out.println("收线长度设定");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD8").Content);
                deviceInfo.setAssignRetractLength(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD8").Content));
                //设定张力
                System.out.println("设定张力");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD24").Content);
                deviceInfo.setAssignTension(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD24").Content));
                //实际张力
                System.out.println("实际张力");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD36").Content);
                deviceInfo.setActualTension(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD36").Content));
                //收线剩余时间
                System.out.println("收线剩余时间");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBW124").Content);
                deviceInfo.setRetractRemainTime(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBW124").Content));
                //筛选模式
                System.out.println("筛选模式");
                System.out.println(siemensS7Net.ReadBool("DB22.DBX118.0").Content ? 1 : 0);
                deviceInfo.setFilterPattern(siemensS7Net.ReadBool("DB22.DBX118.0").Content ? 1 : 0);
                //复绕模式
                System.out.println("复绕模式");
                System.out.println(siemensS7Net.ReadBool("DB22.DBX118.0").Content ? 1 : 0);
                deviceInfo.setRewoundMode(siemensS7Net.ReadBool("DB22.DBX118.0").Content ? 1 : 0);
                //收线节距
                System.out.println("收线节距");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD88").Content);
                deviceInfo.setRetractPitch(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD88").Content));
                //放线节距
                System.out.println("放线节距");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD20").Content);
                deviceInfo.setPayOffPitch(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD20").Content));
                //正常运行
                System.out.println("正常运行"); //DB2.DBX1.1
                System.out.println(siemensS7Net.ReadBool("DB2.DBX1.3").Content ? 1 : 0);
                deviceInfo.setNormalRun(siemensS7Net.ReadBool("DB2.DBX1.3").Content ? 1 : 0);
                //异常停止
                System.out.println("异常停止"); //DB2.DBX0.2
                System.out.println(siemensS7Net.ReadBool("DB2.DBX1.5").Content ? 1 : 0);
                deviceInfo.setExceptionStop(siemensS7Net.ReadBool("DB2.DBX1.5").Content ? 1 : 0);
                //收线清零
                System.out.println("收线清零");
                System.out.println(siemensS7Net.ReadBool("DB22.DBX140.4").Content ? 1 : 0);
                deviceInfo.setRetractClearZero(siemensS7Net.ReadBool("DB22.DBX140.4").Content ? 1 : 0);
                //放线清零
                System.out.println("放线清零");
                System.out.println(siemensS7Net.ReadBool("DB22.DBX117.2").Content ? 1 : 0);
                deviceInfo.setPayOffClearZero(siemensS7Net.ReadBool("DB22.DBX117.2").Content ? 1 : 0);
                //收线夹紧
                System.out.println("收线夹紧");
                System.out.println(siemensS7Net.ReadBool("DB2.DBX2.5").Content ? 1 : 0);
                deviceInfo.setRetractClamping(siemensS7Net.ReadBool("DB2.DBX2.5").Content ? 1 : 0);
                //放线夹紧
                System.out.println("放线夹紧");
                System.out.println(siemensS7Net.ReadBool("DB2.DBX1.2").Content ? 1 : 0);
                deviceInfo.setPayOffClamping(siemensS7Net.ReadBool("DB2.DBX1.2").Content ? 1 : 0);
                //收线盘直径
                System.out.println("收线盘直径");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD44").Content);
                deviceInfo.setReelDiameter(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD44").Content));
                //放线盘直径
                System.out.println("放线盘直径");
                System.out.println(siemensS7Net.ReadFloat("DB22.DBD16").Content);
                deviceInfo.setPayOffDiameter(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD16").Content));
                //收线编码器故障
                System.out.println("收线编码器故障");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX2.1").Content ? 1 : 0);
                deviceInfo.setCableEncoderFaulty(siemensS7Net.ReadBool("DB21.DBX2.1").Content ? 1 : 0);
                //放线牵引编码器故障
                System.out.println("放线牵引编码器故障");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX1.5").Content ? 1 : 0);
                deviceInfo.setPayOffTractionEncoderFaulty(siemensS7Net.ReadBool("DB21.DBX1.5").Content ? 1 : 0);
                //收线排线编码器故障
                System.out.println("收线排线编码器故障");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX2.5").Content ? 1 : 0);
                deviceInfo.setRoutingReceivingEncoderFaulty(siemensS7Net.ReadBool("DB21.DBX2.5").Content ? 1 : 0);
                //放线伺服报警
                System.out.println("放线伺服报警");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX0.0").Content ? 1 : 0);
                deviceInfo.setPayOffServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.0").Content ? 1 : 0);
                //收线伺服报警
                System.out.println("收线伺服报警");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX0.4").Content ? 1 : 0);
                deviceInfo.setRetractingServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.4").Content ? 1 : 0);
                //放线牵引伺服报警
                System.out.println("放线牵引伺服报警");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX0.2").Content ? 1 : 0);
                deviceInfo.setPayOffTractionServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.2").Content ? 1 : 0);
                //收线牵引伺服报警
                System.out.println("收线牵引伺服报警");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX0.3").Content ? 1 : 0);
                deviceInfo.setDrawingServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.3").Content ? 1 : 0);
                //放线排线伺服报警
                System.out.println("放线排线伺服报警");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX0.1").Content ? 1 : 0);
                deviceInfo.setWireLayingServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.1").Content ? 1 : 0);
                //收线排线伺服报警
                System.out.println("收线排线伺服报警");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX0.5").Content ? 1 : 0);
                deviceInfo.setWireRewindingServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.5").Content ? 1 : 0);
                //气压故障
                System.out.println("气压故障");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX6.7").Content ? 1 : 0);
                deviceInfo.setPneumaticFailure(siemensS7Net.ReadBool("DB21.DBX6.7").Content ? 1 : 0);
                //收线牵引计米故障
                System.out.println("收线牵引计米故障");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX1.4").Content ? 1 : 0);
                deviceInfo.setLineDrawingMeterFaulty(siemensS7Net.ReadBool("DB21.DBX1.4").Content ? 1 : 0);
                //张力故障
                System.out.println("张力故障");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX6.4").Content ? 1 : 0);
                deviceInfo.setTensionFault(siemensS7Net.ReadBool("DB21.DBX6.4").Content ? 1 : 0);
                //收线排线右限位
                System.out.println("收线排线右限位");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX6.3").Content ? 1 : 0);
                deviceInfo.setLimitRightWindingLine(siemensS7Net.ReadBool("DB21.DBX6.3").Content ? 1 : 0);
                //收线排线左限位
                System.out.println("收线排线左限位");
                System.out.println(siemensS7Net.ReadBool("DB21.DBX6.2").Content ? 1 : 0);
                deviceInfo.setLimitLeftWindingLine(siemensS7Net.ReadBool("DB21.DBX6.2").Content ? 1 : 0);
                //放线排线前进
                System.out.println("放线排线前进");
                System.out.println(siemensS7Net.ReadBool("DB22.DBX116.3").Content ? 1 : 0);
                deviceInfo.setAssignOutLineForward(siemensS7Net.ReadBool("DB22.DBX116.3").Content ? 1 : 0);
                //放线排线后退
                System.out.println("放线排线后退");
                System.out.println(siemensS7Net.ReadBool("DB22.DBX116.2").Content ? 1 : 0);
                deviceInfo.setAssignOutLineBack(siemensS7Net.ReadBool("DB22.DBX116.2").Content ? 1 : 0);
                //收线排线前进
                System.out.println("收线排线前进");
                System.out.println(siemensS7Net.ReadBool("DB22.DBX116.5").Content ? 1 : 0);
                deviceInfo.setLineUpForward(siemensS7Net.ReadBool("DB22.DBX116.5").Content ? 1 : 0);
                //收线排线后退
                System.out.println("收线排线后退");
                System.out.println(siemensS7Net.ReadBool("DB22.DBX116.4").Content ? 1 : 0);
                deviceInfo.setLineUpBack(siemensS7Net.ReadBool("DB22.DBX116.4").Content ? 1 : 0);
                return deviceInfo;
            }
        } catch (Exception e) {
            log.error("connect failed");
        }

        return deviceInfo;
    }

    /**
     * 上传数据前置校验FQ
     *
     * @param diskNum 大盘号
     */
    private Boolean uploadDataCheckFQ(String diskNum) {
        Double totalLen = Double.valueOf(scSxMapper.calTotalLen(diskNum));
        int recordCount = scLsQxqcMapper.checkUploadDataFQ(diskNum, totalLen);
        if (recordCount >= 1) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 上传数据前置校验GL
     *
     * @param diskNum 大盘号
     */
    private Boolean uploadDataCheckGL(String diskNum) {
        Double totalLen = Double.valueOf(scSxMapper.calTotalLen(diskNum));
        int recordCount = scLsQxqcMapper.checkUploadDataGL(diskNum, totalLen);
        if (recordCount >= 1) {
            return true;
        } else {
            return false;
        }

    }


    /**
     * 断纤更新小盘信息
     *
     * @param filterCode  筛选编号
     * @param serialNum   序号
     * @param initialTime 初始时间
     * @return
     */
    private Boolean updateDetailDQCD(String filterCode, String serialNum, Date initialTime) {
        if (StringUtils.isEmpty(filterCode)) {
            log.info("筛选编号为空");
            return false;
        }
        ScSx2 scSx2 = scSx2Mapper.findByFilterCodeAndSerialNumber(filterCode, serialNum);
        long dqcd = scSx2.getDqcd().longValue();
        String qxlb = scSx2.getQxlb();
        String glqk = scSx2.getGlqk();
        String blyy = scSx2.getBlyy();
        Date lastupdatetime = scSx2.getLastupdatetime();
        String lastupdateaccountid = scSx2.getLastupdateaccountid();
        String gapTime = DateUtils.DateDiff(new Date(), initialTime);
        try {
            scSx2Mapper.updateScSx2DQCD(dqcd, Integer.valueOf(gapTime), qxlb, glqk, blyy, lastupdatetime, lastupdateaccountid, filterCode, serialNum);
            return true;
        } catch (Exception e) {
            log.info("数据库写入失败");
            return false;
        }
    }

    /**
     * 断纤更新小盘信息
     *
     * @param filterCode  筛选编号
     * @param serialNum   序号
     * @param initialTime 初始时间
     * @return
     */
    private Boolean updateDetailQGCD(String filterCode, String serialNum, Date initialTime) {
        if (StringUtils.isEmpty(filterCode)) {
            log.info("筛选编号为空");
            return false;
        }
        ScSx2 scSx2 = scSx2Mapper.findByFilterCodeAndSerialNumber(filterCode, serialNum);
        long qgcd = scSx2.getQgcd().longValue();
        String qxlb = scSx2.getQxlb();
        String glqk = scSx2.getGlqk();
        String blyy = scSx2.getBlyy();
        Date lastupdatetime = scSx2.getLastupdatetime();
        String lastupdateaccountid = scSx2.getLastupdateaccountid();
        String gapTime = DateUtils.DateDiff(new Date(), initialTime);
        try {
            scSx2Mapper.updateScSx2QGCD(qgcd, Integer.valueOf(gapTime), qxlb, glqk, blyy, lastupdatetime, lastupdateaccountid, filterCode, serialNum);
            return true;
        } catch (Exception e) {
            log.info("数据库写入失败");
            return false;
        }
    }

    /**
     * 筛选数据上传
     *
     * @param filterUploadDto 筛选数据上传对象
     */
    private void addXSMAIN(FilterUploadDto filterUploadDto) {
        ScSx scSx = new ScSx();
        BeanUtils.copyProperties(filterUploadDto, scSx);
        scSxMapper.insert(scSx);
    }



    public static void main(String[] args) {
        String xptm = "38H11LD650XXA04";
        System.out.println(xptm.substring(0, 13));
    }
}














