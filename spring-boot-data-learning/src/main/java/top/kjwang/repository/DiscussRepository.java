package top.kjwang.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import top.kjwang.domain.Discuss;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author kjwang
 * @Date 2023/3/20 14:16
 */
public interface DiscussRepository extends JpaRepository<Discuss,Integer> {
    /**
     * 查询 author 非空的 Discuss 评论集合
     * @return List<Discuss>
     */
    List<Discuss> findByAuthorNotNull();

    // 1.查询author非空的Discuss评论集合
    List<Discuss> findByIdEquals(Integer aId);

    // 2.按照文章 id 分页查询 Discuss 评论集合
    @Query("SELECT c FROM t_comment c WHERE c.AId = ?1 ")
    List<Discuss> getDiscussPage(Integer aid, Pageable pageable);

    // 3.使用原生 SQL语句，根据文章 id 分页查询 Discuss 评论集合
    @Query(value = "SELECT * FROM t_comment WHERE a_Id = ?1 ",nativeQuery = true)
    List<Discuss> getDiscussPaged2(Integer aId,Pageable pageable);

    // 4.根据评论id修改评论作者author
    @Transactional
    @Modifying
    @Query("UPDATE t_comment c SET c.author = ?1 WHERE c.id = ?2 ")
    int updateDiscuss(String author,Integer id);

    // 5.根据评论id删除评论
    @Transactional
    @Modifying
    @Query("DELETE FROM t_comment c WHERE c.id = ?1 ")
    int deleteDiscuss(Integer id);


    List<Discuss> findByAuthorEquals(String author);
}
