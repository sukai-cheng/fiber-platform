package com.ht.shaixuan.controller.fiber;

import com.ht.base.domain.AjaxResult;
import com.ht.shaixuan.request.FiberCutRequest;
import com.ht.shaixuan.service.impl.FiberDrawingDefectServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 断纤
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
