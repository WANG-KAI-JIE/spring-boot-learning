package top.kjwang.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kjwang.exception.auth.CheckParams;
import top.kjwang.exception.enums.CheckType;

/**
 * @author kjwang
 * @date 2023/3/28 22:13
 * @description TestParamController
 */
@Controller
public class TestParamController {
    @GetMapping("/check")
    @ResponseBody
    public String check(@CheckParams(attributeName = "age",type = CheckType.AGE,value = "20")Integer age,
                        @CheckParams(attributeName = "username",type = CheckType.USERNAME)String username,
                        @CheckParams(attributeName = "password",type = CheckType.PASSWORD)String password){
        return "success";
    }
}
