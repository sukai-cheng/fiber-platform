package com.ht.shaixuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ht.base.domain.AjaxResult;
import com.ht.shaixuan.entity.TAccount;
import com.ht.shaixuan.vo.LoginVo;

/**
 * @author chengsukai
 */
public interface TAccountService extends IService<TAccount> {

    AjaxResult userLogin(LoginVo loginInfo);
}
