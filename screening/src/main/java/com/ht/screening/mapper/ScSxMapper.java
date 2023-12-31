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
     * 根据大盘号获取筛选编号
     * @param ysph
     * @return
     */
    String getSxbh(@Param("ysph") String ysph);

    /**
     * 根据筛选号获取大盘编号
     * @param sxbh
     * @return
     */
    String getYsph(@Param("sxbh") String sxbh);

    /**
     * 获取已筛总长度
     * @param mainDiskCode 大盘号(光纤盘号)
     */
    String calTotalLen(String mainDiskCode);

    /**
     * 计算筛选长度
     */
    String calFilterLen(String totalLen,String fiberDiskNum, String cutLen,String mainPlateLen,Object rstqx,String filterLen);

    /**
     * 根据筛选编号获取大盘筛选信息
     */
    ScSx selectByFilterCode(@Param("filterCode") String filterCode);


}
























