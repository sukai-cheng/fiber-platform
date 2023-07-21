package com.ht.screening.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.base.constant.HttpStatus;
import com.ht.base.domain.AjaxResult;
import com.ht.base.utils.StringUtils;
import com.ht.screening.dto.EmployeeDto;
import com.ht.screening.entity.TAccount;
import com.ht.screening.mapper.TAccountMapper;
import com.ht.screening.service.TAccountService;
import com.ht.screening.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author chengsukai
 */
@Service
@Slf4j
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements TAccountService {

    @Resource
    private DeviceInfoServiceImpl deviceInfoService;
    @Override
    public AjaxResult userLogin(LoginVo loginInfo) {
        String cardNum = loginInfo.getCardNum();
        String userName = loginInfo.getUserName();
        String password = loginInfo.getPassword();
        Integer res = 0;
        if (StringUtils.isNotEmpty(userName)) {
            res = loginByAccount(userName, password);

        } else if (StringUtils.isNotEmpty(cardNum)) {
            res = loginByICCard(cardNum, password);
        }
        if (res != 0 && res != null) {
            EmployeeDto userInfo = baseMapper.getUserInfo(userName, password);
            String computerIP = deviceInfoService.getComputerIP();
            userInfo.setComputerIP(computerIP);
            return AjaxResult.success("login success",userInfo);
        }

        return AjaxResult.error(HttpStatus.ERROR, "log in error, ICid or password error !");

    }

    private Integer loginByAccount(String account, String password) {
        return baseMapper.findByUserNameAndPassWord(account, password);
    }

    private Integer loginByICCard(String cardNum, String password) {
        return baseMapper.findByUserNameAndPassWord(cardNum, password);
    }




}
