package com.ht.screening.service;

import com.ht.screening.request.AbnormalShutdownRequest;
import com.ht.screening.request.NormalShutdownRequest;
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
    NormalShutDownResponse normalShutdown(NormalShutdownRequest normalShutdownRequest);

    /**
     * 异常停机
     */
    AbnormalShutDownResponse abnormalShutdown(AbnormalShutdownRequest abnormalShutdownRequest);

}
