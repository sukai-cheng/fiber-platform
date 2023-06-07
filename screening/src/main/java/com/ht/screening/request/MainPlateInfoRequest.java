package com.ht.screening.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class MainPlateInfoRequest implements Serializable {
    String accountId;
    String bz;
    String fiberDiskCode;
}
