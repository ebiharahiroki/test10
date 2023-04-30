package com.example.MyBatisDemo.mapper;

import com.example.MyBatisDemo.entity.Anime_movies;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Anime_moviesMapper {
    @Select("SELECT * FROM anime_movies")
    List<Anime_movies> findAll();git inti
    @Select("SELECT * FROM anime_movies WHERE id = #{id}")
    Anime_movies findById(int id);
}
