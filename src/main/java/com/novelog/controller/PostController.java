package com.novelog.controller;


import com.novelog.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
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

    // 데이터를 검증하는 이유

    // 1. client 개발자가 깜박하고 실수로 값을 안보낼 수 있다.
    // 2. client bug로 값이 누락될 수 있다.
    // 3. 외부에 나쁜 사람이 값을 임의로 조작해서 보낼 수 있다.
    // 4. DB에 값을 저장할 때 의도치 않은 오류가 발생할 수 있다.
    // 5. 검증된 상태의 데이터는 process 의 안정감을 줄 수 있다.

    @PostMapping("/posts")
    public Map<String, String> post(@RequestBody @Valid PostCreate params, BindingResult result) throws Exception { // json 형태로 보낼 때에는 http body 에 정보가 들어있기 때문에 @RequestBody로 받아줘야 한다.
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            FieldError firstFieldError = fieldErrors.get(0);
            String fieldName = firstFieldError.getField();
            String errorMessage = firstFieldError.getDefaultMessage();

            Map<String, String> error = new HashMap<>();
            error.put(fieldName, errorMessage);
            return error;
        }

        return Map.of();

        // 이런 검증 방식이 과연 옳은 방식인가?
        // 수십가지의 if문을 통해 일일이 다 검증하는 방법은 효율적이지 못함.
//        String title = params.getTitle();
//        if (title == null || title.equals("")){
//             throw new Exception("타이틀 값이 없습니다.");
//        }
    }
}
