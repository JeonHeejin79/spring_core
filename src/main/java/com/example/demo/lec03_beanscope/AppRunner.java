package com.example.demo.lec03_beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    Single single;

    @Autowired
    Proto proto;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(proto);
        System.out.println(single.getProto());
        System.out.println(single);
    }
}
