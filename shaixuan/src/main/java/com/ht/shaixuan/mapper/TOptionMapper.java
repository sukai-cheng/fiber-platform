package com.ht.shaixuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.shaixuan.entity.TOption;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface TOptionMapper extends BaseMapper<TOption> {
    int deleteByPrimaryKey(Integer fid);

    @Override
    int insert(TOption record);

    int insertSelective(TOption record);

    TOption selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(TOption record);

    int updateByPrimaryKey(TOption record);

    int updateBatch(List<TOption> list);

    int batchInsert(@Param("list") List<TOption> list);

    List<String> findByAction(String actionValue);
}