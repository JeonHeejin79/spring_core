package com.example.demo.lec09_databinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component // 스레드 세이프 하다. 빈으로 등록해서 사용 가능하다.
public class EventFormatter implements Formatter<EventNew> {

//    @Autowired
//    MessageSource messageSource;

    @Override
    public EventNew parse(String text, Locale locale) throws ParseException {
        return new EventNew(Integer.parseInt(text));
    }

    @Override
    public String print(EventNew object, Locale locale) {
        // messageSource.getMessage("title", locale);
        return object.getId().toString();
    }
}
