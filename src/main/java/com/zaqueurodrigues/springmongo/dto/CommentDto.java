package com.zaqueurodrigues.springmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDto implements Serializable {
    private static final long serialVersionUID = 2L;

    private String text;
    private Date data;
    private AuthorDto author;

    public CommentDto(){

    }

    public CommentDto(String text, Date data, AuthorDto author) {
        this.text = text;
        this.data = data;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }
}
