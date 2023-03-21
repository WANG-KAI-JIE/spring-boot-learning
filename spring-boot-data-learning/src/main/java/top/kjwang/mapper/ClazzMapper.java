package top.kjwang.mapper;

import top.kjwang.domain.Clazz;

public interface ClazzMapper {
    /**
     *
     * @param clazzId 班级id
     * @return
     */
    Clazz selectOneToMany(int clazzId);
}
