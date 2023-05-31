package com.ht.shaixuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.shaixuan.entity.ScLsYcdj;
import java.util.List;

import com.ht.shaixuan.entity.ScSx;
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