package com.example.demo.lec03_beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Single {

    // singleton 타입이 prototype 을 쓸떄 문제가된다. 새로 변경되지 않는다.
    @Autowired
    Proto proto;
    public Proto getProto() {
        return proto;
    }
}
