package com.ht.screening.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.base.constant.CommonConstant;
import com.ht.base.utils.DateUtils;
import com.ht.base.utils.NumberUtils;
import com.ht.base.utils.StringUtils;
import com.ht.screening.entity.PaperInfo;
import com.ht.screening.mapper.PaperInfoMapper;
import com.ht.screening.service.PaperInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chengsukai
 */
@Service
public class PaperInfoServiceImpl
        extends ServiceImpl<PaperInfoMapper, PaperInfo> implements PaperInfoService {

    @Resource
    private PaperInfoMapper paperInfoMapper;

    @Override
    public String getPaperNo() {
        StringBuffer dateStr = new StringBuffer(DateUtils.getTime());
        String strFirstLike = CommonConstant.SX + dateStr.substring(2, 4) + dateStr.substring(5, 7) + dateStr.substring(8, 10);
        String paperNo = paperInfoMapper.getPaperNo(strFirstLike);
        if (StringUtils.isNotEmpty(paperNo)) {
            NumberUtils.addNum(paperNo);
        }
        return paperNo;
    }

    public static void main(String[] args) {
//        2023-06-06 13:31:36.650
        StringBuffer dateStr = new StringBuffer(DateUtils.getTime());
        String strFistLike = CommonConstant.SX + dateStr.substring(2, 4) + dateStr.substring(5, 7) + dateStr.substring(8, 10);
//        strFistLike = "SX2306060484";
        System.out.println(NumberUtils.addNum(strFistLike));
    }
}
