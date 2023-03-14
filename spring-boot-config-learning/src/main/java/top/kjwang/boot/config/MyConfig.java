package top.kjwang.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.kjwang.boot.service.MyService;

/**
 * @author kjwang
 * @Date 2023/3/14 15:05
 * @description 使用 @Configuration 编写自定义配置类
 */

@Configuration
public class MyConfig {
    /**
     * 将该方法的返回值，作为 Bean，添加到 Spring 容器中，该Bean的id就是方法名
     * @return MyService 实例
     */
    @Bean
    public MyService myService(){
        return new MyService();
    }
}
