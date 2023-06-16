package com.ht.screening.controller.device;

import com.ht.base.domain.AjaxResult;
import com.ht.screening.request.AbnormalShutdownRequest;
import com.ht.screening.request.NormalShutdownRequest;
import com.ht.screening.response.AbnormalShutDownResponse;
import com.ht.screening.response.NormalShutDownResponse;
import com.ht.screening.service.impl.ShutDownServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 停机处理
 *
 * @author chengsukai
 */
@RestController
public class ShutdownController {

    @Resource
    private ShutDownServiceImpl shutDownService;

    @PostMapping("/shutdown/normal")
    public AjaxResult normalShutdown(@RequestBody NormalShutdownRequest normalShutdownRequest) {
        NormalShutDownResponse res = shutDownService.normalShutdown(normalShutdownRequest);
        return AjaxResult.success(res);
    }

    @PostMapping("/shutdown/abnormal")
    public AjaxResult abnormalShutDown(@RequestBody AbnormalShutdownRequest abnormalShutdownRequest) {

        AbnormalShutDownResponse res = shutDownService.abnormalShutdown(abnormalShutdownRequest);
        return AjaxResult.success(res);
    }
}
