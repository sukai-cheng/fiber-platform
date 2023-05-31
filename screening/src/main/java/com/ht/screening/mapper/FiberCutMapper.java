package com.ht.screening.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.screening.dto.FiberDrawingDefectInfo;
import com.ht.screening.entity.ScLsQxqc;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface FiberCutMapper extends BaseMapper<ScLsQxqc> {
    int deleteByPrimaryKey(@Param("lsbh") String lsbh, @Param("xh") Integer xh);

    int insertSelective(ScLsQxqc record);

    ScLsQxqc selectByPrimaryKey(@Param("lsbh") String lsbh, @Param("xh") Integer xh);

    int updateByPrimaryKeySelective(ScLsQxqc record);

    int updateByPrimaryKey(ScLsQxqc record);

    int updateBatch(List<ScLsQxqc> list);

    int batchInsert(@Param("list") List<ScLsQxqc> list);

    List<FiberDrawingDefectInfo> fiberCutDetail(String fiberDiskNum);
}