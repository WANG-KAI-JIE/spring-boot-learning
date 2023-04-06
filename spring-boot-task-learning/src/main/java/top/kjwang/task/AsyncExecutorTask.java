package top.kjwang.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author kjwang
 * @date 2023/4/4 14:35
 * @description 通过线程池来调度任务
 */

@Slf4j
@Component
public class AsyncExecutorTask extends AbstractTask{
    @Async("taskExecutor")
    public Future<String> doTaskOneCallBack() throws InterruptedException {
        super.doTaskOne();
        log.info("任务一，当前线程是：" + Thread.currentThread().getName());
        return new AsyncResult<>("任务一完成");
    }


    @Async("taskExecutor")
    public Future<String> doTaskTwoCallBack() throws InterruptedException {
        super.doTaskTwo();
        log.info("任务二，当前线程是：" + Thread.currentThread().getName());
        return new AsyncResult<>("任务二完成");
    }


    @Async("taskExecutor")
    public Future<String> doTaskThreeCallBack() throws InterruptedException {
        super.doTaskThree();
        log.info("任务三，当前线程是：" + Thread.currentThread().getName());
        return new AsyncResult<>("任务三完成");
    }
}
