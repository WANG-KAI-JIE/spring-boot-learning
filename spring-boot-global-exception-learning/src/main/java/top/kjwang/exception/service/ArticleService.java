package top.kjwang.exception.service;

import org.springframework.stereotype.Service;
import top.kjwang.exception.entity.Article;
import top.kjwang.exception.enums.CustomExceptionType;
import top.kjwang.exception.exception.CustomException;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author kjwang
 * @date 2023/3/28 14:29
 * @description 通用异常处理逻辑
 */
@Service
public class ArticleService {
    /**
     * 服务层，模拟未认证异常
     */
    public void authError(){
        throw new CustomException(CustomExceptionType.UNAUTHORIZED_ERROR);
    }


    /**
     * 服务器，模拟参数异常
     * @param id 入参
     */
    public Article getArticle(int id){
        // 模拟业务校验失败逻辑
        if (id <= 0){
            throw new CustomException(CustomExceptionType.PARAM_ERROR);
        }
        return findArticleById(id);
    }

    public Article findArticleById(int id){
        List<Article> articles = List.of(
                new Article(1,"Spring 从入门到精通","大佬","spring@qq.com", LocalDateTime.of(2023,3,20,12,12,12)),
                new Article(2,"Spring Boot 从入门到精通","大牛","springboot@qq.com", LocalDateTime.of(2023,3,21,12,12,12)),
                new Article(3,"Spring Cloud 从入门到精通","大神","springcloud@qq.com", LocalDateTime.of(2023,3,22,12,12,12))
        );
        return articles.stream().filter(article -> article.getId() == id).toList().get(0);
    }
}
