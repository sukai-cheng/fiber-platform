package com.ht.screening.controller.upload;

import com.ht.base.domain.AjaxResult;
import com.ht.screening.service.impl.DeviceInfoServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FilterUploadController {

    @Resource
    private DeviceInfoServiceImpl deviceInfoService;

    public AjaxResult filterUpload(){
        return AjaxResult.success();
    }
}
