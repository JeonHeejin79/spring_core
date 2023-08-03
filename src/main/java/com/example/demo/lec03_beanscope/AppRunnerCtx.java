package com.example.demo.lec03_beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//@Component
public class AppRunnerCtx implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("proto");
        System.out.println(ctx.getBean(Proto.class));
        System.out.println(ctx.getBean(Proto.class));
        System.out.println(ctx.getBean(Proto.class));

        System.out.println("single");
        System.out.println(ctx.getBean(Single.class));
        System.out.println(ctx.getBean(Single.class));
        System.out.println(ctx.getBean(Single.class));

        // 바뀌지 않는다. 같은 객체가 발생한다. proxyMode = ScopedProxyMode.TARGET_CLASS 로 설정 하면 해결 가능하다.
        //  ScopedProxyMode.TARGET_CLASS : JDK 동적 프록시 기반
        //  ScopedProxyMode.INTERFACE : CGLIB 프록시 기반
        // proxyMode = ScopedProxyMode.TARGET_CLASS : 클래스기반의 프록시로 감싼다.
        System.out.println("proto by single");
        System.out.println(ctx.getBean(Single.class).getProto());
        System.out.println(ctx.getBean(Single.class).getProto());
        System.out.println(ctx.getBean(Single.class).getProto());
    }
}
