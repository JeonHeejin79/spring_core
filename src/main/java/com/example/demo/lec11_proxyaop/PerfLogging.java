package com.example.demo.lec11_proxyaop;

import java.lang.annotation.*;

// 이 애노테이션 정보를 얼마나 유지할것인가 (클래스 파일까지 유지하겟다.)
// RetentionPolicy.CLASS - 기본값이 CLASS 이다.
// RetentionPolicy.SOURCE - 컴파일하고나서 사라진다. 이걸로 변경하면 안됨
// RetentionPolicy.RUNTIME - 구지 RUNTIME까지 유지할 필요는 없다.
/**
 * 이 애노테이션을 사용하면 성능을 로깅해 줍니다.
 * */
@Documented // java doc 만들떄 dacumentation 이 될 수 있도록 함
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS) // retention 에대해서 잘모르는 팀원이 만다면 명시해주는것도 나쁘지 않다.
public @interface PerfLogging {

}
