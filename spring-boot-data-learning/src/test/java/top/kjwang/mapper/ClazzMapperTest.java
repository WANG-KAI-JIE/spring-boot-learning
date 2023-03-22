package top.kjwang.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ClazzMapperTest {
    @Resource
    private ClazzMapper clazzMapper;
    @Test
    void selectOneToMany() {
        System.out.println(clazzMapper.selectOneToMany(1));
    }

    @Test
    void selectAllByClazzId(){
        System.out.println(clazzMapper.selectAllByClazzId(1));
    }

    @Test
    void getClazz() {
        System.out.println(clazzMapper.getClazz(1));
    }
}