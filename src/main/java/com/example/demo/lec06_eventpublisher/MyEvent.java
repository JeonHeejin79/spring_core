package com.example.demo.lec06_eventpublisher;

import org.springframework.context.ApplicationEvent;

// spring 4.2 이전 -> ApplicationEvent 을 상속받아야함
// spring 4.2 이후 -> 이런 제약사항이 사라짐 ApplicationEvent 상속 불필요
public class MyEvent extends ApplicationEvent {

    private int data;

    public MyEvent(Object source) {
        super(source);
    }

    public MyEvent(Object source, int data) {
        super(source);
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
