package com.example.demo.lec04_environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
public class AppRunner04 implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    BookRepository04 bookRepository04;

    @Value("${app.name}")
    String appName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Environment environment = ctx.getEnvironment();
        System.out.println("getActiveProfiles : " + Arrays.toString(environment.getActiveProfiles()));
        System.out.println("getDefaultProfiles : " + Arrays.toString(environment.getDefaultProfiles()));

        String property = environment.getProperty("app.name");
        String property1 = environment.getProperty("app.about");
        System.out.println("app.name vm option = " + property);
        System.out.println("app.about properties option = " + property1);

        System.out.println("properties value = " + appName);
    }
}
