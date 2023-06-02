package com.ht.screening.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.screening.dto.DrawBenchDto;
import com.ht.screening.entity.ScLs1;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface ScLs1Mapper extends BaseMapper<ScLs1> {
    int deleteByPrimaryKey(String lsbh);

    int insertSelective(ScLs1 record);

    ScLs1 selectByPrimaryKey(String lsbh);

    int updateByPrimaryKeySelective(ScLs1 record);

    int updateByPrimaryKey(ScLs1 record);

    int updateBatch(List<ScLs1> list);

    int batchInsert(@Param("list") List<ScLs1> list);

    /**
     * 获取拉丝信息
     */
    DrawBenchDto getDrawBenchInfo(@Param("fiberDiskNum") String fiberDiskNum);

}