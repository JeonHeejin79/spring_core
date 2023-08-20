package com.example.demo.lec08_validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Component
public class ApRunner08New implements ApplicationRunner {

    @Autowired
    Validator validator;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(validator.getClass());

        EventNew event = new EventNew();
        event.setLimit(-1);
        event.setEmail("aaaa2");

        Errors errors = new BeanPropertyBindingResult(event, "eventNew");

        validator.validate(event, errors);

        System.out.println(errors.hasErrors());

        errors.getAllErrors().forEach(v -> {
            System.out.println("===== error code =====");
            Arrays.stream(v.getCodes()).forEach(System.out::println);
            System.out.println(v.getDefaultMessage());
        });
    }
}
