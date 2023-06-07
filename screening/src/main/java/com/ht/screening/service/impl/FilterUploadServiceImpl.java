package com.ht.screening.service.impl;

import com.ht.base.utils.bean.BeanUtils;
import com.ht.screening.dto.FilterUploadDto;
import com.ht.screening.entity.ScSx;
import com.ht.screening.mapper.ScSxMapper;
import com.ht.screening.service.FilterUploadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FilterUploadServiceImpl implements FilterUploadService {

    @Resource
    ScSxMapper scSxMapper;

    /**
     * 筛选数据上传
     *
     * @param filterUploadDto 筛选数据上传对象
     */
    @Override
    public void addXSMAIN(FilterUploadDto filterUploadDto) {
        ScSx scSx = new ScSx();
        BeanUtils.copyProperties(filterUploadDto, scSx);
        scSxMapper.insert(scSx);
    }
}
