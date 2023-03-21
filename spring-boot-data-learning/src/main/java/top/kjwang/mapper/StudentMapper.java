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

}
