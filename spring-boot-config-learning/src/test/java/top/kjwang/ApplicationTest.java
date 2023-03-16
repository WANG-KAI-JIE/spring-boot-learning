package top.kjwang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kjwang
 * @Date 2023/3/16 18:43
 */

@SpringBootTest
class ApplicationTest {
    @Autowired
    private ApplicationContext applicationContext;
    @Test
    void iocTest() {
        System.out.println(applicationContext.containsBean("myService"));
    }
}