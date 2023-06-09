package com.ht.screening.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.screening.entity.JcYzb;
import java.util.List;

import com.ht.screening.entity.PaperInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface JcYzbMapper extends BaseMapper<JcYzb> {
    int deleteByPrimaryKey(String gsid);

    int insertSelective(JcYzb record);

    JcYzb selectByPrimaryKey(String gsid);

    int updateByPrimaryKeySelective(JcYzb record);

    int updateByPrimaryKey(JcYzb record);

    int updateBatch(List<JcYzb> list);

    int batchInsert(@Param("list") List<JcYzb> list);

    /**
     * 获取类别
     * @param zzpbh 大盘长度
     */
    String getCategoryName(@Param("ZZPBH") String zzpbh);
}