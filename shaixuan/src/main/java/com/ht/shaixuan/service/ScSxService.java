package com.ht.shaixuan.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ht.base.domain.AjaxResult;
import com.ht.shaixuan.entity.ScSx;

/**
 * 筛选接口类
 * @author chengsukai
 */
public interface ScSxService extends IService<ScSx> {

    AjaxResult findByMainDiskCode(String mainDiskCode);

}
