package top.kjwang.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author kjwang
 * @Date 2023/3/16 19:20
 */
@Configuration
@Profile("prod")   // 指定 proc 环境配置类标识
public class ProdDBConfig implements DBConfig {
    @Override
    public String configure() {
        return "proc 环境数据库配置";
    }
}