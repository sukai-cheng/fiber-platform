package com.ht.screening.request;

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
public class AbnormalShutdownRequest implements Serializable {

    //筛选信息
    FilterInfoDto filterInfo;

    Date initialTime;

    SelectDataDto selectDataDto;

    LoginDataDto loginDataDto;

    DeviceDataDto deviceDataDto;
}
