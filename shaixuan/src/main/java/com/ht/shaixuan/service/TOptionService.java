package com.ht.shaixuan.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ht.base.domain.AjaxResult;
import com.ht.shaixuan.entity.TOption;

import java.util.List;

/**
 * @author chengsukai
 */
public interface TOptionService extends IService<TOption> {

    /**
     * 根据传入的关键字获取相关信息
     * @return
     */
    AjaxResult getOptionList(String actionValue);
}
