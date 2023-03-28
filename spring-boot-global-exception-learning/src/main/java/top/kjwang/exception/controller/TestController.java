package top.kjwang.exception.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import top.kjwang.exception.auth.CheckAuth;
import top.kjwang.exception.entity.Article;
import top.kjwang.exception.service.ArticleService;
import top.kjwang.exception.util.AjaxResponse;


/**
 * @author kjwang
 * @date 2023/3/28 14:50
 * @description TestController
 */
@RestController
@RequestMapping(value = "api")
public class TestController {
    @Resource
    private ArticleService exceptionService;

    @GetMapping("/articles/{id}")
    @CheckAuth(value = "Admin123")
    public AjaxResponse getArticle(@PathVariable("id") int id){
        return AjaxResponse.success(exceptionService.getArticle(id));
    }

    @PostMapping("/articles")
    public AjaxResponse saveArticle(@Valid @RequestBody Article article){
        return AjaxResponse.success(article);
    }
}
