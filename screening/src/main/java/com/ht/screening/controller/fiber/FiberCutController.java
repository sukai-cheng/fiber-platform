package com.ht.screening.controller.fiber;

import com.ht.base.domain.AjaxResult;
import com.ht.screening.request.FiberCutRequest;
import com.ht.screening.service.impl.FiberDrawingDefectServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 获取拉丝筛选缺陷信息
 * @author chengsukai
 */
@RestController
public class FiberCutController {

    @Resource
    private FiberDrawingDefectServiceImpl fiberDrawingDefectService;

    @PostMapping("/fiberCut")
    public AjaxResult fiberCut(@RequestBody FiberCutRequest request) {
        return fiberDrawingDefectService.fiberCutDetail(request.getFiberDiskNum());
    }
    
}
