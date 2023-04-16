package top.kjwang.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.kjwang.entity.User;
import top.kjwang.mapper.UserMapper;

import java.util.List;

/**
 * @author kjwang
 * @date 2023/4/16 18:39
 * @description UserService
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User get(Integer id){
        return userMapper.get(id);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public List<User> findAllByNameLike(String name){
        return userMapper.findAllByNameLike(name);
    }

}