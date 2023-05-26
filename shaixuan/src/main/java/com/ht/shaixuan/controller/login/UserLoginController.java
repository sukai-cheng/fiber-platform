package com.ht.shaixuan.controller.login;

import com.ht.base.domain.AjaxResult;
import com.ht.base.domain.Result;
import com.ht.shaixuan.entity.TAccount;
import com.ht.shaixuan.service.impl.TAccountServiceImpl;
import com.ht.shaixuan.vo.LoginVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chengsukai
 */
@RestController
public class UserLoginController {

    @Resource
    private TAccountServiceImpl accountService;

    /**
     * url: http://localhost:8088/user/login
     * @param loginInfo
     * @return
     */
    @PostMapping("/user/login")
    public AjaxResult userLogin(@RequestBody LoginVo loginInfo) {
        return accountService.userLogin(loginInfo);
    }
}












