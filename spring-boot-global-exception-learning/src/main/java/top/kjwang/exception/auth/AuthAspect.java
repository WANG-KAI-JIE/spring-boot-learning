package top.kjwang.exception.auth;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.kjwang.exception.enums.CustomExceptionType;
import top.kjwang.exception.exception.CustomException;

import java.lang.reflect.Method;

/**
 * @author kjwang
 * @date 2023/3/28 16:50
 * @description AuthAspect
 */

@Aspect
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthAspect {

    @Around("@annotation(top.kjwang.exception.auth.CheckAuth)")
    public Object checkAuth(ProceedingJoinPoint point) throws Throwable{
        // 获取 request
        HttpServletRequest request = getHttpServletRequest();
        // 获取请求头
        String token = request.getHeader("Authorization");
        if(token == null){
            throw new CustomException(CustomExceptionType.UNAUTHORIZED_ERROR);
        }

        // 校验 token ，用 JWT 工具类
        // id role
//        request.setAttribute("id",1);

        // 获取注解上的 value
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        CheckAuth annotation = method.getAnnotation(CheckAuth.class);
        String value = annotation.value();
        // 不等，证明 token 错误
        if (!value.equals(token)){
            throw new CustomException(CustomExceptionType.UNAUTHORIZED_ERROR);
        }
        return point.proceed();
    }

    private HttpServletRequest getHttpServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        assert attributes != null;
        return attributes.getRequest();
    }
}
