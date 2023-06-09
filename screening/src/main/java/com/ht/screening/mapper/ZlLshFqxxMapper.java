package com.ht.screening.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.screening.entity.ZlLshFqxx;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface ZlLshFqxxMapper extends BaseMapper<ZlLshFqxx> {
    int deleteByPrimaryKey(@Param("jydh") String jydh, @Param("fqxh") Integer fqxh);

    int insert(ZlLshFqxx record);

    int insertSelective(ZlLshFqxx record);

    ZlLshFqxx selectByPrimaryKey(@Param("jydh") String jydh, @Param("fqxh") Integer fqxh);

    int updateByPrimaryKeySelective(ZlLshFqxx record);

    int updateByPrimaryKey(ZlLshFqxx record);

    int updateBatch(List<ZlLshFqxx> list);

    int batchInsert(@Param("list") List<ZlLshFqxx> list);
}