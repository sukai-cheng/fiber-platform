package com.ht.screening.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ht.base.domain.AjaxResult;
import com.ht.screening.entity.TAccount;
import com.ht.screening.vo.LoginVo;

/**
 * @author chengsukai
 */
public interface TAccountService extends IService<TAccount> {

    AjaxResult userLogin(LoginVo loginInfo);
}
