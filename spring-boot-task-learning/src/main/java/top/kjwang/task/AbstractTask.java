package top.kjwang.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

/**
 * @author kjwang
 * @date 2023/4/4 13:46
 * @description 任务抽象类
 */
@Slf4j
public abstract class AbstractTask {
    public void doTaskOne() throws InterruptedException {
        log.info("开始做任务一");
        long start = currentTimeMillis();
        // 执行耗时任务
        sleep(3000);
        long end = currentTimeMillis();
        log.info("完成任务一，耗时：" + (end - start) + "毫秒");
    }
    public void doTaskTwo() throws InterruptedException {
        log.info("开始做任务二");
        long start = currentTimeMillis();
        // 执行耗时任务
        sleep(4000);
        long end = currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "毫秒");
    }
    public void doTaskThree() throws InterruptedException {
        log.info("开始做任务三");
        long start = currentTimeMillis();
        // 执行耗时任务
        sleep(5000);
        long end = currentTimeMillis();
        log.info("完成任务三，耗时：" + (end - start) + "毫秒");
    }
}
