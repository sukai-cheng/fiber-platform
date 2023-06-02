package com.ht.screening.service;

import com.ht.screening.vo.DeviceInfoVo;

/**
 * 获取设备信息
 * @author chengsukai
 */
public interface DeviceInfoService {

    DeviceInfoVo getDeviceInfo(String fiberDiskNum);

}
