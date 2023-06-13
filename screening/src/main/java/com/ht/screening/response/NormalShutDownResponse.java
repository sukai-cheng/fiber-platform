package com.ht.screening.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class NormalShutDownResponse implements Serializable {
    Boolean status;
    Boolean printFlag;
}
