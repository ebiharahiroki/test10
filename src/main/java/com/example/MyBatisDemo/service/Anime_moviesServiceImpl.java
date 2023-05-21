package com.example.MyBatisDemo.service;

import com.example.MyBatisDemo.entity.Anime_movies;
import com.example.MyBatisDemo.exception_handler.BadRequestException;
import com.example.MyBatisDemo.exception_handler.ResourceNotFoundException;
import com.example.MyBatisDemo.mapper.Anime_moviesMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

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
    public Anime_movies findByPublishedYear(String published_year) {
        return this.anime_moviesMapper.findByPublishedYear(published_year)
                .orElseThrow(() -> new ResourceNotFoundException("resource not found"));
    }
    @Override
    public Anime_movies findById(int id) {
        return this.anime_moviesMapper.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("resource not found"));
    }
    @Override
    public Anime_movies create(Anime_movies conversionAnime_movies, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException("bad request");
        }
        anime_moviesMapper.create(conversionAnime_movies);
        return conversionAnime_movies;
    }
    @Override
    public void update(int id, Anime_movies conversionAnime_movies, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException("bad request");
        }
        Anime_moviesMapper.update(id, conversionAnime_movies);
    }
    @Override
    public void delete(int id) {
        Anime_moviesMapper.delete(id);
    }
}
