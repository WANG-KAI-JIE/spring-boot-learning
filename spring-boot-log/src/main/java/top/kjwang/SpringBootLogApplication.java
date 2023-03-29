package top.kjwang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author kjwang
 * @date 2023/3/29 10:38
 * @description SpringBootLogApplication
 */
@SpringBootApplication
//@ImportResource("classpath: logback-spring.xml")
public class SpringBootLogApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootLogApplication.class,args);
    }
}
