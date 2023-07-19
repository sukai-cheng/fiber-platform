package com.ht.screening.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ht.base.domain.AjaxResult;
import com.ht.screening.entity.ScSx;
import com.ht.screening.request.FilterInfoRequest;
import com.ht.screening.response.CalculateQGCDResponse;
import com.ht.screening.vo.FiberFilterSmallDiskVo;

import java.io.IOException;
import java.util.List;

/**
 * 筛选接口类
 *
 * @author chengsukai
 */
public interface ScSxService extends IService<ScSx> {

    AjaxResult getMainPlateInfo(FilterInfoRequest request);

    List<FiberFilterSmallDiskVo> getAccessoryPlateInfo(String filterCode);

    /**
     * 已筛总长度
     *
     * @param mainDiskCode 光纤盘号
     * @return
     */
    String calTotalLen(String mainDiskCode);

    /**
     * 计算筛选长度
     *
     * @return
     */
    CalculateQGCDResponse calFilterLen(String mainDiskCode);

    /**
     * 该大盘是否已经获取筛选记录如果已经有筛选记录就需要上传
     */
    String getSxbh(String accountId, String bz, String ph) throws IOException, NoSuchFieldException, IllegalAccessException;
}
