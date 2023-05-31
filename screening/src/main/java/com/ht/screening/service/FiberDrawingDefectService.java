package com.ht.screening.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ht.base.domain.AjaxResult;
import com.ht.screening.entity.ScLsQxqc;

/**
 * @author chengsukai
 */
public interface FiberDrawingDefectService extends IService<ScLsQxqc> {

    /**
     * 根据光纤盘号获取断纤的相关信息
     * @param fiberDiskNum 光纤盘号
     * @return
     */
    AjaxResult fiberCutDetail(String fiberDiskNum);
}
