package com.doomsday.roadtodoomsday.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doomsday.roadtodoomsday.model.Movie;
import com.doomsday.roadtodoomsday.repository.MovieRepository;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
public Movie getMovieById(@PathVariable Long id) {

    return movieRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Movie not found"));
}

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }


    @PutMapping("/{id}")
public Movie updateMovie(
        @PathVariable Long id,
        @RequestBody Movie updatedMovie) {

    Movie movie = movieRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Movie not found"));

    movie.setTitle(updatedMovie.getTitle());
    movie.setReleaseDate(updatedMovie.getReleaseDate());
    movie.setPhase(updatedMovie.getPhase());
    movie.setDescription(updatedMovie.getDescription());
    movie.setPosterUrl(updatedMovie.getPosterUrl());
    movie.setTrailerUrl(updatedMovie.getTrailerUrl());
    movie.setImportance(updatedMovie.getImportance());
    movie.setWatched(updatedMovie.isWatched());

    return movieRepository.save(movie);
}
}