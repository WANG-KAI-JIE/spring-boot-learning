package top.kjwang.sse.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author kjwang
 * @date 2023/4/17 13:40
 * @description SSE 服务端推送事件demo
 */

@Controller
@Slf4j
@EnableScheduling

public class SseController {

//    @RequestMapping(value = "/sse/msg",method = RequestMethod.GET,produces = "text/event-stream;charset=UTF-8")
//    // 每过1秒执行一次
//    public ResponseBodyEmitter pushMsg(){
//        final SseEmitter emitter = new SseEmitter(0L);
//        try {
//            Thread.sleep(2000);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("emitter push msg...");
//        String msg = "hello sse";
//
//        try{
//            emitter.send(msg, MediaType.TEXT_EVENT_STREAM);
//        } catch (IOException e){
//            throw  new RuntimeException(e);
//        }
//        return emitter;
//    }

    @RequestMapping(value = "/sse/msg",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    @Scheduled(fixedRate = 1000)
    public void updateMsg(){
        final SseEmitter emitter = new SseEmitter(0L);
        Random random =new Random();
        double num  = random.nextDouble(1,1000);
        LocalDateTime time = LocalDateTime.now();
        String msg = time+ "\n" +num;
//        log.info(msg);

        try{
            emitter.send(SseEmitter.event().data(random));
        } catch (IOException e){
            emitter.completeWithError(e);
        }
    }
}
