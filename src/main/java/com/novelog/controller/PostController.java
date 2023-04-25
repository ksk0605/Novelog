package com.novelog.controller;


import com.novelog.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j// 롬복사용
// @Controller 이걸 사용해도 괜찮지만 RestController에도 포함되어있기때문에 더 기능이 많은 RestController 를 사용
@RestController
public class PostController {
    // SSR - JSP, thymeleaf, mustache ... -> server HTML Rendering
    // SPA -
    // vue, nuxt
    // react, next

    // GET, POST, PUT, PATCH, CONNECT, DELETE, OPTIONS, HEAD, TRACE

//    //이전에 많이 사용하던 방식
//    //@RequestMapping(method= RequestMethod.GET, path = "v1/posts")
//    @GetMapping("/posts")
//    public String get() { // cmd shift t -> test파일 생성
//        return "Hello World";
//    }

    @PostMapping("/posts")
    public String post(@RequestBody PostCreate params) { // json 형태로 보낼 때에는 http body 에 정보가 들어있기 때문에 @RequestBody로 받아줘야 한다.
        log.info("params={}", params.toString());
        return "Hello World";
    }
}
