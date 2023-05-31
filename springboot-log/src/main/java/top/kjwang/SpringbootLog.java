package top.kjwang;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author kjwang
 * @date 2023/4/3 15:51
 */

@SpringBootApplication
//@EnableAspectJAutoProxy
//@RestController
//@MapperScan(basePackages = "top.kjwang.log.mapper")
public class SpringbootLog {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLog.class, args);
    }

}
