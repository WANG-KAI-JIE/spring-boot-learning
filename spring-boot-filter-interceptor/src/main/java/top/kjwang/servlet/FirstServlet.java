package top.kjwang.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author kjwang
 * @date 2023/3/27 15:25
 * @description FirstServlet
 */

@WebServlet(name = "firstServlet", urlPatterns = "/firstServlet")
@Slf4j
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("firstServlet");
        resp.getWriter().append("firstServlet");
    }

}