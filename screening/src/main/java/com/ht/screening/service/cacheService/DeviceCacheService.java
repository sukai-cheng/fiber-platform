package com.ht.screening.service.cacheService;

import com.ht.screening.entity.DeviceInfo;
import com.ht.screening.mapper.DeviceInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chengsukai
 */
@Service
@Slf4j
public class DeviceCacheService {
    @Resource
    private DeviceInfoMapper deviceInfoMapper;
    @Cacheable(cacheManager = "redisCacheManager", value = "deviceInfoList")
    public List<DeviceInfo> deviceInfoList() {

        log.info("不走缓存");
        List<com.ht.screening.entity.DeviceInfo> deviceInfos = deviceInfoMapper.selectAll();
        return deviceInfos;
    }
}
