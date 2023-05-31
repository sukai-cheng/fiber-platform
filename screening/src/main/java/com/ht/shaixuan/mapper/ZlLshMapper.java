package com.ht.shaixuan.mapper;

import com.ht.shaixuan.entity.ZlLsh;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZlLshMapper {
    int deleteByPrimaryKey(String jydh);

    int insert(ZlLsh record);

    int insertSelective(ZlLsh record);

    ZlLsh selectByPrimaryKey(String jydh);

    int updateByPrimaryKeySelective(ZlLsh record);

    int updateByPrimaryKey(ZlLsh record);

    int updateBatch(List<ZlLsh> list);

    int batchInsert(@Param("list") List<ZlLsh> list);
}