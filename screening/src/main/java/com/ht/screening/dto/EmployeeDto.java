package com.ht.screening.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class EmployeeDto implements Serializable {
    String account;
    String name;
    String bz;
    String computerIP;
}
