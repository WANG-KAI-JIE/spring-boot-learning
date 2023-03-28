package top.kjwang.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kjwang.exception.enums.CustomExceptionType;
import top.kjwang.exception.exception.CustomException;
import top.kjwang.exception.util.AjaxResponse;

/**
 * @author kjwang
 * @date 2023/3/28 14:33
 * @description WebExceptionHandler
 */

@ControllerAdvice
@Slf4j
public class WebExceptionHandler {
    /**
     * 处理程序员主动抛出的自定义异常
     *
     * @param e 异常
     * @return AjaxResponse
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public AjaxResponse handleException1(CustomException e){
        if (e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
            log.info(CustomExceptionType.SYSTEM_ERROR.getDesc());
            // 400异常不需要持久化，将异常信息以友好的方式告知用户就可以
            // 将500异常信息持久化处理，方便运维人员处理
        }
        return AjaxResponse.error(e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public AjaxResponse handleBindException(MethodArgumentNotValidException ex){
        FieldError fieldError = ex.getBindingResult().getFieldError();
        assert fieldError != null;
        return AjaxResponse.error(new CustomException(CustomExceptionType.PARAM_ERROR,fieldError.getDefaultMessage()));
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public AjaxResponse handleBindException(BindException ex){
        FieldError fieldError = ex.getBindingResult().getFieldError();
        assert fieldError != null;
        return AjaxResponse.error(new CustomException(CustomExceptionType.PARAM_ERROR,fieldError.getDefaultMessage()));
    }
}
