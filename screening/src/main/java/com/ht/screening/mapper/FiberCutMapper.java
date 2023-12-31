package com.ht.screening.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.screening.dto.FiberDrawingDefectInfo;

import java.util.List;

import com.ht.screening.entity.WireDrawingDefectRemovalEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface FiberCutMapper extends BaseMapper<WireDrawingDefectRemovalEntity> {
    int deleteByPrimaryKey(@Param("lsbh") String lsbh, @Param("xh") Integer xh);

    int updateByPrimaryKeySelective(WireDrawingDefectRemovalEntity record);

    int updateByPrimaryKey(WireDrawingDefectRemovalEntity record);

    int updateBatch(List<WireDrawingDefectRemovalEntity> list);

    int batchInsert(@Param("list") List<WireDrawingDefectRemovalEntity> list);

    List<FiberDrawingDefectInfo> fiberCutDetail(String fiberDiskNum);
}