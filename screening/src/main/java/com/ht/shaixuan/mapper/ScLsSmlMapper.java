package com.ht.shaixuan.mapper;

import com.ht.shaixuan.entity.ScLsSml;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScLsSmlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScLsSml record);

    int insertSelective(ScLsSml record);

    ScLsSml selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScLsSml record);

    int updateByPrimaryKey(ScLsSml record);

    int updateBatch(List<ScLsSml> list);

    int batchInsert(@Param("list") List<ScLsSml> list);
}