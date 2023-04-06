package top.kjwang.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Future;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;
import org.junit.jupiter.api.Test;

/**
 * @author kjwang
 * @date 2023/4/4 14:16
 * @description AsyncCallBackTaskTest
 */
@Slf4j
@SpringBootTest
class AsyncCallBackTaskTest {

    @Resource
    private AsyncCallBackTask asyncCallBackTask;

    @Test
    void testAsyncCallBackTask() throws InterruptedException {
        long start = currentTimeMillis();
        Future<String> task1 = asyncCallBackTask.doTaskOneCallBack();
        Future<String> task2 = asyncCallBackTask.doTaskTwoCallBack();
        Future<String> task3 = asyncCallBackTask.doTaskThreeCallBack();

        // 三个任务都调用完成，退出等待
        while (!task1.isDone() || !task2.isDone() || !task3.isDone()) {
            sleep(1000);
        }
        long end = currentTimeMillis();
        log.info("完成所有任务，总耗时：" + (end - start) + "毫秒");
    }

}