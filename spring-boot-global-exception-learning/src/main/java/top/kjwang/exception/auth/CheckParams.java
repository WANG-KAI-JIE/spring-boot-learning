package top.kjwang.exception.auth;

import top.kjwang.exception.enums.CheckType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author kjwang
 * @date 2023/3/28 21:44
 * @description CheckParams
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckParams {
    String attributeName();
    CheckType type();
    String value() default "";
    String errorMessage() default "参数值不合法！";

}
