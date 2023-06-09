package com.ht.screening.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.screening.dto.PreferredDiskDto;
import com.ht.screening.entity.SxLs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface SxLsMapper extends BaseMapper<SxLs> {
    int deleteByPrimaryKey(Object id);


    SxLs selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(SxLs record);

    int updateByPrimaryKey(SxLs record);

    int updateBatch(List<SxLs> list);

    int batchInsert(@Param("list") List<SxLs> list);

    List<PreferredDiskDto> checkPreferredDisk(@Param("ph") String ph, @Param("SX") String sx);


}