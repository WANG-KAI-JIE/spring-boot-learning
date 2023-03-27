package top.kjwang.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author kjwang
 * @date 2023/3/27 20:19
 * @description 自定义事件监听器方式1：实现ApplicationListener接口
 */
@Slf4j
public class MyListener1 implements ApplicationListener{
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info(String.format("%s 监听到事件源：%s.",MyListener1.class.getName(), event.getSource()));
    }
}
