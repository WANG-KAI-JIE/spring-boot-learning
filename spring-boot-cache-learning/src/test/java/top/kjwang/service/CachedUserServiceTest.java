package top.kjwang.service;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.kjwang.entity.User;
/**
 * @author kjwang
 * @date 2023/4/16 18:47
 * @description CachedUserServiceTest
 */


@SpringBootTest
@Slf4j
class CachedUserServiceTest {

    @Resource
    private UserService userService;

    @Resource
    private CachedUserService cachedUserService;

    @Test
    public void test1() {
        User user1 = userService.get(1);
        User user2 = userService.get(1);
        log.info(String.valueOf(user1 == user2));
    }

    @Test
    public void test2() {
        User user1 = cachedUserService.get(1);
        User user2 = cachedUserService.get(1);
        log.info(String.valueOf(user1 == user2));
    }

}