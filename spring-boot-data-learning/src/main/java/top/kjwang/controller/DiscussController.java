package top.kjwang.controller;

import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import top.kjwang.domain.Discuss;
import top.kjwang.repository.DiscussRepository;

import java.util.List;

/**
 * @author kjwang
 * @Date 2023/3/20 15:58
 */
@Controller
public class DiscussController {
    @Resource
    private DiscussRepository discussRepository;
    @GetMapping("/")
    public String getDiscuss(ModelMap map){
        Pageable pageable = PageRequest.of(0,3);
        // 第0页，放三个用户的数据
        List<Discuss> list = discussRepository.getDiscussPage(1,pageable);
        map.put("discussList",list);
        map.put("title","hello world");
        return "index.html";
    }
}
