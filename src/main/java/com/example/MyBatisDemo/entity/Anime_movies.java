package com.example.MyBatisDemo.entity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class Anime_movies {
    private int id;
    @NotBlank(message = "Nullもしくは空白文字です。")
    @Length(min = 1, max = 100, message = "100文字以内で入力してください。")
    private String title;
    @NotBlank(message = "Nullもしくは空白文字です。")
    @Length(min = 1, max = 4, message = "4文字以内で入力してください。")
    private String published_year;

    public Anime_movies(int id, String title, String published_year) {
        this.id = id; this.title = title; this.published_year = published_year;
    }
    public int getId() {
        return id;
    }
    public String getPublished_year() {
        return published_year;
    }
    public String getTitle() {
        return title;
    }
}
