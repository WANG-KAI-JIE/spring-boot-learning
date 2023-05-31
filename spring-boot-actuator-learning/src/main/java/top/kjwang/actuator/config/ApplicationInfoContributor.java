package top.kjwang.actuator.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kjwang
 * @date 2023/4/18 15:40
 * @description ApplicationInfoContributor
 */

@Component
public class ApplicationInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("appName","spring-boot-actuator");
        Map<String,Object> data = new HashMap<>();
        data.put("version","1.0.0");
        data.put("author","kjwang");
        builder.withDetails(data);
    }
}
