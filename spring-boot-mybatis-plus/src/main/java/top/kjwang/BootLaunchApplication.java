package top.kjwang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kjwang
 * @date ${DATE} ${TIME}
 * @description ${NAME}
 */

@SpringBootApplication
@MapperScan(basePackages = {"top.kjwang.boot.mapper"})
public class BootLaunchApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootLaunchApplication.class,args);
    }
}