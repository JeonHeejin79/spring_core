package com.example.demo.lec09_databinding;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

// 상태 정보 없음 == Stateless == 스레드세이프
// ConverterRegistry 에 등록해서 사용
public class EventConverter {

    //@Component
    public static class StringToEventConverter implements Converter<String, EventNew> {
        @Override
        public EventNew convert(String source) {
            return new EventNew(Integer.parseInt(source));
        }
    }

    //@Component
    public static class EventToStringConverter implements Converter<EventNew, String> {
        @Override
        public String convert(EventNew source) {
            return source.getId().toString();
        }
    }
}
