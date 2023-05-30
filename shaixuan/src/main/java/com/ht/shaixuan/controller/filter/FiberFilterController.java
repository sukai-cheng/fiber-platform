package com.ht.shaixuan.controller.filter;

import com.ht.base.domain.AjaxResult;
import com.ht.shaixuan.request.FilterInfoRequest;
import com.ht.shaixuan.service.impl.ScSxServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chengsukai
 */
@RestController
public class FiberFilterController {

    @Resource
    private ScSxServiceImpl filterService;

    /**
     * 获取筛选信息
     *
     * @param filterInfoRequest
     */
    @PostMapping(value = "/getFilterInfo")
    public AjaxResult getFilterInfo(@RequestBody FilterInfoRequest filterInfoRequest) {
        return filterService.getMainPlateInfo(filterInfoRequest.getMainDiskCode());
    }
}
