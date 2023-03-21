package top.kjwang.mapper;

import top.kjwang.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    /**
     *
     * @param studentId 学生id
     * @return  学生对象
     */
    Student selectManyToOne(int studentId);
    /**
     * 批量新增学生
     */
    int batchInsert(@Param("students")List<Student> students);

}
