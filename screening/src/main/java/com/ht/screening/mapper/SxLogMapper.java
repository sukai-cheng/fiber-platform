package com.ht.screening.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.screening.entity.SxLog;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface SxLogMapper extends BaseMapper<SxLog> {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(SxLog record);

    SxLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SxLog record);

    int updateByPrimaryKey(SxLog record);

    int updateBatch(List<SxLog> list);

    int batchInsert(@Param("list") List<SxLog> list);
}