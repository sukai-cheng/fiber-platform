package com.ht.shaixuan.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ht.base.domain.AjaxResult;
import com.ht.shaixuan.entity.ScSx;
import com.ht.shaixuan.entity.ScSx2;

import java.util.List;

/**
 * 筛选接口类
 * @author chengsukai
 */
public interface ScSxService extends IService<ScSx> {

    AjaxResult getMainPlateInfo(String mainDiskCode);

    List<ScSx2> getAccessoryPlateInfo(String filterCode);

    String calTotalLen(String mainDiskCode);

}
