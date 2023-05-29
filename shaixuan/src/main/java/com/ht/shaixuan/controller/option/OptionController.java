package com.ht.shaixuan.controller.option;

import com.ht.base.domain.AjaxResult;
import com.ht.shaixuan.request.OptionInfoRequest;
import com.ht.shaixuan.service.impl.TOptionServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 获取相关信息
 *
 * @author chengsukai
 */
@RestController
public class OptionController {

    @Resource
    private TOptionServiceImpl optionService;

    @PostMapping("/option/data")
    public AjaxResult getOptionInfo(@RequestBody OptionInfoRequest optionInfoRequest) {
        return optionService.getOptionList(optionInfoRequest.getOptionValue());
    }
}
