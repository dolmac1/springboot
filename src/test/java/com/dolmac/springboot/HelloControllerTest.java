package com.dolmac.springboot;


import com.dolmac.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;
@RunWith(SpringRunner.class) // 실행자를 스프링 부트로 바꾸겠다.
@WebMvcTest(controllers = HelloController.class) //스프링 테스트 어노테이션 선언
public class HelloControllerTest {
    @Autowired //스프링이 관리하는 빈(bean)을 주입받음
    private MockMvc mvc;//웹 api를 테스트할 때 사용

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))//MockMvc를 통해 /hello를 get요청
                .andExpect(status().isOk())//mvc.perform의 결과를 검증해서 상태가 200인가
                .andExpect(content().string(hello));//리턴하는 값이 string type의 hello가 맞는지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "dolmac";
        int amount = 1000;
        mvc.perform(get("/hello/dto").param("name",name).param("amount",String.valueOf(amount)))//param 은 파라미터 지정(단 string만 가능해서 변환)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))//선언된 필드와 받아온 필드가 값이 같은지 비교
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}
