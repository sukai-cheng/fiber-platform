package com.ht.screening.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class NormalShutDownResponse implements Serializable {
    /**
     * 小盘条码
     */
    String xptm;
    Boolean status;
    Boolean printFlag;
}
