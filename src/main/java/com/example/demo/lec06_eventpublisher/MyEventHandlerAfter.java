package com.example.demo.lec06_eventpublisher;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandlerAfter {

    @EventListener
    public void onApplicationEventAfter(MyEventAfter event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("AFTER 이벤트를 받았다. 데이터는 " + event.getData());
    }

    @EventListener
    @Async
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextRefreshedEvent");
        var applicationContext = event.getApplicationContext();

        System.out.println("applicationContext = " + applicationContext);
    }

    @EventListener
    @Async
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextClosedEvent");
        var applicationContext = event.getApplicationContext();
        System.out.println("applicationContext = " + applicationContext);
    }
}
