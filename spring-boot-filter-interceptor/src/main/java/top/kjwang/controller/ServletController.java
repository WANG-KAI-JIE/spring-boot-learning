package top.kjwang.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author kjwang
 * @date 2023/3/27 14:52
 * @description ServletController
 */

@RestController
@RequestMapping(value = "api")
public class ServletController {

    @GetMapping("request")
    public void testRequest(){
        // 建议按照一下方法获取 Servlet 的请求和响应
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        request.setAttribute("author","kjwang");
        request.setAttribute("author","哦哟哟");
        request.removeAttribute("author");
    }
}
