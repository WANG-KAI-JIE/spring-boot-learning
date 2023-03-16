package top.kjwang.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author kjwang
 * @Date 2023/3/16 19:19
 */
@Configuration
@Profile("test")   // 指定 test 环境配置类标识
public class TestDBConfig implements DBConfig {
    @Override
    public String configure() {
        return "test 环境数据库配置";
    }
}