package com.ht.screening.mapper;

import com.ht.screening.entity.ScLs1;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface ScLs1Mapper {
    int deleteByPrimaryKey(String lsbh);

    int insert(ScLs1 record);

    int insertSelective(ScLs1 record);

    ScLs1 selectByPrimaryKey(String lsbh);

    int updateByPrimaryKeySelective(ScLs1 record);

    int updateByPrimaryKey(ScLs1 record);

    int updateBatch(List<ScLs1> list);

    int batchInsert(@Param("list") List<ScLs1> list);
}