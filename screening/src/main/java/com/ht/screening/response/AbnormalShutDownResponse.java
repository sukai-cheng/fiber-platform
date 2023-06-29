package com.ht.screening.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class AbnormalShutDownResponse implements Serializable {
    /**
     * 盘号
     */
    String ph;
    /**
     * 小盘条码
     */
    String xptm;
    /**
     * 打印信息
     */
    String dyms;
    /**
     * 状态
     */
    Boolean status;
    /**
     * 是否打印(1 - 打印   0 - 不打印)
     */
    Boolean printFlag;

    /**
     * 打印机IP地址
     */
    String computerIP;
}
