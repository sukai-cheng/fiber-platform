package com.ht.screening.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author chengsukai
 */
@Data
public class OptionDto implements Serializable {
    List<String> colorList;
    List<String> plateList;
    List<String> newOldList;
}
