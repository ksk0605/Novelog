package com.novelog.request;

public class PostCreate {
    public String title;
    public String content;

    // key - value 데이터를 주입해줄 setter 함수 필요
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // cmd + N
    @Override
    public String toString() {
        return "PostCreate{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
