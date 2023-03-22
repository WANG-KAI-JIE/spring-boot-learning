package top.kjwang.mapper;

import top.kjwang.domain.Teacher;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TeacherMapperTest {
    @Resource
    private TeacherMapper teacherMapper;
    @Test
    void selectOneByOne() {
        System.out.println(teacherMapper.selectOneByOne(1));
    }

    @Test
    void getTeacher(){
        Teacher teacher = teacherMapper.getTeacher(1);
        System.out.println(teacher);
    }
}