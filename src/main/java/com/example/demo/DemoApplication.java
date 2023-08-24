package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@PropertySource("classpath:/app.properties")
@EnableAsync
public class DemoApplication {

    public static void main(String[] args) {
        /** static method 를 사용하는 방법 */
        // SpringApplication.run(DemoApplication.class, args);

        /** 인스턴스를 만들어서 사용하는 방법 */
        //var app = new SpringApplication(DemoApplication.class);
        //app.addInitializers((ApplicationContextInitializer<GenericApplicationContext>) ctx -> {
        //    // 빈 등록
        //    ctx.registerBean(MyService.class);
        //    ctx.registerBean(ApplicationRunner.class, () ->
        //            (ApplicationRunner) args1 -> System.out.println("Funtional Bean Definition!!"));
        //});
        //app.run(args);

        /** 스프링 어플리케이션을 웹어플리케이션이아닌 메인 메서드 실행 하듯이 서버모드가 아닌상태로 띄우는 방법 */
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

    @Bean
    public MessageSource messageSource() {
        var messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3); // 3초 까지만 캐싱하고 다시 읽도록 설정.
        return messageSource;
    }

}
