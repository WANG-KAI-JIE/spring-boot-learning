package top.kjwang.log.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kjwang
 * @date 2023/3/29 10:41
 * @description LogTestController
 */

@RestController
public class LogTestController {
    private static final Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @GetMapping("/testlog")
    public void test(){
        logger.trace("Trace 日志...");
        logger.debug("Debug 日志...");
        logger.info("Info 日志...");
        logger.warn("Warn 日志...");
        logger.error("Error 日志...");
    }
}