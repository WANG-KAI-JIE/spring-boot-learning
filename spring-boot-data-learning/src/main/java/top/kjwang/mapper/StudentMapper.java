package top.kjwang.mapper;

import org.apache.ibatis.annotations.*;
import top.kjwang.domain.Student;

import java.util.List;

public interface StudentMapper {
    /**
     * @param studentId 学生id
     * @return  学生对象
     */
    Student selectManyToOne(int studentId);
    /**
     * 批量新增学生
     * @param students 待新增的学生对象集合
     * @return 受影响的记录行数
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
     * mqxu提示了一下，说单表的可以用注解写，可以简单点,就不用xml里写语句了
     */

    /**
     * 根据主键查询学生信息
     * @param studentId 学生id
     * @return 学生对象
     */
    @Select("SELECT * FROM t_student WHERE student_id = #{studentId}")
    Student findById(int studentId);

    /**
     * 新增学生
     *
     * @param student 学生对象
     * @return 受影响的记录行数
     */
    @Insert("INSERT INTO t_student (clazz_id,student_name,hometown,birthday) VALUES (#{clazzId}, #{studentName}, #{hometown}, #{birthday})")
    int insert(Student student);

    /**
     * 修改学生信息
     * @param student 待修改的学生对象
     * @return 受影响的记录行数
     */
    @Update("UPDATE t_student SET clazz_id = #{clazzId}, student_name = #{studentName},hometown = #{hometown}, birthday = #{birthday} WHERE student_id = #{studentId}")
    int update(Student student);

    /**
     * 根据id删除学生
     * @param studentId
     * @return 受影响的记录行数
     */
    @Delete("DELETE FROM t_student WHERE student_id = #{studentId}")
    int deleteById(int studentId);


    /**
     * 根据学生id查询学生信息：关联查询其所属班级信息，所选课程信息
     *
     * @param studentId 学生id
     * @return 学生对象
     */
    Student getStudent(int studentId);

    List<Student> queryByIds(List<Integer> studentIds);

    List<Student> queryLike(Student student);

    List<Student> getStudentListChoose(Student student);

    int createStudentAutoKey(Student student);

    List<Student> getStudentListLikeName(String name);

    List<Student> getStudentListIf(Student student);

    int updateStudentIfSet(Student student);

    List<Student> getStudentListIfTrim(Student student);

    int updateStudentIfTrim(Student student);

    List<Student> getStudentListByIdsArray(Integer[] studentIds);

    List<Student> getStudentListByIdsList(List<Integer> studentIdList);
}
