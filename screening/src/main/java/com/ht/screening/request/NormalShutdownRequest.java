package com.ht.screening.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ht.base.utils.DateUtils;
import com.ht.screening.dto.DeviceDataDto;
import com.ht.screening.dto.FilterInfoDto;
import com.ht.screening.dto.LoginDataDto;
import com.ht.screening.dto.SelectDataDto;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 异常停机请求体
 * @author chengsukai
 */
@Data
public class NormalShutdownRequest implements Serializable {

    //筛选信息
    FilterInfoDto filterInfo;

    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    Date initialTime;

    SelectDataDto selectDataDto;

    LoginDataDto loginDataDto;

    DeviceDataDto deviceDataDto;
}
