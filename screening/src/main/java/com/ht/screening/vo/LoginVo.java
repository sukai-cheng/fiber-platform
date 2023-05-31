package com.ht.screening.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class LoginVo implements Serializable {

    /**
     * 用户名
     */
    String userName;

    /**
     * 密码
     */
    String password;

    /**
     * 卡号
     */
    String cardNum;

}
