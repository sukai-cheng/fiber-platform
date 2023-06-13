package com.ht.screening.dto;

import com.ht.screening.entity.ScLsQxqc;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class LYDto implements Serializable {
    String SXB;
    String SXE;
    String QXCD;
    ScLsQxqc scLsQxqc;
}
