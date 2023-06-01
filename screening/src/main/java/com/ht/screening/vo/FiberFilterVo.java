package com.ht.screening.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author chengsukai
 */
@Data
public class FiberFilterVo implements Serializable {
    FiberFilterMainDiskVo fiberFilterMainDiskVo;
    List<FiberFilterSmallDiskVo> filterSmallDiskVoList;
}
