package com.ht.shaixuan.mapper;

import com.ht.shaixuan.entity.ZlLshFqxx;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZlLshFqxxMapper {
    int deleteByPrimaryKey(@Param("jydh") String jydh, @Param("fqxh") Integer fqxh);

    int insert(ZlLshFqxx record);

    int insertSelective(ZlLshFqxx record);

    ZlLshFqxx selectByPrimaryKey(@Param("jydh") String jydh, @Param("fqxh") Integer fqxh);

    int updateByPrimaryKeySelective(ZlLshFqxx record);

    int updateByPrimaryKey(ZlLshFqxx record);

    int updateBatch(List<ZlLshFqxx> list);

    int batchInsert(@Param("list") List<ZlLshFqxx> list);
}