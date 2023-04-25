package com.novelog.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class PostControllerTest {

    //https://stackoverflow.com/questions/73511395/intellij-could-not-autowire-no-beans-of-mockmvc-type-found-but-test-is-ok
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("/posts 요청시 Hello World를 출력한다.")
    void test() throws Exception {
        // 글 제목

        // 글 내용

        //expected
        mockMvc.perform(post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\" : \"글 제목입니다.\", \"content\": \"글 내용입니다.\"}")
                ) // Exception을 던져줘야 함.
                .andExpect(status().isOk())
                .andExpect(content().string("{}"))
                .andDo(print()); // http 요청에 대한 summary 를 남겨줌.

//        // 요즘 잘 안쓰는 방식 (key-value쌍으로 주고 받음)
//        mockMvc.perform(post("/posts").contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                        .param("title", "글 제목입니다.")
//                        .param("content" ,"글 내용입니다.")) // application/json 을 요즘은 content-type 으로 많이 사용함
//                .andExpect(status().isOk())
//                .andExpect(content().string("Hello World"))
//                .andDo(print()); // http 요청에 대한 summary 를 남겨줌.
//        // 그러나 key value 쌍은 데이터의 표현의 한계가 있음
//        // 따라서 요즘에는 json data 통신을 많이 사용함


    }

    @Test
    @DisplayName("/posts 요청시 title 값은 필수이다.")
    void test2() throws Exception {
        // 글 제목

        // 글 내용

        //expected
        mockMvc.perform(post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\" : null, \"content\": \"글 내용입니다.\"}")
                ) // Exception을 던져줘야 함.
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("제목을 입력해주세요")) // jsonPath 에 유요한 검증방법
                .andDo(print()); // http 요청에 대한 summary 를 남겨줌.

    }
}