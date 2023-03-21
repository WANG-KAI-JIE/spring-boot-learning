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
     * 根据班级id，输出整个班级的信息（班级id，班级名，管理教师名）
     */
    Clazz selectAllByClazzId(int clazzId);
}
