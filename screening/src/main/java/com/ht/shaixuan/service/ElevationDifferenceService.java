package com.ht.shaixuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ht.shaixuan.entity.ScLsYcdj;

import java.util.List;

/**
 * @author chengsukai
 */
public interface ElevationDifferenceService extends IService<ScLsYcdj> {

    List<ScLsYcdj> getElevationDifference(String sx);
}
