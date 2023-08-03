package com.example.demo.lec06_eventpublisher;

import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AnotherHandler {

    @EventListener
    @Order(Ordered.HIGHEST_PRECEDENCE + 2)
    @Async // 비동기 이벤트 실행 ORDER 은 의미가 없게 된다.
    public void handle(MyEventAfter event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("Another 이벤트를 받았다. 데이터는 " + event.getData());
    }
}
