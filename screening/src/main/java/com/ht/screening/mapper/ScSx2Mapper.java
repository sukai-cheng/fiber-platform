package com.ht.screening.mapper;

import com.ht.screening.entity.ScSx2;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 小盘 - 筛选信息
 * @author chengsukai
 */
public interface ScSx2Mapper {
    int deleteByPrimaryKey(@Param("sxbh") String sxbh, @Param("xh") String xh);

    int insert(ScSx2 record);

    int insertSelective(ScSx2 record);

    ScSx2 selectByPrimaryKey(@Param("sxbh") String sxbh, @Param("xh") String xh);

    int updateByPrimaryKeySelective(ScSx2 record);

    int updateByPrimaryKey(ScSx2 record);

    int updateBatch(List<ScSx2> list);

    int batchInsert(@Param("list") List<ScSx2> list);

    /**
     * 根据筛选编号查询小盘信息
     * @param filterCode 筛选编号
     */
    List<ScSx2> findByFilterCode(String filterCode);
}