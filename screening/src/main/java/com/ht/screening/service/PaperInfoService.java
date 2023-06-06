package com.ht.screening.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ht.screening.entity.PaperInfo;

/**
 * @author chengsukai
 */
public interface PaperInfoService extends IService<PaperInfo> {

    String getPaperNo();
}
