package com.ht.screening.service;

import com.ht.screening.dto.AbnormalShutdownDto;
import com.ht.screening.dto.NormalShutdownDto;
import com.ht.screening.response.AbnormalShutDownResponse;
import com.ht.screening.response.NormalShutDownResponse;

/**
 * 停机处理
 *
 * @author chengsukai
 */
public interface ShutDownService {

    /**
     * 正常停机
     */
    NormalShutDownResponse normalShutdown(NormalShutdownDto normalShutdownDto);

    /**
     * 异常停机
     */
    AbnormalShutDownResponse abnormalShutdown(AbnormalShutdownDto normalShutdownDto);

}
