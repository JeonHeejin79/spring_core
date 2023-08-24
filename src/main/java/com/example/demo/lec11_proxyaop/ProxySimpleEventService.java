package com.example.demo.lec11_proxyaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// @Primary // 같은 타입의 빈이 여러가지 있을때 그중에 한가지를 선택하는 방법
// @Service
public class ProxySimpleEventService implements EventService {

    @Autowired
    SimpleEventService simpleEventService; // real subject

    @Override
    public void createEvent() {
        long begin  = System.currentTimeMillis();
        simpleEventService.createEvent();
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void publishEvent() {
        long begin  = System.currentTimeMillis();
        simpleEventService.publishEvent();
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void deleteEvent() {
        simpleEventService.deleteEvent();
    }
}
