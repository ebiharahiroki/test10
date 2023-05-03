package com.example.MyBatisDemo.controller;

import com.example.MyBatisDemo.entity.Anime_movies;
import com.example.MyBatisDemo.service.Anime_moviesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Anime_moviesController {
    private final Anime_moviesService anime_moviesService;

    public Anime_moviesController(Anime_moviesService anime_moviesService) {
        this.anime_moviesService = anime_moviesService;
    }
    @GetMapping("/anime_movies")
    public List<Anime_moviesResponse> anime_moviesAll() {
        List<Anime_movies> anime_moviesAll = anime_moviesService.findAll();
        List<Anime_moviesResponse> anime_MoviesAllResponse = anime_moviesAll.stream()
                .map(Anime_moviesResponse::new)
                .toList();
        return anime_MoviesAllResponse;
    }
    @GetMapping("/anime_movies/{published_year}")
    public List<Anime_moviesResponse> anime_movies(@PathVariable("published_year") String published_year) {
        List<Anime_movies> anime_movies = anime_moviesService.findByPublishedYear(published_year);
        List<Anime_moviesResponse> anime_MoviesResponse = anime_movies.stream()
                                                        .map(Anime_moviesResponse::new)
                                                        .toList();
        return anime_MoviesResponse;
    }
}
