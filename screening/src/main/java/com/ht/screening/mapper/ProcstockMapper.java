package com.ht.screening.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.screening.entity.Procstock;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcstockMapper extends BaseMapper<Procstock> {
    int deleteByPrimaryKey(String productid);

    int insertSelective(Procstock record);

    Procstock selectByPrimaryKey(String productid);

    int updateByPrimaryKeySelective(Procstock record);

    int updateByPrimaryKey(Procstock record);

    int updateBatch(List<Procstock> list);

    int batchInsert(@Param("list") List<Procstock> list);

    String checkFinished(@Param("gqph") String fiberDiskCode);

    String checkExists(@Param("gqph") String fiberDiskCode);
}