package com.ht.shaixuan.mapper;

import com.ht.shaixuan.entity.TOption;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface TOptionMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(TOption record);

    int insertSelective(TOption record);

    TOption selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(TOption record);

    int updateByPrimaryKey(TOption record);

    int updateBatch(List<TOption> list);

    int batchInsert(@Param("list") List<TOption> list);
}