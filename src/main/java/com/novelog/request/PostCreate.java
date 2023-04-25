package com.novelog.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString // toString 메서드 사용하지 않아도 됌
public class PostCreate {
    @NotBlank(message="제목을 입력해주세요") // null 혹은 빈 문자열인지 등등을 자동으로 검증해줌
    public String title;
    @NotBlank(message = "내용을 입력해주세요")
    public String content;

//    // key - value 데이터를 주입해줄 setter 함수 필요
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getContent() {
//        return content;
//    }

    //
//    // cmd + N
//    @Override
//    public String toString() {
//        return "PostCreate{" +
//                "title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }
}
