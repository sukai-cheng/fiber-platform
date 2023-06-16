package com.ht.screening.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ht.base.utils.DateUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chengsukai
 */
@Data
public class LoginDataDto implements Serializable {
    @JsonProperty(value = "account")
    String accountId;
    String bz;
    @JsonProperty(value = "name")
    String username;
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    Date startDate;
}
