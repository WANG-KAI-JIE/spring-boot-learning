package top.kjwang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kjwang
 * @date 2023/3/27 16:18
 * @description InterceptorController
 */
@Controller
@RequestMapping(value = "api")
public class InterceptorController {

    @GetMapping("login")
    public String indexPage(Model model){
        model.addAttribute("msg","Spring 拦截器学习");
        return "login";
    }

    @GetMapping("hello")
    @ResponseBody
    public String getHello(){
        return "访问 /api/hello 接口返回数据";
    }
}
