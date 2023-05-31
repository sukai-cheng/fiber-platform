package com.ht.screening.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 断纤信息请求体
 * @author chengsukai
 */
@Data
public class FiberCutRequest implements Serializable {

    String fiberDiskNum;
}
