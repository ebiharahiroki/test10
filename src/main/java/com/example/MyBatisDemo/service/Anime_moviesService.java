package com.example.MyBatisDemo.service;

import com.example.MyBatisDemo.entity.Anime_movies;

import java.util.List;

public interface Anime_moviesService {
    List<Anime_movies> findAll();
    List<Anime_movies> findByPublishedYear(String published_year);

}
