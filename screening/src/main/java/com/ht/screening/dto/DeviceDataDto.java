package com.ht.screening.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class DeviceDataDto implements Serializable {
    String pyccd;
    Double hlcd;
    Double sxcd;
}
