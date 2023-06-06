package com.ht.screening.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author chengsukai
 */
@Data
@TableName("paperinfo")
public class PaperInfo {
    @TableId(value = "papermark")
    private String paperMark;

    @TableField(value = "paperfirst")
    private String paperFirst;

    @TableField(value = "tag")
    private Integer tag;

    @TableField(value = "paperlastlen")
    private Integer paperLastLen;

    @TableField(value = "tablename")
    private String tableName;

    @TableField(value = "papername")
    private String paperName;

    @TableField(value = "maxvalues")
    private String maxValues;
}