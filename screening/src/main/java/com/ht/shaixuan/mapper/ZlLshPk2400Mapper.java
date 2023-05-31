package com.ht.shaixuan.mapper;

import com.ht.shaixuan.entity.ZlLshPk2400;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZlLshPk2400Mapper {
    int deleteByPrimaryKey(String jydh);

    int insert(ZlLshPk2400 record);

    int insertSelective(ZlLshPk2400 record);

    ZlLshPk2400 selectByPrimaryKey(String jydh);

    int updateByPrimaryKeySelective(ZlLshPk2400 record);

    int updateByPrimaryKey(ZlLshPk2400 record);

    int updateBatch(List<ZlLshPk2400> list);

    int batchInsert(@Param("list") List<ZlLshPk2400> list);
}