package top.kjwang.jobs;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.time.LocalDateTime;

import static java.lang.Thread.sleep;

/**
 * @author kjwang
 * @date 2023/4/4 14:59
 * @description 定时任务作业
 */

@Slf4j
@Component
public class ScheduledJobs {

//    方法执行完 5秒 后继续执行
//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayJob() throws InterruptedException{
//        log.info("fixedDelay 开始： --->" + LocalDateTime.now());
//        sleep(10 * 1000);
//        log.info("fixedDelay 结束： --->" + LocalDateTime.now());
//    }



    // 每隔 10秒 执行一次
//    @Scheduled(fixedRate = 10000)
//    public void fixedRateJob() throws InterruptedException{
//        log.info("fixedRate 开始： --->" + LocalDateTime.now());
//        sleep(5 * 1000);
//        log.info("fixedRate 结束： --->" + LocalDateTime.now());
//    }


//     每隔 10秒 执行一次
//    @Scheduled(cron = "0/10 * * * * ?")
//    public void cronJob(){
//        log.info("cronJob： --->" + LocalDateTime.now());
//    }


    // 假装过生日，定时任务，打印“生日快乐”
//    @Scheduled(cron = "0 25 15 4 4 ?")
//    public void cronJobTest(){
//        log.info("生日快乐！");
//    }

    // 每隔 5秒生成一个二维码
//    @Scheduled(fixedRate = 5000)
//    public void cronJob() {
//        QrCodeUtil.generate("你好👋，很高兴😄认识你。", 300, 300, FileUtil.file("/Users/wangkaijie/Desktop/qr.jpg"));
//        log.info("生成二维码成功"+String.valueOf(LocalDateTime.now()));
//    }

}
