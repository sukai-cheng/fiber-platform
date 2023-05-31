package com.ht.screening.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.screening.entity.YzbMiddleTable;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface YzbMiddleTableMapper extends BaseMapper<YzbMiddleTable> {
    int deleteByPrimaryKey(String gsid);


    YzbMiddleTable selectByPrimaryKey(String gsid);

    int updateByPrimaryKeySelective(YzbMiddleTable record);

    int updateByPrimaryKey(YzbMiddleTable record);

    int updateBatch(List<YzbMiddleTable> list);

    int batchInsert(@Param("list") List<YzbMiddleTable> list);
}