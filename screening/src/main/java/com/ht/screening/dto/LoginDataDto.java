package com.ht.screening.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ht.base.utils.DateUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chengsukai
 */
@Data
public class LoginDataDto implements Serializable {
    String accountId;
    String bz;
    String username;
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    Date startDate;
}
