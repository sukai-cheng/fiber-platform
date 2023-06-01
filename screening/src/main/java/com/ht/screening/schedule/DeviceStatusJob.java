package com.ht.screening.schedule;

import com.ht.screening.dto.DeviceInfo;
import com.ht.screening.service.impl.DeviceInfoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author chengsukai
 */
@Slf4j
public class DeviceStatusJob extends QuartzJobBean {

    private boolean isActived = false;
    @Resource
    private DeviceInfoServiceImpl deviceInfoService;

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
        DeviceInfo deviceInfo = deviceInfoService.getDeviceInfo();
        saveLog(deviceInfo);
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


}
