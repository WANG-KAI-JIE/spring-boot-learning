package top.kjwang.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kjwang
 * @date 2023/4/16 19:18
 * @description RedisCacheServiceTest
 */

@SpringBootTest
@Slf4j
class RedisCacheServiceTest {
    @Resource
    private RedisCacheService redisCacheService;

    @Test
    void getName() {
        redisCacheService.getName(1);
        redisCacheService.getName(1);
        redisCacheService.getName(1);
    }

    @Test
    public void getUser() {
        redisCacheService.getUser(1);
        redisCacheService.getUser(1);
        redisCacheService.getUser(1);
    }

    @Test
    public void test1() throws Exception {
        redisCacheService.getName(1);
    }

    @Test
    public void test2() throws Exception {
        redisCacheService.getUser(1);
    }
}