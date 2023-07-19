package com.ht.screening.controller.fiber;

import com.ht.base.domain.AjaxResult;
import com.ht.screening.request.DrawInfoRequest;
import com.ht.screening.request.FiberCutRequest;
import com.ht.screening.service.impl.CheckService;
import com.ht.screening.service.impl.FiberDrawingDefectServiceImpl;
import com.ht.screening.service.impl.ProcstockServiceImpl;
import com.ht.screening.service.impl.ScLs1ServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 获取拉丝筛选缺陷信息
 *
 * @author chengsukai
 */
@RestController
public class FiberCutController {

    @Resource
    private FiberDrawingDefectServiceImpl fiberDrawingDefectService;
    @Resource
    private ScLs1ServiceImpl scLs1Service;
    @Resource
    CheckService checkService;

    @PostMapping("/fiberCut")
    public AjaxResult fiberCut(@RequestBody FiberCutRequest request) {
        Boolean ischecked = checkService.checkDpcl(request.getFiberDiskNum());
        if (ischecked == false) {
            return AjaxResult.error("大盘检测未审核, 不能够筛选");
        } else {
            return fiberDrawingDefectService.fiberCutDetail(request.getFiberDiskNum());
        }

    }

    @PostMapping("/drawInfo")
    public AjaxResult drawInfo(@RequestBody DrawInfoRequest request) {
        Boolean ischecked = checkService.checkDpcl(request.getFiberDiskNum());
        if (!ischecked) {
            return AjaxResult.error("大盘检测未审核, 不能够筛选");
        }
        return scLs1Service.getDrawBenchInfo(request.getFiberDiskNum());
    }

    @PostMapping("/scsx2/refresh")
    public AjaxResult refreshScsx2(@RequestBody DrawInfoRequest request){
        return AjaxResult.success();
    }

}
