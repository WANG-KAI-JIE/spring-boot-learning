package top.kjwang.boot.prop;

import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author kjwang
 * @Date 2023/3/14 14:56
 */

@Configuration // 标注本类为配置类
@PropertySource("classpath:my.properties") // 指定自定义配置文件的位置和名称
@ConfigurationProperties(prefix = "my") // 指定配置文件的注释文件的前缀
@Setter
@ToString
public class MyProperties {
    private String url;
    private String username;
    private String password;
}
