package com.ht.screening.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.screening.entity.ScSx;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface ScSxMapper extends BaseMapper<ScSx> {
    int deleteByPrimaryKey(String sxbh);

    ScSx selectByPrimaryKey(String sxbh);

    int updateByPrimaryKeySelective(ScSx record);

    int updateByPrimaryKey(ScSx record);

    int updateBatch(List<ScSx> list);

    int batchInsert(@Param("list") List<ScSx> list);

    /**
     * 根据大盘号获取筛选信息
     *
     * @param mainDiskCode 大盘号(光纤盘号)
     */
    ScSx findByMainDiskCode(String mainDiskCode);

    /**
     * 获取已筛总长度
     * @param mainDiskCode 大盘号(光纤盘号)
     */
    String calTotalLen(String mainDiskCode);
}