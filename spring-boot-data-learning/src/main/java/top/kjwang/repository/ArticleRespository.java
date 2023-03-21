package top.kjwang.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.kjwang.domain.Article;
import top.kjwang.domain.Discuss;

import java.util.List;
import java.util.Optional;

/**
 * @author kjwang
 * @Date 2023/3/20 20:24
 */
public interface ArticleRespository extends JpaRepository<Article,Integer> {
//    @Query(value = "SELECT * FROM t_article WHERE id = ?1",nativeQuery = true)
//    List<Article> gteArticlePage(Integer id, Pageable pageable);

    List<Article> findAll();
//    Optional<Article> findById(Integer id);
}
