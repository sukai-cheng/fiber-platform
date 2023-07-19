package com.ht.screening.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ht.base.domain.AjaxResult;
import com.ht.screening.entity.TOption;

import java.util.List;

/**
 * @author chengsukai
 */
public interface TOptionService extends IService<TOption> {

    /**
     * 根据传入的关键字获取相关信息
     */
    AjaxResult getOptionList(String actionValue);

    AjaxResult getOptionList();
}
