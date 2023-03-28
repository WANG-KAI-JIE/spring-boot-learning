package top.kjwang.exception.auth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author kjwang
 * @date 2023/3/28 16:48
 * @description 自定义认证注解
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface CheckAuth {
    String value();

}
