package com.example.demo.lec09_databinding;

import java.beans.PropertyEditorSupport;

// 프로퍼티 에디터는 절대 빈으로 등록해서 사용하면안된다.
// statelessful 하다. 스레드에서 상태를 공유한다. 스레드 세이프 하지 않다.
// 한 스레드 내에서만 유효한 스콥으로 정의해서 쓰거나 빈으로 등록하면 안된다.
// 다른 스레드와 공유되면 안된다. 빈으로 등록되지 않는게 안전하다.
// 컨트롤러에 @InitBinder 를 사용해서 등록해야한다.
public class EventEditor extends PropertyEditorSupport {

    // 객체르 받아서 String 으로 변환
    @Override
    public String getAsText() {
        Event event = (Event) getValue();
        return event.getId().toString();
    }

    // 문자열을 받아서 다른 객체로 변환
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Event(Integer.parseInt(text)));
    }
}
