package com.ht.screening.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 拉丝信息请求体
 * @author chengsukai
 */
@Data
public class DrawInfoRequest implements Serializable {

    String fiberDiskNum;
}
