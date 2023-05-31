package com.ht.screening.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.screening.entity.TAccount;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface TAccountMapper extends BaseMapper<TAccount> {
    int deleteByPrimaryKey(Integer fid);

    TAccount selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(TAccount record);

    int updateByPrimaryKey(TAccount record);

    int updateBatch(List<TAccount> list);

    int batchInsert(@Param("list") List<TAccount> list);

    Integer findByUserNameAndPassWord(@Param("userName") String fAccount, @Param("password") String password);

}