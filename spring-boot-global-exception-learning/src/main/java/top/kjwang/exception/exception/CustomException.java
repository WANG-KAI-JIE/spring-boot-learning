package top.kjwang.exception.exception;

import top.kjwang.exception.enums.CustomExceptionType;

/**
 * @author kjwang
 * @date 2023/3/28 14:24
 * @description 自定义异常类
 */
public class CustomException extends RuntimeException{
    /**
     * 异常错误编码
     */
    private int code;
    /**
     * 异常信息
     */
    private String message;
    private CustomException(){

    }
    public CustomException(CustomExceptionType customExceptionType){
        this.code = customExceptionType.getCode();
        this.message = customExceptionType.getDesc();
    }

    public CustomException(CustomExceptionType customExceptionType,
                           String message){
        this.code = customExceptionType.getCode();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
