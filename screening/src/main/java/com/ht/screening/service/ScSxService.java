package com.ht.screening.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ht.base.domain.AjaxResult;
import com.ht.screening.entity.ScSx;
import com.ht.screening.entity.ScSx2;
import com.ht.screening.vo.FiberFilterSmallDiskVo;

import java.util.List;

/**
 * 筛选接口类
 * @author chengsukai
 */
public interface ScSxService extends IService<ScSx> {

    AjaxResult getMainPlateInfo(String mainDiskCode);

    List<FiberFilterSmallDiskVo> getAccessoryPlateInfo(String filterCode);

    String calTotalLen(String mainDiskCode);

}
