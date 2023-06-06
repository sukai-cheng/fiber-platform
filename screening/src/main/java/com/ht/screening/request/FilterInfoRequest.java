package com.ht.screening.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 获取筛选信息请求体
 * @author chengsukai
 */
@Data
public class FilterInfoRequest implements Serializable {

    /**
     * 光纤盘号
     */
    String fiberDiskNum;
}
