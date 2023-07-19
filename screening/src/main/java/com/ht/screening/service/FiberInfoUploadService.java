package com.ht.screening.service;


import com.ht.screening.dto.FilterUploadDto;
import com.ht.screening.response.CalculateQGCDResponse;

import java.util.Date;

/**
 * 光纤信息上传
 *
 * @author chengsukai
 */
public interface FiberInfoUploadService {
    /**
     * 上传数据前置校验FQ
     *
     * @param diskNum 大盘号
     */
    Boolean uploadDataCheckFQ(String diskNum);

    /**
     * 上传数据前置校验GL
     *
     * @param diskNum 大盘号
     */
    Boolean uploadDataCheckGL(String diskNum);


    /**
     * 断纤更新小盘信息
     *
     * @param filterCode  筛选编号
     * @param serialNum   序号
     * @param initialTime 初始时间
     * @return
     */
    Boolean updateDetailDQCD(String filterCode, String serialNum, Double dqcd, Date initialTime);

    /**
     * 断纤更新小盘信息
     *
     * @param filterCode  筛选编号
     * @param serialNum   序号
     * @param initialTime 初始时间
     * @return
     */
    Boolean updateDetailQGCD(CalculateQGCDResponse response, String filterCode, String serialNum, Double dqcd, Date initialTime);

    /**
     * 筛选数据上传
     *
     * @param filterUploadDto 筛选数据上传对象
     */
    void addXSMAIN(FilterUploadDto filterUploadDto);
}
