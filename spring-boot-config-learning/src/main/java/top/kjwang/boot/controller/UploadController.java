package top.kjwang.boot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.kjwang.boot.service.UploadService;

/**
 * @author kjwang
 * @Date 2023/3/16 12:49
 */

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UploadController {
    private final UploadService uploadService;
    @PostMapping("/upload")
    public String uploadFile(MultipartFile file){
        return uploadService.ossUpload(file);
    }
}
