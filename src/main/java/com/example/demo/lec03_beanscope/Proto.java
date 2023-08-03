package com.example.demo.lec03_beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Proto {

    // proto type 이 singleton 타입을 쓰면 상관없다. 그러나 그반대의 경우는 문제가된다.
    @Autowired
    Single single;
}
