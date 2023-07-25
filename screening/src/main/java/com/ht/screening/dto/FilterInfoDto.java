package com.ht.screening.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class FilterInfoDto implements Serializable {

    @JsonProperty("ph")
    String ph;
    @JsonProperty("sxbh")
    String sxbh;
    @JsonProperty("glqk")
    String glqk;
}
