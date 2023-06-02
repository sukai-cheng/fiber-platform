package com.ht.screening.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ht.base.domain.AjaxResult;
import com.ht.screening.dto.CalFilterLenDto;
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

    /**
     * 已筛总长度
     * @param mainDiskCode 光纤盘号
     * @return
     */
    String calTotalLen(String mainDiskCode);

    /**
     * 计算筛选长度
     * @return
     */
    String calFilterLen(CalFilterLenDto calFilterLenDto);

}
