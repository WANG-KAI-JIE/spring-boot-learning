package top.kjwang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import top.kjwang.event.MyEvent;
import top.kjwang.event.MyListener1;
import top.kjwang.event.MyListener3;

/**
 * @author kjwang
 * @date 2023/3/27 21:01
 * @description Application
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //获取ConfigurableApplicationContext上下文
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        //装载监听
        context.addApplicationListener(new MyListener3());
        context.addApplicationListener(new MyListener1());

        // 发布事件
        context.publishEvent(new MyEvent("测试事件"));
    }
}
