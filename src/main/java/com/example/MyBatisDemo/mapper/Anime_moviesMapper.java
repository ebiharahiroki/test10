package com.example.MyBatisDemo.mapper;

import com.example.MyBatisDemo.entity.Anime_movies;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface Anime_moviesMapper {
    List<Anime_movies> findAll();
    Optional<Anime_movies> findById(int id);
    Optional<Anime_movies> findByPublishedYear(String published_year);
    int create(Anime_movies conversionAnime_movies);

    void update(int id, Anime_movies conversionAnime_movies);

    void delete(int id);
}
