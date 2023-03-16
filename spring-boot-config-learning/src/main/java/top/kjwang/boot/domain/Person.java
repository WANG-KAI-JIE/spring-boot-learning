package top.kjwang.boot.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author kjwang
 * @Date 2023/3/14 13:58
 */

@Component
@ConfigurationProperties(prefix = "person")
//@ConfigurationProperties(prefix = "")注解 批量注入属性值
@Data
public class Person {
    private Integer id;
    private String name;
    private List<String> hobby;
    private String[] family;
    private Map map;
    private Pet pet;
}
