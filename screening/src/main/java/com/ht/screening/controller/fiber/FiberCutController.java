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
    @Resource
    private ProcstockServiceImpl procstockService;


    @PostMapping("/fiberCut")
    public AjaxResult fiberCut(@RequestBody FiberCutRequest request) {
        Boolean ischecked = checkService.checkDpcl(request.getFiberDiskNum());
        if (ischecked == false) {
            return AjaxResult.error("大盘检测未审核, 不能够筛选");
        }
        Boolean isExisted = procstockService.checkExists(request.getFiberDiskNum());
        Boolean isFinished = procstockService.checkFinished(request.getFiberDiskNum());
        if (isExisted && !isFinished) {
            return fiberDrawingDefectService.fiberCutDetail(request.getFiberDiskNum());
        } else {
            return AjaxResult.error("您输入的盘号没有拉丝数据, 或该盘已经审核");
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

}
