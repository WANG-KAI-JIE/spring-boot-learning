package top.kjwang.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author kjwang
 * @date 2023/4/16 13:58
 * @description 文件上传
 */

@RestController
public class FileUploadController {

    @Value("${file.upload-path}")
    private String uploadPath;


    DateFormat df = new SimpleDateFormat("yyyyMMdd");



    @PostMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        // 创建子目录，实现了在 uploadPath 目录中通过日期对上传的文件归类保存
        String format = df.format(new Date());
        File folder = new File(uploadPath + "/" + format);
        if (!folder.isDirectory()) {
            boolean flag = folder.mkdirs();
            System.out.println(flag);
        }

        // 对上传文件重命名，避免冲突
        String oldName = file.getOriginalFilename();
        String newName = null;
        if (oldName != null) {
            newName = UUID.randomUUID() + oldName.substring(oldName.lastIndexOf("."));
        }

        // 上传：文件复制搬运
        file.transferTo(new File(folder, newName));

        // 拼接返回上传后的访问路径
        // http://localhost:8080/20230410/443kajkdsjfkdsjfkdsj.jpg

        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + format + "/" + newName;
    }

}