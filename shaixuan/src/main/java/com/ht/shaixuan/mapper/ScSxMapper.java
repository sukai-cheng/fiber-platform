package com.ht.shaixuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.shaixuan.entity.ScSx;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface ScSxMapper extends BaseMapper<ScSx> {
    int deleteByPrimaryKey(String sxbh);

    @Override
    int insert(ScSx record);

    int insertSelective(ScSx record);

    ScSx selectByPrimaryKey(String sxbh);

    int updateByPrimaryKeySelective(ScSx record);

    int updateByPrimaryKey(ScSx record);

    int updateBatch(List<ScSx> list);

    int batchInsert(@Param("list") List<ScSx> list);
}