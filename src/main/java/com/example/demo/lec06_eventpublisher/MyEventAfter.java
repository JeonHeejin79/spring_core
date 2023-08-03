package com.example.demo.lec06_eventpublisher;


// spring 4.2 이전 -> ApplicationEvent 을 상속받아야함
// spring 4.2 이후 -> 이런 제약사항이 사라짐 ApplicationEvent 상속 불필요
// 비 침투성 transparent
// 스프링 코드가 노출되지 않는 것 : POJO 기반의 프로그래밍
// 코드가 테스트될떄 더 편하고 유지보수가 쉬워진다.
public class MyEventAfter {

    private int data;
    private Object source;

    public MyEventAfter(Object source, int data) {
        this.source = source;
        this.data = data;
    }

    public Object getSource() {
        return source;
    }

    public int getData() {
        return data;
    }
}