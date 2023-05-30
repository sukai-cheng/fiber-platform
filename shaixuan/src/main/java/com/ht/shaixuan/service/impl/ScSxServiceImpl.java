package com.ht.shaixuan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.base.domain.AjaxResult;
import com.ht.shaixuan.dto.FiberFilterInfo;
import com.ht.shaixuan.entity.ScSx;
import com.ht.shaixuan.entity.ScSx2;
import com.ht.shaixuan.mapper.ScSx2Mapper;
import com.ht.shaixuan.mapper.ScSxMapper;
import com.ht.shaixuan.service.ScSxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 获取筛选信息
 *
 * @author chengsukai
 */
@Service
public class ScSxServiceImpl extends ServiceImpl<ScSxMapper, ScSx> implements ScSxService {

    @Resource
    private ScSxMapper mainPlateMapper;

    @Resource
    private ScSx2Mapper accessoryPlateMapper;

    @Override
    public AjaxResult getMainPlateInfo(String mainDiskCode) {
        ScSx scsx = mainPlateMapper.findByMainDiskCode(mainDiskCode);
        List<ScSx2> accessoryPlateInfo = getAccessoryPlateInfo(scsx.getSxbh());
        FiberFilterInfo fiberFilterInfo = new FiberFilterInfo();
        fiberFilterInfo.setMainPlateInfo(scsx);
        fiberFilterInfo.setAccessoryPlateInfo(accessoryPlateInfo);

        return AjaxResult.success(fiberFilterInfo);
    }

    @Override
    public List<ScSx2> getAccessoryPlateInfo(String filterCode) {
        return accessoryPlateMapper.findByFilterCode(filterCode);
    }


}
