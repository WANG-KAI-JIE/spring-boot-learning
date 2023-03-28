package top.kjwang.exception.enums;

import lombok.Getter;
import top.kjwang.exception.consts.Consts;

/**
 * @author kjwang
 * @date 2023/3/28 14:19
 * @description 异常类型枚举
 */

@Getter
public enum CustomExceptionType {
    SUCCESS(Consts.CODE_200,Consts.SUCCESS),
    PARAM_ERROR(Consts.CODE_400,Consts.PARANM_ERROR),

    UNAUTHORIZED_ERROR(Consts.CODE_401,Consts.UNAUTHORIZED_ERROR),

    FORBIDDEN_ERROR(Consts.CODE_403,Consts.FORBIDDEN_ERROR),

    SYSTEM_ERROR(Consts.CODE_500,Consts.SYSTEM_ERROR),

    OTHER_ERROR(Consts.CODE_999,Consts.OTHER_ERROR);

    CustomExceptionType(int code,String desc){
        this.code = code;
        this.desc = desc;
    }
    /**
     * 异常类型状态码
     */
    private final int code;
    /**
     * 异常类型中文描述
     */
    private final String desc;

}
