package com.doomsday.roadtodoomsday.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doomsday.roadtodoomsday.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findByTitle(String title);
}