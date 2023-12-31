package com.ht.screening.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.screening.entity.TOption;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface TOptionMapper extends BaseMapper<TOption> {
    int deleteByPrimaryKey(Integer fid);

    TOption selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(TOption record);

    int updateByPrimaryKey(TOption record);

    int updateBatch(List<TOption> list);

    int batchInsert(@Param("list") List<TOption> list);

    List<String> findByAction(String actionValue);
}