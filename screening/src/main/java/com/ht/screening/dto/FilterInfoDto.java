package com.ht.screening.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class FilterInfoDto implements Serializable {
    String ph;
    String sxbh;

    Double dqcd;

    String glqk;
}
