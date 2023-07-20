package com.ht.screening.controller.device;

import com.ht.base.domain.AjaxResult;
import com.ht.screening.request.DeviceStatusRequest;
import com.ht.screening.service.impl.DeviceInfoServiceImpl;
import com.ht.screening.vo.DeviceInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 设备信息
 *
 * @author chengsukai
 */
@Slf4j
@RestController
public class DeviceController {

    @Resource
    private DeviceInfoServiceImpl deviceInfoService;

    @PostMapping("/getDeviceStatus")
    public AjaxResult getDeviceStatus(@RequestBody DeviceStatusRequest request) {
        try {
            DeviceInfoVo deviceInfoVo = deviceInfoService.getDeviceInfo(request.getFiberDiskNum());
            return AjaxResult.success(deviceInfoVo);
        } catch (Exception e) {
            return AjaxResult.error("设备连接异常");
        }
    }

    @GetMapping("/test")
    public AjaxResult test() {
        deviceInfoService.write(26.20f);
        return AjaxResult.success();
    }

}
