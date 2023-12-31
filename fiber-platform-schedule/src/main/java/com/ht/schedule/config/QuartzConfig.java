package com.ht.schedule.config;

import com.ht.schedule.DeviceStatusJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean("helloJob")
    public JobDetail helloJobDetail() {
        return JobBuilder.newJob(DeviceStatusJob.class)
                .withIdentity("DateTimeJob")
                .usingJobData("msg", "Hello Quartz")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger printTimeJobTrigger() {
        // 每秒执行一次
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(helloJobDetail())
                .withIdentity("quartzTaskService")
                .withSchedule(cronScheduleBuilder)
                .build();
    }

}
