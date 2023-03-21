package top.kjwang.mapper;

import top.kjwang.domain.Clazz;

public interface ClazzMapper {
    /**
     *
     * @param clazzId 班级id
     * @return
     */
    Clazz selectOneToMany(int clazzId);

    /**
     * 单表查询
     * 根据班级id，查询整个班级的信息（班级id，班级名，管理教师名）
     */
    Clazz selectAllByClazzId(int clazzId);

    /**
     *根据班级id查询：关联查询学生信息，所选课程信息
     * @param clazzId 课程id
     * @return 选课信息
     */
    Clazz getClazz(int clazzId);
}
