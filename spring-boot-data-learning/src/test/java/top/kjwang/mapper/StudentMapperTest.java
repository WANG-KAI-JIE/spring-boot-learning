package top.kjwang.mapper;

import top.kjwang.domain.Student;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentMapperTest {

    @Resource
    private StudentMapper studentMapper;

    @Test
    void selectManyToOne() {
        Student student = studentMapper.selectManyToOne(1001);
        assertEquals("钱智康", student.getStudentName());
        assertEquals(1, student.getClazz().getClazzId());
    }

    @Test
    void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Student student = Student.builder().studentId(3000 + i)
                    .clazzId(1).studentName("测试学生" + i)
                    .hometown("南京")
                    .birthday(LocalDate.of(2003, 10, 11))
                    .build();
            students.add(student);
        }
        int count=studentMapper.batchInsert(students);
        System.out.println(count);
    }

    @Test
    void batchUpdate() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Student student = Student.builder().studentId(3000 + i).clazzId(1).studentName("新名字" + i).hometown("苏州").build();
            students.add(student);
        }
        int count = studentMapper.batchUpdate(students);
        System.out.println(count);
    }

    @Test
    void batchDelete() {
        List<Integer> idList = List.of(3000,3001,3002,3003);
        int count = studentMapper.batchDelete(idList);
        System.out.println(count);
    }

    @Test
    void dynamicSelect() {
        Student student = Student.builder().hometown("州").build();
        List<Student> students = studentMapper.dynamicSelect(student);
        students.forEach(s -> {
            System.out.println(s.getClazzId() + ',' +s.getStudentName() + ',' +s.getHometown() + ',' +s.getBirthday());
        });
    }

    @Test
    public void findById(){
        System.out.println(studentMapper.findById(1003));
    }
}