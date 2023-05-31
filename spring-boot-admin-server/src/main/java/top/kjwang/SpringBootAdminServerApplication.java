package top.kjwang;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kjwang
 * @date 2023/4/18 15:54
 * @description ${NAME}
 */
@SpringBootApplication
@EnableAdminServer
public class SpringBootAdminServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminServerApplication.class,args);
    }
}