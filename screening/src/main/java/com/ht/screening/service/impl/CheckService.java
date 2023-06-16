package com.ht.screening.service.impl;

import com.ht.base.utils.StringUtils;
import com.ht.screening.dto.DpCheckResult2Dto;
import com.ht.screening.dto.DpCheckResultDto;
import com.ht.screening.dto.PreferredDiskDto;
import com.ht.screening.entity.ZlLsh;
import com.ht.screening.mapper.SxLsMapper;
import com.ht.screening.mapper.ZlLshMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chengsukai
 */
@Service
public class CheckService {

    @Resource
    private ZlLshMapper zlLshMapper;

    @Resource
    private SxLsMapper sxLsMapper;


    /**
     * 判断是否有优先盘
     *
     * @param ph 盘号
     * @param sx 筛选编号
     * @return
     */
    public Boolean checkyx(String ph, String sx) {
        List<PreferredDiskDto> preferredDiskDtos = sxLsMapper.checkPreferredDisk(ph, sx);
        for (PreferredDiskDto preferredDiskDto : preferredDiskDtos) {
            if (StringUtils.equals(preferredDiskDto.getIsyx(), "1") && !StringUtils.equalsIgnoreCase(preferredDiskDto.getProductId(), ph)) {
                return false;
            }
        }
        return true;

    }

    public Boolean checkDpcl(String gqph) {
        Boolean res = false;
        Integer ps = 0;
        List<DpCheckResultDto> dpCheckResultDtoList = zlLshMapper.checkFromLs(gqph);
        if (dpCheckResultDtoList != null && dpCheckResultDtoList.size() != 0) {
            for (DpCheckResultDto dpCheckResultDto : dpCheckResultDtoList) {
                if (StringUtils.equals(dpCheckResultDto.getFqdm(), "外端")) {
                    ps++;
                }
            }
            if (ps > 0) {
                List<DpCheckResult2Dto> dpCheckResult2DtoList = zlLshMapper.checkFromLsh2(gqph);
                if (dpCheckResult2DtoList.size() < ps) {
                    res = true;
                }
            }
        }else{
            res = true;
        }
        List<ZlLsh> recordCount = zlLshMapper.selectFromLsh(gqph);
        if (recordCount == null || recordCount.size() == 0) {
            res =  false;
        }
        return res;
    }
}
