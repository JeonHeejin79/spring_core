package com.example.demo.lec09_databinding;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 이 레지스트리에 등록된 컨버터가 모든 컨트롤러에 동작한다.
        registry.addConverter(new EventConverter.StringToEventConverter());
    }
}
