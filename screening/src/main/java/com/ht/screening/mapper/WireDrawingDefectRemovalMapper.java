package com.ht.screening.mapper;

import com.ht.screening.entity.WireDrawingDefectRemovalEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 拉丝缺陷切除
 * @author chengsukai
 */
public interface WireDrawingDefectRemovalMapper {
    int deleteByPrimaryKey(@Param("lsbh") String lsbh, @Param("xh") Integer xh);

    int insert(WireDrawingDefectRemovalEntity record);

    int insertSelective(WireDrawingDefectRemovalEntity record);

    WireDrawingDefectRemovalEntity selectByPrimaryKey(@Param("lsbh") String lsbh, @Param("xh") Integer xh);

    int updateByPrimaryKeySelective(WireDrawingDefectRemovalEntity record);

    int updateByPrimaryKey(WireDrawingDefectRemovalEntity record);

    int updateBatch(List<WireDrawingDefectRemovalEntity> list);

    int batchInsert(@Param("list") List<WireDrawingDefectRemovalEntity> list);
}