package com.ht.screening.dto;

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
    Date startDate;
}
