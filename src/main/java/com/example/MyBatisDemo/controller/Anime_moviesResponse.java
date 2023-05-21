package com.example.MyBatisDemo.controller;

import com.example.MyBatisDemo.entity.Anime_movies;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;


public class Anime_moviesResponse {
    @NotBlank(message = "Nullもしくは空白文字です。")
    @Length(min = 1, max = 100, message = "100文字以内で入力してください。")
    private String title;

    public Anime_moviesResponse(Anime_movies title) {
        this.title = title.getTitle();
    }
    public String getTitle() {
        return title;
    }
}
