package com.dolmac.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링 부트의 자동 설정을 해주며 항상 프로젝트의 최상단에 위치해야함
public class Application { // 앞으로 만들 클래스의 메인 클래스가 될 것
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); //내장 was를 통한 실행
    }
}
