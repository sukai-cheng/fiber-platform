package com.ht.screening.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chengsukai
 */
@Data
public class FiberFilterSmallDiskVo {
    /**
     * 筛选编号
     */
    private String sxbh;

    /**
     * 序号
     */
    private String xh;

    /**
     * 小盘编号
     */
    private String xptm;

    /**
     * 开始位置
     */
    private BigDecimal ewz;

    /**
     * 盘长
     */
    private BigDecimal cd;

    /**
     * 断纤损失
     */
    private String dqqk;

    /**
     * 暂时用不到
     */
    private String gb;

    /**
     * id
     */
    private String id;

    /**
     * ispt
     */
    private Integer ispt;

    /**
     * 是否旧盘具
     */
    private Integer isoldtray;

    /**
     * isbigtray
     */
    private Integer isbigtray;

    /**
     * manufactureType
     */
    private String manufacturetype;

    /**
     * 颜色
     */
    private String color;

    /**
     * 盘具
     */
    private Integer ptnum;

    /**
     * 0 - 头
     * 1 - 尾
     */
    private Integer isheadcauda;

    /**
     * 断纤长度
     */
    private BigDecimal dqcd;

    /**
     * 缺陷类型
     */
    private String qxlb;

    /**
     * 切割长度
     */
    private BigDecimal qgcd;

    /**
     * 审核
     */
    private Integer issh;

    /**
     * 已打印次数
     */
    private Integer isdy;

    /**
     * 不合格原因
     */
    private String blyy;

    /**
     * 未知字段
     */
    private String labour;

    /**
     * 审核人
     */
    private String sxr;

    /**
     * 筛选日期
     */
    private Date crdate;

    /**
     * 未知字段
     */
    private String shLabour;

    /**
     * 审核人
     */
    private String sxshr;

    /**
     * 未知字段
     */
    private Integer xhgl;

    /**
     * 测试端差
     */
    private Integer istestdc;

    /**
     * 隔离情况
     */
    private String qlqk;
}
