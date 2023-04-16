package top.kjwang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author kjwang
 * @date 2023/4/16 18:35
 * @description ${NAME}
 */

@EnableCaching
@SpringBootApplication
@MapperScan(basePackages = {"top.kjwang.mapper"})
public class SpringBootCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheApplication.class, args);
    }
}