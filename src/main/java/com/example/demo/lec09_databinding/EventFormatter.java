package com.example.demo.lec09_databinding;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class EventFormatter implements Formatter<EventNew> {
    @Override
    public EventNew parse(String text, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(EventNew object, Locale locale) {
        return null;
    }
}
