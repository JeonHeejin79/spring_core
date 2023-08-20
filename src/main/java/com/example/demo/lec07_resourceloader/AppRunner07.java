package com.example.demo.lec07_resourceloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

// @Component
public class AppRunner07 implements ApplicationRunner {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:test.txt");

        System.out.println("resource.exists() = " + resource.exists());

        String description = resource.getDescription();
        System.out.println("description = " + description);

        String contents = Files.readString(Path.of(resource.getURI()));
        System.out.println("contents = " + contents);

        // Resource 자체를 추상화 -
        // 기존 URL 클래스가 classpath 로 가져오는 기능이 없음
        // ServletContext 를 기준으로 상대 경로로 읽어오는 기능 부재

        // class path 경로 기준으로 resource 를 찾는다.
        // ClassPathResource 로 resolving 을 한다.
        //var ctx = new ClassPathXmlApplicationContext("test.xml");

        // 파일 시스템 경로 기준으로 resource 를 찾는다.
        // FileSystemResource 로 resolving 을 한다.
        //var ctx2 = new FileSystemXmlApplicationContext("test.xml");

        // 되도록이면 classpath 접두어를 붙이는게 좋다.
        // 그냥 리소스 이름만 적으면 ServletContextResource 로 resolving 이 된다.
        System.out.println(resourceLoader.getClassLoader());
        Resource resourceClassPath = resourceLoader.getResource("classpath:test.txt");
        System.out.println(resourceClassPath.getClass());
        Resource resourceFile = resourceLoader.getResource("file://test.txt");
        System.out.println(resourceFile.getClass());
    }
}
