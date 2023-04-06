package top.kjwang.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.kjwang.jobs.QuartzSimpleTask;

/**
 * @author kjwang
 * @date 2023/4/5 20:39
 * @description Quartz 定时配置类
 */

@Configuration
public class QuartzSimpleConfig {
    // 指定具体的定时任务类
    @Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder.newJob(QuartzSimpleTask.class)
                .withIdentity("QuartzSimpleTask")
                .storeDurably().build();
    }
    @Bean
    public Trigger uploadTaskTrigger() {
        // 这里设定触发执行的方式，"*/5*    * ?"表示定时任务，每隔5秒钟执行一次。
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        // 返回任务触发器
        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
                .withSchedule(scheduleBuilder).build();
    }
}
