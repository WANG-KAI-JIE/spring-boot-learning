package top.kjwang.mapper;

import top.kjwang.domain.Teacher;

public interface TeacherMapper {
    /**
     * 一对一查询
     * @param teacherId 教师id
     * @return 教师对象
     */
    Teacher selectOneByOne(int teacherId);
}
