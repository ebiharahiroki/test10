package com.example.MyBatisDemo.controller;

import com.example.MyBatisDemo.entity.Anime_movies;
import com.example.MyBatisDemo.exception_handler.BadRequestException;
import com.example.MyBatisDemo.exception_handler.ResourceNotFoundException;
import com.example.MyBatisDemo.service.Anime_moviesService;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class Anime_moviesController {
    private final Anime_moviesService anime_moviesService;

    public Anime_moviesController(Anime_moviesService anime_moviesService) {
        this.anime_moviesService = anime_moviesService;
    }
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFound(
            ResourceNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Map<String, String>> handleBadRequest(
            BadRequestException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.BAD_REQUEST.value()),
                "error", HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/anime_moviesAll")
    public List<Anime_moviesResponse> getAnime_moviesAll() {
        List<Anime_movies> anime_moviesAll = anime_moviesService.findAll();
        List<Anime_moviesResponse> anime_MoviesAllResponse = anime_moviesAll.stream()
                                                            .map(Anime_moviesResponse::new)
                                                            .toList();
        return anime_MoviesAllResponse;
    }
    @GetMapping("/anime_movies")
    public List<Anime_moviesResponse> getAnime_moviesByPublished_year(@RequestParam(value = "published_year") String published_year) {
        Optional<Anime_movies> anime_movies = Optional.ofNullable(anime_moviesService.findByPublishedYear(published_year));
        List<Anime_moviesResponse> anime_MoviesResponse = anime_movies.stream()
                                                        .map(Anime_moviesResponse::new)
                                                        .toList();
        return anime_MoviesResponse;
    }
    @GetMapping("/anime_movies")
    public List<Anime_moviesResponse> getAnime_moviesById(@RequestParam(value = "id") int id) {
        Optional<Anime_movies> anime_movies = Optional.ofNullable(anime_moviesService.findById(id));
        List<Anime_moviesResponse> anime_MoviesResponse = anime_movies.stream()
                .map(Anime_moviesResponse::new)
                .toList();
        return anime_MoviesResponse;
    }
    @PostMapping("/anime_movies")
    public ResponseEntity<Map<String, String>> createAnime_movies(@RequestBody @Validated Anime_movies NewAnime_movies, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {
        ModelMapper modelMapper = new ModelMapper();
        Anime_movies conversionAnime_movies = modelMapper.map(NewAnime_movies, Anime_movies.class);
        Anime_movies anime_movies = Anime_moviesService.create(conversionAnime_movies, bindingResult);
        URI url = uriComponentsBuilder.path("/anime_movies/" + anime_movies.getId())
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "NewAnime_movies successfully create"));
    }
    @PatchMapping("/anime_movies/{id}")
    public ResponseEntity<Map<String, String>> patchAnime_movies(@PathVariable("id")int id, @RequestBody @Validated Anime_movies NewAnime_movies, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {
        ModelMapper modelMapper = new ModelMapper();
        Anime_movies conversionAnime_movies = modelMapper.map(NewAnime_movies, Anime_movies.class);
        Anime_moviesService.update(id, conversionAnime_movies, bindingResult);
        URI url = uriComponentsBuilder.path("/anime_movies/" + conversionAnime_movies.getPublished_year())
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "the anime_movie successfully update"));
    }
    @DeleteMapping("/anime_movies/{id}")
    public ResponseEntity<Map<String, String>> deleteAnime_movies(@PathVariable("id")int id) {
        Anime_moviesService.delete(id);
        return ResponseEntity.ok(Map.of("message", "the anime_movie successfully delete"));
    }
}
