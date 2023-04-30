package com.example.MyBatisDemo.controller;

import com.example.MyBatisDemo.entity.Anime_movies;

public class Anime_moviesResponse {
    private String title;

    public Anime_moviesResponse(Anime_movies title) {
        this.title = title.getTitle();
    }
    public String getTitle() {
        return title;
    }
}
