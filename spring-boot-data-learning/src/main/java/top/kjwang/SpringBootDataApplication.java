package top.kjwang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kjwang
 * @Date ${DATE} ${TIME}
 */
@SpringBootApplication
@MapperScan(basePackages = {"top.kjwang.mapper"})
public class SpringBootDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataApplication.class,args);
    }
}