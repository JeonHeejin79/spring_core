package com.example.demo.lec05_messagesource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

//@Component
public class AppRunner05 implements ApplicationRunner {

    @Autowired
    MessageSource messageSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while(true) {
            System.out.println(messageSource.getMessage("greeting", new String[]{"keesun"}, Locale.KOREA));
            System.out.println(messageSource.getMessage("greeting", new String[]{"keesun"}, Locale.getDefault()));
            Thread.sleep(1000);
        }
    }
}
