package com.ht.screening.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class SelectDataDto implements Serializable {
    String color;
    String yl;
    String pj;
    String xj;
}
