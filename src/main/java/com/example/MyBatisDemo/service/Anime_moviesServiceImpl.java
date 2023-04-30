package com.example.MyBatisDemo.service;

import com.example.MyBatisDemo.entity.Anime_movies;
import com.example.MyBatisDemo.mapper.Anime_moviesMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Anime_moviesServiceImpl implements Anime_moviesService {
    private Anime_moviesMapper anime_moviesMapper;
    public Anime_moviesServiceImpl(Anime_moviesMapper anime_moviesMapper) {
        this.anime_moviesMapper = anime_moviesMapper;
    }
    @Override
    public List<Anime_movies> findAll() {
        return anime_moviesMapper.findAll();
    }
    @Override
    public Anime_movies findById(int id) {
        return anime_moviesMapper.findById(id);
    }
    @Override
    public void createAnime_movies(int id, String title, String published_year) {

    }
    @Override
    public void updateAnime_movies(int id, String title, String published_year) {

    }

}
