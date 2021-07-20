package com.dolmac.springboot.web;


import com.dolmac.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 json을 반환하는 컨트롤러로 변환해줌
public class HelloController {
    @GetMapping("/hello") //get method 요청을 받을 수 있는 api
    public String hello(){
        return "hello";
    }// 이제 이 프로젝트는 /hello로 요청이 오면 hello를 반환해줄 것
    @GetMapping("/hello/dto") //HelloResponseDto 를 get 해서 사용
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
