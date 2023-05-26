package com.ht.shaixuan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.base.constant.HttpStatus;
import com.ht.base.domain.AjaxResult;
import com.ht.base.exception.ServiceException;
import com.ht.base.utils.StringUtils;
import com.ht.shaixuan.entity.TAccount;
import com.ht.shaixuan.mapper.TAccountMapper;
import com.ht.shaixuan.service.TAccountService;
import com.ht.shaixuan.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author chengsukai
 */
@Service
@Slf4j
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements TAccountService {

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
        if (res != null) {
            return AjaxResult.success("login success");
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
