package top.kjwang.boot.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.kjwang.boot.entity.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author kjwang
 * @date 2023/3/23 08:49
 * @description UserMapperTest
 */

@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void insert() {
        // 增加一条记录
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        user.setEmail("zhangsan@baomidou.com");

        int row = userMapper.insert(user);

        System.out.println("影响记录数：" + row);
        System.out.println("雪花算法id: " + user.getId());
    }

    @Test
    void deleteById() {
        // 根据主键删除一条记录
        int rows = userMapper.deleteById(1638705291207938050L);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    void deleteByCondition() {
        // 根据条件删除记录
        //构造条件
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 18);
        //执行删除
        int rows = userMapper.deleteByMap(map);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    void selectById() {
        // 根据主键查询一条数据
        User user = userMapper.selectById(1638705943204106241L);
        System.out.println(user);
    }

    @Test
    void selectBatch() {
        // 根据 ids 批量查找数据
        List<Long> ids = Arrays.asList(
                1638706109143355393L,
                1638705943204106241L
        );
        List<User> list = userMapper.selectBatchIds(ids);
        list.forEach(System.out::println);
    }

    @Test
    void selectByMap() {
        // 根据指定参数查询
        Map<String, Object> map = new HashMap<>();
        //map的key指代的是mysql表中的列名，并非java实体的属性名
        map.put("name", "张三");
        List<User> list = userMapper.selectByMap(map);
        list.forEach(System.out::println);
    }

    @Test
    void selectList() {
        // 查询指定结果字段 1
        QueryWrapper<User> query = new QueryWrapper<>();
        query.select("name", "age")   //指定查询结果字段
                .in("age", Arrays.asList(18,19))
                .last("limit 1");
        List<User> list = userMapper.selectList(query);
        list.forEach(System.out::println);
    }

    @Test
    void selectMaps() {
        // 查询指定结果字段 2
        QueryWrapper<User> query = new QueryWrapper<>();
        query.like("name", "J%")    //like是MP的条件构造器，表示"模糊查询"
                .lt("age", 22)     //lt是MP的条件构造器，表示"小于"关系
                .select("name", "age");
        List<Map<String, Object>> maps = userMapper.selectMaps(query);
        maps.forEach(System.out::println);
    }

    @Test
    void updateById() {
        // 通过主键id修改数据
        User user = new User();
        user.setId(1638705943204106241L);
        user.setAge(18);
        user.setEmail("hadoopcn2@163.com");

        int rows = userMapper.updateById(user);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    void update() {
        // 根据UpdateWrapper自定义条件修改数据
        UpdateWrapper<User> update = new UpdateWrapper<>();
        update.eq("name", "Jack").eq("age", 20);    //eq是MP的条件构造器，表示"等于"关系

        User user = new User();
        user.setAge(29);
        user.setEmail("hadoopcn2@163.com");
        int rows = userMapper.update(user, update);
        System.out.println("影响记录数：" + rows);
    }
}
