package com.dolmac.springboot.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 json을 반환하는 컨트롤러로 변환해줌
public class HelloController {
    @GetMapping("/hello") //get method 요청을 받을 수 있는 api
    public String hello(){
        return "hello";
    }// 이제 이 프로젝트는 /hello로 요청이 오면 hello를 반환해줄 것

}
