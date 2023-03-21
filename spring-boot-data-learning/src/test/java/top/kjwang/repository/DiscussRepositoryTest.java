package top.kjwang.repository;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import top.kjwang.domain.Discuss;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

/**
 * @author kjwang
 * @Date 2023/3/20 15:04
 */
@SpringBootTest
class DiscussRepositoryTest {

    @Resource
    private DiscussRepository discussRepository;

    @Test
    void findByAuthorNotNull(){
        List<Discuss> list = discussRepository.findByAuthorNotNull();
        list.forEach(System.out::println);
    }

    @Test
    void findByIdEquals() {
        List<Discuss> list = discussRepository.findByIdEquals(1);
        list.forEach(System.out::println);
    }

    @Test
    void findByAuthorLike(){
        List<Discuss> list = discussRepository.findByAuthorEquals("张三");
        list.forEach(System.out::println);
    }

    @Test
    public void selectCommentPaged(){
        Pageable pageable = PageRequest.of(0,3);
        List<Discuss> allPaged = discussRepository.getDiscussPage(1,pageable);
        System.out.println(allPaged);
    }

    @Test
    public void selectCommentByExample(){
        Discuss discuss = new Discuss();
        discuss.setAuthor("张三");
        Example<Discuss> example = Example.of(discuss);
        List<Discuss> list = discussRepository.findAll(example);
        System.out.println(list);
    }

    @Test
    public void selectCommentByExampleMatcher(){
        Discuss discuss = new Discuss();
        discuss.setAuthor("张");
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("author",startsWith());
        Example<Discuss> example = Example.of(discuss,matcher);
        List<Discuss> list = discussRepository.findAll(example);
        System.out.println(list);
    }
}