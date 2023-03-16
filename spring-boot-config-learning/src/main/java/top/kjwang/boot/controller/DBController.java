package top.kjwang.boot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kjwang.boot.config.DBConfig;

/**
 * @author kjwang
 * @Date 2023/3/14 16:03
 */

@RestController
@AllArgsConstructor
public class DBController {

    private final DBConfig dbConfig;

    @GetMapping("/show")
    public String show() {
        return dbConfig.configure();
    }



}