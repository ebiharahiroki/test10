package com.example.MyBatisDemo.service;

import com.example.MyBatisDemo.entity.Anime_movies;

import java.util.List;

public interface Anime_moviesService {
    List<Anime_movies> findAll();
    Anime_movies findById(int id) throws Exception;
    void createAnime_movies(int id, String title, String published_year);
    void updateAnime_movies(int id, String title, String published_year) throws Exception;
}
