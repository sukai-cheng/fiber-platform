package com.ht.screening.schedule;

import com.ht.base.constant.CommonConstant;
import com.ht.screening.dto.DeviceInfo;
import com.ht.screening.entity.ScSx2;
import com.ht.screening.mapper.ScSx2Mapper;
import com.ht.screening.service.impl.DeviceInfoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author chengsukai
 */
@Slf4j
public class DeviceStatusJob extends QuartzJobBean {

    private boolean isActived = false;
    @Resource
    private DeviceInfoServiceImpl deviceInfoService;

    @Resource
    private ScSx2Mapper scSx2Mapper;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//        if(!isActived){
//            return;
//        }
        context.getJobDetail().getJobDataMap().forEach(
                (k, v) -> log.info("param, key:{}, value:{}", k, v)
        );

        log.info("Start Job执行时间: " + new Date());
//        if(isActived) {
//        DeviceInfo deviceInfo = deviceInfoService.deviceInfoSchedule();
//        saveLog(deviceInfo);
//        }

    }

    /**
     * 如果机器停止就写入log
     *
     * @param deviceInfo
     */
    private void saveLog(DeviceInfo deviceInfo) {
        int normalRunning = deviceInfo.normalRun;
        int exceptionStop = deviceInfo.exceptionStop;

        if (normalRunning == 1 || exceptionStop == 1) {
            // todo 写入日志
            log.info("写入日志");
        }
        log.info("机器正常运转");
    }

    private void saveMachineStatus(String mainDiskNum,DeviceInfo deviceInfo){
        if(StringUtils.isEmpty(mainDiskNum)){
            return;
        }
        // 异常停机
        if(deviceInfo.getExceptionStop() == CommonConstant.EXCEPTION_STOP &&deviceInfo.getNormalRun() != CommonConstant.NORMAL_STOP){

            // 断纤上传

        }
    }

    /**
     * 断纤上传
     * @param fiberCode 光纤盘号
     */
    private void fiberCutUpload(String fiberCode){
        List<ScSx2> scSx2 = scSx2Mapper.findByFilterCode(fiberCode);

    }


}
