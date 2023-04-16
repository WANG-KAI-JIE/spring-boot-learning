package top.kjwang.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Select;
import top.kjwang.entity.User;

import java.util.List;

/**
 * @author kjwang
 * @date 2023/4/16 18:38
 * @description UserMapper
 */
public interface UserMapper {

    @Select("SELECT * FROM tb_user WHERE id = #{value}")
    User get(Integer id);

    @Select("SELECT * FROM tb_user ")
    List<User> findAll();

    @Select("SELECT * FROM tb_user WHERE name LIKE concat('%', #{name}, '%')")
    List<User> findAllByNameLike(@Param("name") String name);

    @Update("UPDATE tb_user SET name = #{name} WHERE id = #{id}")
    void updateById(User user);
}