package com.ht.shaixuan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.base.constant.HttpStatus;
import com.ht.base.domain.AjaxResult;
import com.ht.base.utils.StringUtils;
import com.ht.shaixuan.entity.TAccount;
import com.ht.shaixuan.entity.TOption;
import com.ht.shaixuan.mapper.TAccountMapper;
import com.ht.shaixuan.mapper.TOptionMapper;
import com.ht.shaixuan.service.TAccountService;
import com.ht.shaixuan.service.TOptionService;
import com.ht.shaixuan.vo.LoginVo;
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
}
