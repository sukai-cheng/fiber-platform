package com.ht.shaixuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.shaixuan.entity.SxLs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface SxLsMapper extends BaseMapper<SxLs> {
    int deleteByPrimaryKey(Object id);


    SxLs selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(SxLs record);

    int updateByPrimaryKey(SxLs record);

    int updateBatch(List<SxLs> list);

    int batchInsert(@Param("list") List<SxLs> list);


}