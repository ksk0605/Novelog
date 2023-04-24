package com.novelog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// @Controller 이걸 사용해도 괜찮지만 RestController에도 포함되어있기때문에 더 기능이 많은 RestController 를 사용
@RestController
public class PostController {
    // SSR - JSP, thymeleaf, mustache ... -> server HTML Rendering
    // SPA -
    // vue, nuxt
    // react, next

    // GET, POST, PUT, PATCH, CONNECT, DELETE, OPTIONS, HEAD, TRACE

    //이전에 많이 사용하던 방식
    //@RequestMapping(method= RequestMethod.GET, path = "v1/posts")
    @GetMapping("/posts")
    public String get() { // cmd shift t -> test파일 생성
        return "Hello World";
    }
}
