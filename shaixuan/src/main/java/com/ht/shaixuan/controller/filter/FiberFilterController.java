package com.ht.shaixuan.controller.filter;

import com.ht.base.domain.AjaxResult;
import com.ht.shaixuan.entity.ScLsYcdj;
import com.ht.shaixuan.request.ElevationDifferenceRequest;
import com.ht.shaixuan.request.FilterInfoRequest;
import com.ht.shaixuan.service.impl.ElevationDifferenceServiceImpl;
import com.ht.shaixuan.service.impl.ScSxServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.ObjectInputFilter;

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
        return filterService.getMainPlateInfo(filterInfoRequest.getMainDiskCode());
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
        String totalLen = filterService.calTotalLen(filterInfoRequest.getMainDiskCode());
        return AjaxResult.success(totalLen);
    }


}
