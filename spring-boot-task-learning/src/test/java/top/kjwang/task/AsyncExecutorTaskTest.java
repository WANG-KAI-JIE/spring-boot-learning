package top.kjwang.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kjwang
 * @date 2023/4/4 14:38
 * @description AsyncExecutorTaskTest
 */

@Slf4j
@SpringBootTest
class AsyncExecutorTaskTest {
    @Resource
    private AsyncExecutorTask task;

    @Test
    void testAsyncExecutorTaskTest() throws InterruptedException {
        task.doTaskOneCallBack();
        task.doTaskTwoCallBack();
        task.doTaskThreeCallBack();
        sleep(10 * 1000L);
    }
}