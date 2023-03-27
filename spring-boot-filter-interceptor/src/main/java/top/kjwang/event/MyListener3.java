package top.kjwang.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * @author kjwang
 * @date 2023/3/27 20:24
 * @description 自定义事件监听器方式3：在application.properties中配置监听
 */

@Slf4j
public class MyListener3 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s 监听到事件源：%s.",MyListener3.class.getName(),event.getSource()));
    }
}
