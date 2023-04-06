package top.kjwang.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.System.currentTimeMillis;


/**
 * @author kjwang
 * @date 2023/4/4 14:02
 * @description AsyncTaskTest
 */

@Slf4j
@SpringBootTest
class AsyncTaskTest {
    @Resource
    private AsyncTask asyncTask;

    @Test
    void testAsyncTasks() throws InterruptedException {
        long start = currentTimeMillis();
        // 异步并发执行
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
        System.out.println("执行其他代码……");
        long end = currentTimeMillis();
        log.info("完成所有任务，总耗时：" + (end - start) + "毫秒");
    }
}