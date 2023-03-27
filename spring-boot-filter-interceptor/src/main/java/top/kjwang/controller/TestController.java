package top.kjwang.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kjwang
 * @date 2023/3/27 20:51
 * @description TestController
 */
@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello(HttpServletRequest request, HttpSession session) {
        //操作 request 的 attribute
        request.setAttribute("a", "a");
        request.setAttribute("a", "b");
        request.getAttribute("a");
        request.removeAttribute("a");

        //操作 session 的 attribute
        session.setAttribute("a", "a");
        session.getAttribute("a");
        session.invalidate();

        return "hello world---";
    }
}