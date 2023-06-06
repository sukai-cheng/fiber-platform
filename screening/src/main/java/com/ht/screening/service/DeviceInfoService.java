package com.ht.screening.service;

import com.ht.screening.dto.DeviceInfo;
import com.ht.screening.vo.DeviceInfoVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 获取设备信息
 * @author chengsukai
 */
public interface DeviceInfoService {

    DeviceInfoVo getDeviceInfo(String fiberDiskNum);

    /**
     * 异常停机
     * 断纤上传
     * @param mainDiskNum
     * @return
     */
    @Transactional
    Boolean abnormalStop(String mainDiskNum, DeviceInfo deviceInfo, Date initialTime);
}
