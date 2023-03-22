package top.kjwang.mapper;

import top.kjwang.domain.Teacher;

public interface TeacherMapper {

    Teacher selectOneByOne(int teacherId);

    /**
     * 关联查询教师信息
     * @param teacherId 教师id
     * @return 教师对象
     */
    Teacher getTeacher(int teacherId);
}
