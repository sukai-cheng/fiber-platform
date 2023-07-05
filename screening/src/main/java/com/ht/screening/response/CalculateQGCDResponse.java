package com.ht.screening.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class CalculateQGCDResponse implements Serializable {
    Double value;
    String msg;
}
