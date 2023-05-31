package com.ht.screening.dto;

import com.ht.screening.entity.ScSx;
import com.ht.screening.entity.ScSx2;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author chengsukai
 */
@Data
public class FiberFilterInfo implements Serializable {

    /**
     * 大盘筛选信息
     */
    ScSx mainPlateInfo;

    /**
     * 小盘筛选信息
     */
    List<ScSx2> accessoryPlateInfo;
}
