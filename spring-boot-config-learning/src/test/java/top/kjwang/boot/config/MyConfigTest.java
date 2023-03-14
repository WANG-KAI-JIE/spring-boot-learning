package top.kjwang.boot.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kjwang
 * @Date 2023/3/14 15:02
 */

@SpringBootTest
class MyConfigTest {
    @Autowired
    private MyConfig myConfig;

    @Test
    void myService(){
        myConfig.myService().say();
    }

}