package com.ht.screening.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.screening.entity.DeviceInfo;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface DeviceInfoMapper  extends BaseMapper<DeviceInfo> {
    int deleteByPrimaryKey(Integer deviceId);

    int insertSelective(DeviceInfo record);

    DeviceInfo selectByPrimaryKey(Integer deviceId);

    int updateByPrimaryKeySelective(DeviceInfo record);

    int updateByPrimaryKey(DeviceInfo record);

    int updateBatch(List<DeviceInfo> list);

    int batchInsert(@Param("list") List<DeviceInfo> list);

    DeviceInfo selectByDeviceName(@Param("deviceName") String deviceName);

    List<DeviceInfo> selectAll();
}