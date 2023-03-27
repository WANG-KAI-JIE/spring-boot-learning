package top.kjwang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import top.kjwang.event.MyEvent;
import top.kjwang.event.MyListener1;
import top.kjwang.event.MyListener3;


/**
 * @author kjwang
 * @date ${DATE} ${TIME}
 * @description ${NAME}
 */
@SpringBootApplication
@ServletComponentScan
public class SpringBootLaunchApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootLaunchApplication.class,args);
    }
}

//@SpringBootApplication
//public class SpringBootLaunchApplication{
//    public static void main(String[] args) {
//        // 获取ConfigurableApplicationContext上下文
//        ConfigurableApplicationContext context = SpringApplication.run(SpringBootLaunchApplication.class,args);
//        // 装载 MyListener 监听
//        context.addApplicationListener(new MyListener1());
//
//        // 发布事件
//        context.publishEvent(new MyEvent("测试事件"));
//    }
//}