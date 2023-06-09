package com.ht.screening.service;

import com.ht.base.utils.bean.BeanUtils;
import com.ht.screening.dto.FilterDetailUploadDto;
import com.ht.screening.dto.FilterUploadDto;
import com.ht.screening.entity.ScSx;

/** 筛选数据上传
 * @author chengsukai
 */
public interface FilterUploadService {
    /**
     * 筛选数据上传
     *
     * @param filterUploadDto 筛选数据上传对象
     */
    void addXSMAIN(FilterUploadDto filterUploadDto);

    /**
     * 获取筛选细节
     * @param filterDetailUploadDto
     * @return
     */
    Boolean SXdetail(FilterDetailUploadDto filterDetailUploadDto);
}
