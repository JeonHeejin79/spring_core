package com.example.demo.lec06_eventpublisher;

import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler implements ApplicationListener<MyEvent> {
    @Override
    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Async
    public void onApplicationEvent(MyEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("이벤트를 받았다. 데이터는 " + event.getData());
    }
}
