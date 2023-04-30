package com.example.MyBatisDemo.entity;

public class Anime_movies {
    private int id;
    private String title;
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
