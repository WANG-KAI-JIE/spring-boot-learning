package top.kjwang.boot.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.kjwang.boot.config.OssConfig;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author kjwang
 * @Date 2023/3/16 12:37
 */

//加了@Service就出来了
@Service
public class UploadService {
    //这边加了@@Autowired，并改成private OssConfig ossConfig;，就好了
    @Autowired
    private OssConfig ossConfig;
    public String ossUpload(MultipartFile file){
        String endpoint = ossConfig.getEndpoint();
        String accessKeyId = ossConfig.getAk();
        String accessKeySecret = ossConfig.getSecret();
        String bucket = ossConfig.getBucket();
        String dir = ossConfig.getDir();
        String host = ossConfig.getHost();

        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
        // 上传后文件的服务器路径
        String uploadPath = dir + file.getOriginalFilename();
        // 获得上下文的字节输入流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        // 调用SDK上传对象到指定的bucket的指定路径
        ossClient.putObject(bucket,uploadPath,inputStream);
        // 关闭OSSClient
        ossClient.shutdown();
        // 返回完整上传后的url
        return host + uploadPath;
    }
}
