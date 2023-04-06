package top.kjwang.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author kjwang
 * @date 2023/4/5 20:37
 * @description QuartzSimpleTask
 */
public class QuartzSimpleTask extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("quartz简单的定时任务执行时间：" + new Date().toLocaleString());
    }
}
