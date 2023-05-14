package com.example.MyBatisDemo.service;

import com.example.MyBatisDemo.entity.Anime_movies;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface Anime_moviesService {
    List<Anime_movies> findAll();
    Anime_movies findById(int id);
    Anime_movies findByPublishedYear(String published_year);

    Anime_movies create(Anime_movies conversionAnime_movies, BindingResult bindingResult);
    void update(int id, Anime_movies conversionAnime_movies, BindingResult bindingResult);
    void delete(int id);
}
