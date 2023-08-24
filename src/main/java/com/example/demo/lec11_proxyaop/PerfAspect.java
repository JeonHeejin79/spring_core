package com.example.demo.lec11_proxyaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component // 빈으로 등록
@Aspect // Aspect 라고 등록
public class PerfAspect {

    // Advice : 해야할일
    // Pointcut : 어디에 적용할지
    // Join Point : 적용시점
    // target : 적용대상

    // ProceedingJoinPoint target 에있는 메소드를 호출
    @Around("execution(* com.example.demo..*.EventService.*(..))") // Around : 이 advice 를 어떻게 적용할 것인다.
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("logPerf0================");
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }

    @Around("@annotation(PerfLogging)") // annotation 으로 적용하는 방법
    public Object logPerf1(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("logPerf1================");
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }

    @Around("bean(simpleEventService)") // bean 으로 적용하는 방법
    public Object logPerf2(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("logPerf2================");
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }

    @Before("bean(simpleEventService)") // before 로 사용하는 방법 -> 모든 메서드 실행 이전에 메세지가 찍힘
    public void logPerf3() throws Throwable {
        System.out.println("logPerf3================");
    }
}
