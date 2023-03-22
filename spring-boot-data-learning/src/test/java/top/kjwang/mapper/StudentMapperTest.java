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
        Student student = studentMapper.selectManyToOne(1006);
        assertEquals("周志康", student.getStudentName());
        assertEquals(2, student.getClazz().getClazzId());
        System.out.println(student);
    }

    @Test
    void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Student student = Student.builder().studentId(2000 + i)
                    .clazzId(1).studentName("测试20条" + i)
                    .hometown("南京")
                    .birthday(LocalDate.of(2003, 10, 11))
                    .build();
            students.add(student);
        }
        int count=studentMapper.batchInsert(students);
        System.out.println("新增学生信息，受影响行数：" + count);
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

    @Test
    public void insert(){
        Student student = Student.builder().clazzId(6).studentName("哦哟哟").hometown("南通").birthday(LocalDate.of(2023,3 , 8)).build();
        int count = studentMapper.insert(student);
        System.out.println("新增学生，受影响的行数："+count);
    }

    @Test
    public void update(){
        Student student = studentMapper.findById(1001);
        System.out.println(student);
        student.setClazzId(2);
        student.setStudentName("新名字");
        int count = studentMapper.update(student);
        System.out.println("更新学生信息，受影响的行数："+count);
    }

    @Test
    public void deleteById(){
        int count = studentMapper.deleteById(3097);
        System.out.println("根据id删除学生，受影响的行数；"+count);
    }

    @Test
    public void getStudent(){
        Student student = studentMapper.getStudent(1007);
        System.out.println(student);
    }

    @Test
    void queryById() {
        List<Integer> ids = List.of(1001,1002,1003);
        List<Student> students = studentMapper.queryByIds(ids);
        students.forEach(System.out::println);
    }

    @Test
    void queryLike(){
        Student student = Student.builder().studentName("张智").build();
        List<Student> students = studentMapper.queryLike(student);
        students.forEach(System.out::println);
    }

    @Test
    void getStudentListChoose(){
        // 按照clazzId精确查
//        Student student = Student.builder().clazzId(2).build();
        // 按照姓名模糊查
//        Student student = Student.builder().studentName("张智").build();
        // 按照籍贯模糊查
        Student student = Student.builder().hometown("州").build();
        List<Student> students = studentMapper.getStudentListChoose(student);
        students.forEach(System.out::println);
    }
}