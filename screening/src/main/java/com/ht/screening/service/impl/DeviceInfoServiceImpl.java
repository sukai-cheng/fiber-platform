package com.ht.screening.service.impl;

import HslCommunication.Core.Types.OperateResultExOne;
import HslCommunication.Profinet.Siemens.SiemensS7Net;
import com.ht.base.exception.ServiceException;
import com.ht.base.utils.NumberUtils;
import com.ht.base.utils.StringUtils;
import com.ht.screening.dto.DeviceInfo;
import com.ht.screening.dto.DrawBenchDto;
import com.ht.screening.mapper.ScLs1Mapper;
import com.ht.screening.service.DeviceInfoService;
import com.ht.screening.service.cacheService.DeviceCacheService;
import com.ht.screening.vo.DeviceInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.ht.base.utils.Ini4jUtils.getPropertiesFromIni;

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
    DeviceCacheService deviceCacheService;

    @Resource
    ScLs1Mapper scLs1Mapper;

    private SiemensS7Net siemensS7Net;

    private String ip;

    private Integer port;

    public void detailForDevice() {
        com.ht.screening.entity.DeviceInfo deviceIpAndPort = getDeviceIpAndPort();
        this.ip = deviceIpAndPort.getDeviceIp();
        this.port = Integer.valueOf(deviceIpAndPort.getDevicePort());
    }

    public String getComputerIP() {
        com.ht.screening.entity.DeviceInfo deviceInfo = getDeviceIpAndPort();
        return deviceInfo.getComputerIp();
    }

    public SiemensS7Net getSiemensS7Net() {
        detailForDevice();
        SiemensS7Net siemensS7Net = deviceConnectService.getLongSiemensS7Net(ip, port);
        return siemensS7Net;
    }

    @Override
    public DeviceInfoVo getDeviceInfo(String fiberDiskNum) {
        DeviceInfo deviceInfo = new DeviceInfo();
        if (siemensS7Net == null) {
            siemensS7Net = getSiemensS7Net();
        }
        if (siemensS7Net != null) {
            // 通过西门子S7-S1500协议模块连接设备
            try {
                OperateResultExOne<byte[]> read = siemensS7Net.Read("DB22.DBD158", (short) 105);
                if (read.IsSuccess) {
                    //实际速度
                    deviceInfo.setActualVelocity(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD0").Content));
                    //设定速度1
                    deviceInfo.setAssignSpeed1(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD48").Content));
                    //设定速度2
                    deviceInfo.setAssignSpeed2(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD52").Content));
                    //放线长度
                    deviceInfo.setPayOffLength(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD4").Content));
                    //收线长度
                    deviceInfo.setRetractLength(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD158").Content));
                    //收线长度设定
                    deviceInfo.setAssignRetractLength(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD8").Content));
                    //设定张力
                    deviceInfo.setAssignTension(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD24").Content));
                    //实际张力
                    deviceInfo.setActualTension(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD36").Content));
                    //收线剩余时间
                    deviceInfo.setRetractRemainTime(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBW124").Content));
                    //筛选模式
                    deviceInfo.setFilterPattern(siemensS7Net.ReadBool("DB22.DBX118.0").Content ? 1 : 0);
                    //复绕模式
                    deviceInfo.setRewoundMode(siemensS7Net.ReadBool("DB22.DBX118.0").Content ? 1 : 0);
                    //收线节距
                    deviceInfo.setRetractPitch(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD88").Content));
                    //放线节距
                    deviceInfo.setPayOffPitch(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD20").Content));
                    //正常运行
                    deviceInfo.setNormalRun(siemensS7Net.ReadBool("DB2.DBX1.3").Content ? 1 : 0);
                    //异常停止
                    deviceInfo.setExceptionStop(siemensS7Net.ReadBool("DB2.DBX1.5").Content ? 1 : 0);
                    //收线清零
                    deviceInfo.setRetractClearZero(siemensS7Net.ReadBool("DB22.DBX140.4").Content ? 1 : 0);
                    //放线清零
                    deviceInfo.setPayOffClearZero(siemensS7Net.ReadBool("DB22.DBX117.2").Content ? 1 : 0);
                    //收线夹紧
                    deviceInfo.setRetractClamping(siemensS7Net.ReadBool("DB2.DBX2.5").Content ? 1 : 0);
                    //放线夹紧
                    deviceInfo.setPayOffClamping(siemensS7Net.ReadBool("DB2.DBX1.2").Content ? 1 : 0);
                    //收线盘直径
                    deviceInfo.setReelDiameter(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD44").Content));
                    //放线盘直径
                    deviceInfo.setPayOffDiameter(NumberUtils.scale(siemensS7Net.ReadFloat("DB22.DBD16").Content));
                    //收线编码器故障
                    deviceInfo.setCableEncoderFaulty(siemensS7Net.ReadBool("DB21.DBX2.1").Content ? 1 : 0);
                    //放线牵引编码器故障
                    deviceInfo.setPayOffTractionEncoderFaulty(siemensS7Net.ReadBool("DB21.DBX1.5").Content ? 1 : 0);
                    //收线排线编码器故障
                    deviceInfo.setRoutingReceivingEncoderFaulty(siemensS7Net.ReadBool("DB21.DBX2.5").Content ? 1 : 0);
                    //放线伺服报警
                    deviceInfo.setPayOffServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.0").Content ? 1 : 0);
                    //收线伺服报警
                    deviceInfo.setRetractingServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.4").Content ? 1 : 0);
                    //放线牵引伺服报警
                    deviceInfo.setPayOffTractionServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.2").Content ? 1 : 0);
                    //收线牵引伺服报警
                    deviceInfo.setDrawingServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.3").Content ? 1 : 0);
                    //放线排线伺服报警
                    deviceInfo.setWireLayingServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.1").Content ? 1 : 0);
                    //收线排线伺服报警
                    deviceInfo.setWireRewindingServoAlarm(siemensS7Net.ReadBool("DB21.DBX0.5").Content ? 1 : 0);
                    //气压故障
                    deviceInfo.setPneumaticFailure(siemensS7Net.ReadBool("DB21.DBX6.7").Content ? 1 : 0);
                    //收线牵引计米故障
                    deviceInfo.setLineDrawingMeterFaulty(siemensS7Net.ReadBool("DB21.DBX1.4").Content ? 1 : 0);
                    //张力故障
                    deviceInfo.setTensionFault(siemensS7Net.ReadBool("DB21.DBX6.4").Content ? 1 : 0);
                    //收线排线右限位
                    deviceInfo.setLimitRightWindingLine(siemensS7Net.ReadBool("DB21.DBX6.3").Content ? 1 : 0);
                    //收线排线左限位
                    deviceInfo.setLimitLeftWindingLine(siemensS7Net.ReadBool("DB21.DBX6.2").Content ? 1 : 0);
                    //放线排线前进
                    deviceInfo.setAssignOutLineForward(siemensS7Net.ReadBool("DB22.DBX116.3").Content ? 1 : 0);
                    //放线排线后退
                    deviceInfo.setAssignOutLineBack(siemensS7Net.ReadBool("DB22.DBX116.2").Content ? 1 : 0);
                    //收线排线前进
                    deviceInfo.setLineUpForward(siemensS7Net.ReadBool("DB22.DBX116.5").Content ? 1 : 0);
                    //收线排线后退
                    deviceInfo.setLineUpBack(siemensS7Net.ReadBool("DB22.DBX116.4").Content ? 1 : 0);
                }
            } catch (Exception e) {
                log.error("connect failed");
                throw new ServiceException("E1001");
            }
        }

        DeviceInfoVo deviceInfoVo = new DeviceInfoVo();
        deviceInfoVo.setActualVelocity((double) deviceInfo.getActualVelocity());
        deviceInfoVo.setPayOffLength((double) deviceInfo.getPayOffLength());
        deviceInfoVo.setRetractLength((double) deviceInfo.getRetractLength());
        deviceInfoVo.setAssignRetractLength((double) deviceInfo.getAssignRetractLength());
        deviceInfoVo.setActualTension((double) deviceInfo.getActualTension());
        deviceInfoVo.setNormalRun(deviceInfo.getNormalRun());
        deviceInfoVo.setExceptionStop(deviceInfo.getExceptionStop());
        deviceInfoVo.setResidualLen((double) deviceInfo.getAssignRetractLength() - deviceInfo.getRetractLength());

        return deviceInfoVo;
    }

    /**
     * 数据写入
     */
    public void write(float value) {
        if (siemensS7Net == null) {
            detailForDevice();
            siemensS7Net = getSiemensS7Net();
        }
        if (siemensS7Net != null) {
            siemensS7Net.Write("DB22.DBD8", value);
            System.out.print("写入成功");
        }
    }

    public com.ht.screening.entity.DeviceInfo getDeviceIpAndPort() {
        String sbbh = getPropertiesFromIni().getText837();
        List<com.ht.screening.entity.DeviceInfo> deviceInfos = deviceCacheService.deviceInfoList();
        for (com.ht.screening.entity.DeviceInfo deviceInfo :
                deviceInfos) {
            if (StringUtils.equals(deviceInfo.getDeviceName(), sbbh)) {
                return deviceInfo;
            }
        }
        return null;
    }


}














