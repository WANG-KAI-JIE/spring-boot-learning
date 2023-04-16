package top.kjwang.utils;

import io.minio.ObjectWriteResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author kjwang
 * @date 2023/4/16 16:56
 * @description MinIoTest
 */

@SpringBootTest
class MinIoTest {

    @Resource
    private MinIoTemplate minIoTemplate;

    //测试创建bucket
    @Test
    void testCreateBucket() throws Exception {
        minIoTemplate.makeBucket("hello");
    }

    //测试上传文件对象
    @Test
    void testPutObject() throws Exception {
        ObjectWriteResponse response = minIoTemplate.putObject("hello",
                "images/banner.jpg",
                "/Users/wangkaijie/Desktop/upload/cat.png");
        System.out.println(response.object());
    }

    //测试删除文件对象
    @Test
    void testDeleteObject() throws Exception {
        minIoTemplate.removeObject("hello",
                "images/banner.jpg");
    }
}
