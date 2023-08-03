package com.example.demo.lec01_autowired;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository myBookRepository;

    @PostConstruct // bean 인스턴스가 만들어진 다음에 부가적인 작업을 한다.
    public void setUp() {
        System.out.println("myBookRepository.getClass() = " + myBookRepository.getClass());
    }

}
