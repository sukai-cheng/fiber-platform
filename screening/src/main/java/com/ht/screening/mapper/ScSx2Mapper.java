package com.ht.screening.mapper;

import com.ht.screening.entity.ScSx2;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 小盘 - 筛选信息
 *
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
     *
     * @param filterCode 筛选编号
     */
    List<ScSx2> findByFilterCode(String filterCode);

    /**
     * 根据筛选编号和序号查询筛选的小盘信息
     *
     * @param filterCode   筛选编号
     * @param serialNumber 序号
     * @return
     */
    ScSx2 findByFilterCodeAndSerialNumber(@Param("filterCode") String filterCode, @Param("serialNumber") String serialNumber);

    /**
     * 根据筛选编号获取最大的ID
     */
    Integer getMaxId(String filterCode);

    /**
     * 根据大盘号获取筛选编号
     *
     * @param mainDiskCode
     * @return
     */
    String getFilterCodeByMainDiskCode(String mainDiskCode);

    /**
     * 修改Scsx2表
     *
     * @param dqcd                断纤长度
     * @param time                时间
     * @param qxlb                缺陷类型
     * @param glqk                隔离情况
     * @param blyy                不良原因
     * @param lastUpdateTime      最新修改时间
     * @param lastUpdateAccountId 修改人
     * @param sxbh                筛选编号
     * @param xh                  序号
     */
    void updateScSx2DQCD(@Param("dqcd") Long dqcd,
                         @Param("sj") Integer time,
                         @Param("qxlb") String qxlb,
                         @Param("glqk") String glqk,
                         @Param("blyy") String blyy,
                         @Param("lastUpdateTime") Date lastUpdateTime,
                         @Param("lastUpdateAccountId") String lastUpdateAccountId,
                         @Param("sxbh") String sxbh,
                         @Param("xh") String xh);

    /**
     * 修改Scsx2表
     *
     * @param qgcd                切割长度
     * @param time                时间
     * @param qxlb                缺陷类型
     * @param glqk                隔离情况
     * @param blyy                不良原因
     * @param lastUpdateTime      最新修改时间
     * @param lastUpdateAccountId 修改人
     * @param sxbh                筛选编号
     * @param xh                  序号
     */
    void updateScSx2QGCD(@Param("qgcd") Long qgcd,
                         @Param("sj") Integer time,
                         @Param("qxlb") String qxlb,
                         @Param("glqk") String glqk,
                         @Param("blyy") String blyy,
                         @Param("lastUpdateTime") Date lastUpdateTime,
                         @Param("lastUpdateAccountId") String lastUpdateAccountId,
                         @Param("sxbh") String sxbh,
                         @Param("xh") String xh);

    String getXptmByPh(@Param("ph") String ph);

    List<ScSx2> getXptm(@Param("sxbh") String sxbh);

    String getxptm(@Param("sxbh") String sxbh);

    String getxh(@Param("sxbh") String sxbh);

    ScSx2 selectByXptm(@Param("xptm") String xptm);
}