package com.ht.screening.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.screening.entity.PaperInfo;
import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * @author chengsukai
 */
public interface PaperInfoMapper extends BaseMapper<PaperInfo> {
    int deleteByPrimaryKey(String papermark);

    int insertSelective(PaperInfo record);

    PaperInfo selectByPrimaryKey(String papermark);

    int updateByPrimaryKeySelective(PaperInfo record);

    int updateByPrimaryKey(PaperInfo record);

    int updateBatch(List<PaperInfo> list);

    int batchInsert(@Param("list") List<PaperInfo> list);

    String getPaperNo(@Param("sxbhPrefix") String sxbhPrefix);
}