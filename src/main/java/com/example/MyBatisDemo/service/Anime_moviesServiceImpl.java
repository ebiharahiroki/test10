package com.example.MyBatisDemo.service;

import com.example.MyBatisDemo.entity.Anime_movies;
import com.example.MyBatisDemo.mapper.Anime_moviesMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Anime_moviesServiceImpl implements Anime_moviesService {
    final private Anime_moviesMapper anime_moviesMapper;
    public Anime_moviesServiceImpl(Anime_moviesMapper anime_moviesMapper) {
        this.anime_moviesMapper = anime_moviesMapper;
    }
    @Override
    public List<Anime_movies> findAll() {
        return anime_moviesMapper.findAll();
    }
    @Override
    public List<Anime_movies> findByPublishedYear(String published_year) {
        return anime_moviesMapper.findByPublishedYear(published_year);
    }
}
