package top.kjwang.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author kjwang
 * @date 2023/3/27 20:27
 * @description 自定义事件监听器方式4：使用@EventListener装饰具体方法
 */

@Slf4j
@Component
public class MyListener4 {
    @EventListener
    public void listener(MyEvent event) {
        log.info(String.format("%s 监听到事件源：%s.",MyListener4.class.getName(), event.getSource()));
    }
}
