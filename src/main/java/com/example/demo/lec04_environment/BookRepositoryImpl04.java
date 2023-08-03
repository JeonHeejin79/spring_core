package com.example.demo.lec04_environment;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test")
public class BookRepositoryImpl04 implements BookRepository04 {

}
