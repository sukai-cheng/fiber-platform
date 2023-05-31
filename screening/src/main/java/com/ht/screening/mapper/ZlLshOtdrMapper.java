package com.ht.screening.mapper;

import com.ht.screening.entity.ZlLshOtdr;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZlLshOtdrMapper {
    int deleteByPrimaryKey(String jydh);

    int insert(ZlLshOtdr record);

    int insertSelective(ZlLshOtdr record);

    ZlLshOtdr selectByPrimaryKey(String jydh);

    int updateByPrimaryKeySelective(ZlLshOtdr record);

    int updateByPrimaryKey(ZlLshOtdr record);

    int updateBatch(List<ZlLshOtdr> list);

    int batchInsert(@Param("list") List<ZlLshOtdr> list);
}