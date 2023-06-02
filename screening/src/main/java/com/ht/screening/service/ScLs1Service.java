package com.ht.screening.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ht.base.domain.AjaxResult;
import com.ht.screening.entity.ScLs1;

/**
 * 连接设备
 * @author chengsukai
 */
public interface ScLs1Service extends IService<ScLs1> {

    AjaxResult getDrawBenchInfo(String fiberDiskNum);

}
