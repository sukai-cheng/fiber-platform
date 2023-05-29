package com.ht.shaixuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.shaixuan.entity.TAccount;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface TAccountMapper extends BaseMapper<TAccount> {
    int deleteByPrimaryKey(Integer fid);

    @Override
    int insert(TAccount record);

    int insertSelective(TAccount record);

    TAccount selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(TAccount record);

    int updateByPrimaryKey(TAccount record);

    int updateBatch(List<TAccount> list);

    int batchInsert(@Param("list") List<TAccount> list);

    Integer findByUserNameAndPassWord(@Param("userName") String fAccount, @Param("password") String password);

}