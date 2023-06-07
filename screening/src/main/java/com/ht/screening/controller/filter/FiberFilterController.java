package com.ht.screening.controller.filter;

import com.ht.base.domain.AjaxResult;
import com.ht.screening.entity.ScLsYcdj;
import com.ht.screening.request.ElevationDifferenceRequest;
import com.ht.screening.request.FilterInfoRequest;
import com.ht.screening.service.impl.ElevationDifferenceServiceImpl;
import com.ht.screening.service.impl.ScSxServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chengsukai
 */
@RestController
public class FiberFilterController {

    @Resource
    private ScSxServiceImpl filterService;

    @Resource
    private ElevationDifferenceServiceImpl elevationDifferenceService;

    /**
     * 获取筛选信息
     */
    @PostMapping(value = "/getFilterInfo")
    public AjaxResult getFilterInfo(@RequestBody FilterInfoRequest filterInfoRequest) {
        return filterService.getMainPlateInfo(filterInfoRequest);
    }

    /**
     * 获取强度差反馈信息
     */
    @Deprecated
    @PostMapping(value = "/getElevationDifference")
    public AjaxResult getElevationDifference(@RequestBody ElevationDifferenceRequest elevationDifferenceRequest) {
        List<ScLsYcdj> elevationDifferenceInfo = elevationDifferenceService.getElevationDifference(elevationDifferenceRequest.getSx());
        return AjaxResult.success(elevationDifferenceInfo);
    }

    /**
     * 已筛总长度
     */
    @PostMapping(value = "/getTotalLen")
    public AjaxResult getTotalLen(@RequestBody FilterInfoRequest filterInfoRequest) {
        String totalLen = filterService.calTotalLen(filterInfoRequest.getFiberDiskCode());
        return AjaxResult.success(totalLen);
    }


}
