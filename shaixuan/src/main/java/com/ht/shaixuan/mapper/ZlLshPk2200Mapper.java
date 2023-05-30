package com.ht.shaixuan.mapper;

import com.ht.shaixuan.entity.ZlLshPk2200;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZlLshPk2200Mapper {
    int deleteByPrimaryKey(String jydh);

    int insert(ZlLshPk2200 record);

    int insertSelective(ZlLshPk2200 record);

    ZlLshPk2200 selectByPrimaryKey(String jydh);

    int updateByPrimaryKeySelective(ZlLshPk2200 record);

    int updateByPrimaryKey(ZlLshPk2200 record);

    int updateBatch(List<ZlLshPk2200> list);

    int batchInsert(@Param("list") List<ZlLshPk2200> list);
}