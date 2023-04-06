package top.kjwang.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author kjwang
 * @date 2023/4/4 14:00
 * @description AsyncTask
 */

@Component
public class AsyncTask extends AbstractTask{
    @Async
    @Override
    public void doTaskOne() throws InterruptedException {
        super.doTaskOne();
    }

    @Async
    @Override
    public void doTaskTwo() throws InterruptedException {
        super.doTaskTwo();
    }


    @Async
    @Override
    public void doTaskThree() throws InterruptedException {
        super.doTaskThree();
    }
}
