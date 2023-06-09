package com.ht.screening.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.screening.dto.DpCheckResult2Dto;
import com.ht.screening.dto.DpCheckResultDto;
import com.ht.screening.entity.ZlLsh;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface ZlLshMapper extends BaseMapper<ZlLsh> {
    int deleteByPrimaryKey(String jydh);

    int insert(ZlLsh record);

    int insertSelective(ZlLsh record);

    ZlLsh selectByPrimaryKey(String jydh);

    int updateByPrimaryKeySelective(ZlLsh record);

    int updateByPrimaryKey(ZlLsh record);

    int updateBatch(List<ZlLsh> list);

    int batchInsert(@Param("list") List<ZlLsh> list);

    List<DpCheckResultDto> checkFromLs(@Param("gqph") String gqph);

    List<DpCheckResult2Dto> checkFromLsh2(@Param("gqph") String gqph);

    List<ZlLsh> selectFromLsh(@Param("gqph") String gqph);

}