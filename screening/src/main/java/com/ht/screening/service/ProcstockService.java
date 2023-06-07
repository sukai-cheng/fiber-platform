package com.ht.screening.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ht.screening.entity.Procstock;

/**
 * @author chengsukai
 */
public interface ProcstockService extends IService<Procstock> {

    /**
     * 是否已经审核
     * @param fiberDiskCode
     * @return
     */
    Boolean checkFinished(String fiberDiskCode);


    /**
     * 是否已经存在
     * @param fiberDiskCode
     * @return
     */
    Boolean checkExists(String fiberDiskCode);
}
