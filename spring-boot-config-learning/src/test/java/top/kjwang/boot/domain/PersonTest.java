package top.kjwang.boot.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author kjwang
 * @Date 2023/3/14 14:09
 */

@SpringBootTest
class PersonTest {
    @Autowired
    private Person person;
    @Test
    void testPerson(){
        System.out.println(person);
    }
}