package com.example.demo.lec04_environment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfiguration {
    @Bean
    public BookRepository04 bookRepository04() {
        return new BookRepositoryImpl04();
    }
}
