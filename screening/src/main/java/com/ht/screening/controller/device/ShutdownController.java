package com.ht.screening.controller.device;

import com.ht.base.domain.AjaxResult;
import com.ht.screening.dto.AbnormalShutdownDto;
import com.ht.screening.dto.NormalShutdownDto;
import com.ht.screening.response.AbnormalShutDownResponse;
import com.ht.screening.response.NormalShutDownResponse;
import com.ht.screening.service.impl.ShutDownServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 停机处理
 * @author chengsukai
 */
@RestController
public class ShutdownController {

    @Resource
    private ShutDownServiceImpl shutDownService;

    @PostMapping("/shutdown/normal")
    public AjaxResult normalShutdown(NormalShutdownDto normalShutdownDto) {
        NormalShutDownResponse res = shutDownService.normalShutdown(normalShutdownDto);
        return AjaxResult.success(res);
    }

    @PostMapping("/shutdown/abnormal")
    public AjaxResult abnormalShutDown(AbnormalShutdownDto abnormalShutdownDto) {

        AbnormalShutDownResponse res = shutDownService.abnormalShutdown(abnormalShutdownDto);
        return AjaxResult.success(res);
    }
}
