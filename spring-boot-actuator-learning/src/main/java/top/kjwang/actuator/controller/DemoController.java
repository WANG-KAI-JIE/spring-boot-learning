package top.kjwang.actuator.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kjwang
 * @date 2023/4/18 15:42
 * @description DemoController
 */
@RestController
public class DemoController {
    @Resource
    private MeterRegistry meterRegistry;
    private Counter counter;
    @PostConstruct
    public void init(){
        counter = meterRegistry.counter("demo.request");
    }

    @GetMapping("/demo")
    public String demo(){
        counter.increment();
        return "demo";
    }

}
