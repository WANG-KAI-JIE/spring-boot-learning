package top.kjwang.boot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.kjwang.boot.config.OssConfig;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kjwang
 * @Date 2023/3/16 15:39
 */

@SpringBootTest
class UploadServiceTest {
    @Autowired
    private OssConfig ossConfig;
    @Test
    void ossUpload() {
    }
}