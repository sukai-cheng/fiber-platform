package com.ht.screening.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.screening.entity.ScLsYcdj;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface ScLsYcdjMapper extends BaseMapper<ScLsYcdj> {
    int deleteByPrimaryKey(Integer fid);

    @Override
    int insert(ScLsYcdj record);

    int insertSelective(ScLsYcdj record);

    ScLsYcdj selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(ScLsYcdj record);

    int updateByPrimaryKey(ScLsYcdj record);

    int updateBatch(List<ScLsYcdj> list);

    int batchInsert(@Param("list") List<ScLsYcdj> list);

    List<ScLsYcdj> getElevationDifference(String sx);
}