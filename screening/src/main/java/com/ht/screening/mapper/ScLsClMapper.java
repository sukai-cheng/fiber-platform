package com.ht.screening.mapper;

import com.ht.screening.entity.ScLsCl;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScLsClMapper {
    int deleteByPrimaryKey(@Param("lsbh") String lsbh, @Param("itemid") Integer itemid);

    int insert(ScLsCl record);

    int insertSelective(ScLsCl record);

    ScLsCl selectByPrimaryKey(@Param("lsbh") String lsbh, @Param("itemid") Integer itemid);

    int updateByPrimaryKeySelective(ScLsCl record);

    int updateByPrimaryKey(ScLsCl record);

    int updateBatch(List<ScLsCl> list);

    int batchInsert(@Param("list") List<ScLsCl> list);
}