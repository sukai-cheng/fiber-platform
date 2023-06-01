package com.ht.screening.controller.device;

import com.ht.base.domain.AjaxResult;
import com.ht.screening.dto.DeviceInfo;
import com.ht.screening.service.impl.DeviceInfoServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 设备信息
 *
 * @author chengsukai
 */
@RestController
public class DeviceController {

    @Resource
    private DeviceInfoServiceImpl deviceInfoService;

    @GetMapping("/getDeviceStatus")
    public AjaxResult getDeviceStatus() {
        DeviceInfo deviceInfo = deviceInfoService.getDeviceInfo();
        return AjaxResult.success(deviceInfo);
    }
}