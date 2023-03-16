package top.kjwang.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author kjwang
 * @Date 2023/3/14 15:59
 */
@Configuration
@Profile("dev")   // 指定 dev 环境配置类标识
public class DevDBConfig implements DBConfig {
    @Override
    public String configure() {
        return "dev 环境数据库配置";
    }
}
