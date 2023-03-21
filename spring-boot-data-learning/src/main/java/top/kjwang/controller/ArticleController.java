package top.kjwang.controller;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.kjwang.domain.Article;
import top.kjwang.repository.ArticleRespository;

import java.util.List;
import java.util.Optional;

/**
 * @author kjwang
 * @Date 2023/3/20 20:21
 */

@Controller
@AllArgsConstructor
public class ArticleController {
    @Resource
    private final ArticleRespository articleRespository;
    @GetMapping("index")
    public String indexPage(ModelMap map) {
        map.put("articleList", articleRespository.findAll());
        return "index";
    }
    @GetMapping("detail")
    public String articleDetail(@RequestParam(value = "id" ,required = false) Integer id,ModelMap map){
        Optional<Article> articleOptional = articleRespository.findById(id);
        articleOptional.ifPresent(article -> map.put("article", article));
        return "detail";
    }
}
