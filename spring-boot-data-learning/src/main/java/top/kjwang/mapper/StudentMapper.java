package top.kjwang.mapper;

import org.apache.ibatis.annotations.Select;
import top.kjwang.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    /**
     * @param studentId 学生id
     * @return  学生对象
     */
    Student selectManyToOne(int studentId);
    /**
     * 批量新增学生
     */
    int batchInsert(@Param("students")List<Student> students);

    /**
     * 批量更新学生信息
     * @param students
     * @return
     */
    int batchUpdate(@Param("students")List<Student> students);

    /**
     * 批量删除学生
     * @param idList 待删除的学生id集合
     * @return 受影响的记录行数
     */
    int batchDelete(@Param("idList") List<Integer> idList);

    /**
     * @param student 查询对象
     * @return 查询到的学生集合
     */
    List<Student> dynamicSelect(Student student);

    /**
     * 单表查询
     * 根据学生id，查询学生的所有信息（学生id，班级id，学生姓名，家乡，生日）
     * mqxu提示了一下，说可以用注解写，可以简单点
     */

    /**
     * 根据主键查询学生信息
     * @param studentId 学生id
     * @return 学生对象
     */
    @Select("SELECT * FROM t_student WHERE student_id = #{studentId}")
    Student findById(int studentId);

}
