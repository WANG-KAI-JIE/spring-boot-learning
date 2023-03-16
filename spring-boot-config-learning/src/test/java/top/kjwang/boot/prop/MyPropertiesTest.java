package top.kjwang.boot.prop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kjwang
 * @Date 2023/3/16 18:38
 */
@SpringBootTest
class MyPropertiesTest {
    @Autowired
    private MyProperties myProperties;

    @Test
    void testMyProperties() {
        System.out.println(myProperties);
    }
}