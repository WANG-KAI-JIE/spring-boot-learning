package top.kjwang.exception.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.kjwang.exception.auth.CheckParamUtil;
import top.kjwang.exception.auth.CheckParams;
import top.kjwang.exception.enums.CheckType;
import top.kjwang.exception.exception.BizException.ParamNotMatchException;

/**
 * @author kjwang
 * @date 2023/3/28 22:01
 * @description VerifyParamInterceptor
 */

@Component
public class VerifyParamInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
            for (MethodParameter methodParameter : methodParameters){
                if (methodParameter.hasParameterAnnotation(CheckParams.class)){
                    CheckParams params = methodParameter.getParameterAnnotation(CheckParams.class);
                    String verifyValue = request.getParameter(params.attributeName());
                    CheckType type = params.type();
                    String value = params.value();
                    String errorMessage = params.errorMessage();
                    if (!CheckParamUtil.check(verifyValue,type,value)){
                        throw new ParamNotMatchException(ParamNotMatchException.class + " : " +errorMessage);
                    }
                }
            }
        }
        return true;
    }
}
