package com.ht.screening.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.base.domain.AjaxResult;
import com.ht.screening.dto.OptionDto;
import com.ht.screening.entity.TOption;
import com.ht.screening.mapper.TOptionMapper;
import com.ht.screening.service.TOptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author chengsukai
 */
@Service
@Slf4j
public class TOptionServiceImpl extends ServiceImpl<TOptionMapper, TOption> implements TOptionService {


    @Resource
    private TOptionMapper optionMapper;

    @Override
    public AjaxResult getOptionList(String actionValue) {
        List<String> actionList = optionMapper.findByAction(actionValue);
        return AjaxResult.success(actionList);
    }

    @Override
    public AjaxResult getOptionList() {
        OptionDto optionDto = new OptionDto();
        List<String> xjList = optionMapper.findByAction("xj");
        List<String> colorList = optionMapper.findByAction("color");
        List<String> pjList = optionMapper.findByAction("pj");
        optionDto.setNewOldList(xjList);
        optionDto.setColorList(colorList);
        optionDto.setPlateList(pjList);

        return AjaxResult.success(optionDto);

    }


}
