package com.ht.screening.service;

import com.ht.base.utils.bean.BeanUtils;
import com.ht.screening.dto.FilterUploadDto;
import com.ht.screening.entity.ScSx;

public interface FilterUploadService {
    /**
     * 筛选数据上传
     *
     * @param filterUploadDto 筛选数据上传对象
     */
    public void addXSMAIN(FilterUploadDto filterUploadDto);
}
