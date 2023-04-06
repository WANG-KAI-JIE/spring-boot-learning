package top.kjwang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author kjwang
 * @date 2023/4/5 20:23
 * @description 解决定时任务单线程运行的问题
 */

@Configuration
@EnableScheduling //开启定时任务
public class ScheduleConfig implements SchedulingConfigurer{
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(scheduledTaskExecutor());
    }

    @Bean
    public Executor scheduledTaskExecutor(){
        // 指定线程池大小
        return Executors.newScheduledThreadPool(3);
    }
}
