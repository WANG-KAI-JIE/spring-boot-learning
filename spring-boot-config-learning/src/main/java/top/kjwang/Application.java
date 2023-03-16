package top.kjwang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * @author kjwang
 * @Date ${DATE} ${TIME}
 */
@SpringBootApplication
//@ImportResource("classpath:beans.xml") // 加载自定义的 XML 配置文件
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}