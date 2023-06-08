package com.ht.screening.controller.login;

import com.ht.base.domain.AjaxResult;
import com.ht.base.utils.Ini4jFileVo;
import com.ht.screening.service.impl.TAccountServiceImpl;
import com.ht.screening.vo.LoginVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.io.IOException;

import static com.ht.base.utils.Ini4jUtils.getPropertiesFromIni;

/**
 * @author chengsukai
 */
@RestController
public class UserLoginController {

    @Resource
    private TAccountServiceImpl accountService;

    /**
     * url: http://localhost:8088/user/login
     *
     * @param loginInfo
     * @return
     */
    @PostMapping("/user/login")
    public AjaxResult userLogin(@RequestBody LoginVo loginInfo) {
        return accountService.userLogin(loginInfo);
    }
//2015090124
    @GetMapping("/getProperties")
    public AjaxResult getProperties() throws IOException, NoSuchFieldException, IllegalAccessException {
        Ini4jFileVo res = getPropertiesFromIni();
        return AjaxResult.success(res);
    }
}












