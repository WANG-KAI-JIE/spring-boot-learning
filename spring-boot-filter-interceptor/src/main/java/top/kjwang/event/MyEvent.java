package top.kjwang.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author kjwang
 * @date 2023/3/27 20:17
 * @description MyEvent 自定义事件：继承ApplicationEvent抽象类，并定义自己的构造器
 */
public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source){
        super(source);
    }
}
