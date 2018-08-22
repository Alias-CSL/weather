package cn.alias.weather.config;

import cn.alias.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author alias.Chen
 * @date 2018/8/22 16:56
 */
@Configuration
public class QuartzConfiguration {
    @Bean
    public JobDetail weatherDataSyncJobJobDetail() {
        JobDetail jobDetail = JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob").storeDurably().build();
        return jobDetail;
    }

    @Bean
    public Trigger simpleJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
        return TriggerBuilder.newTrigger()
                .forJob(weatherDataSyncJobJobDetail())
                    .withIdentity("weatherDataSyncTrigger")
                    .withSchedule(scheduleBuilder)
                    .build();
    }
}
