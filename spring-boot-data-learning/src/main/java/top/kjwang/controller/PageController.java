package top.kjwang.controller;

/**
 * @author kjwang
 * @Date 2023/3/20 19:53
 */

import top.kjwang.domain.Discuss;
import top.kjwang.repository.DiscussRepository;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PageController {
    @Resource
    private DiscussRepository discussRepository;
    @GetMapping("/showpage")
    public List<Discuss> getDiscuss(){
        PageRequest pageable= PageRequest.of(0,3);
        List<Discuss> list=discussRepository.getDiscussPage(1,pageable);
        return list;
    }
}