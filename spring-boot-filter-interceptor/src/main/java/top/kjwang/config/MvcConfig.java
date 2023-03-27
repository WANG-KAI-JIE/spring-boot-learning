package top.kjwang.config;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.kjwang.interceptor.AuthInterceptor;
import top.kjwang.interceptor.CustomHandlerInterceptor;
//import top.kjwang.interceptor.CustomHandlerInterceptor;

/**
 * @author kjwang
 * @date 2023/3/27 16:04
 * @description MvcConfiug
 */

@Configuration
@AllArgsConstructor
public class MvcConfig implements WebMvcConfigurer {
    private final String[] excludePath = {"/css/**","/api/login", "/images/**"};

    @Resource
    private CustomHandlerInterceptor customHandlerInterceptor;

    @Resource
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customHandlerInterceptor).addPathPatterns("/**").excludePathPatterns(excludePath);
        registry.addInterceptor(authInterceptor).addPathPatterns("/**").excludePathPatterns(excludePath);
    }
}
