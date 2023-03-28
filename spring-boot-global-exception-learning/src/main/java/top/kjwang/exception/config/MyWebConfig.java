package top.kjwang.exception.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.kjwang.exception.interceptor.VerifyParamInterceptor;

/**
 * @author kjwang
 * @date 2023/3/28 22:11
 * @description MyWebConfig
 */

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Resource
    private VerifyParamInterceptor verifyParamInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(verifyParamInterceptor).addPathPatterns("/check");
    }
}
