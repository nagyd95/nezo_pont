package com.nezopont.repository;

import com.nezopont.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviesReposit extends JpaRepository<Movie,Long> {
    @Override
    List<Movie> findAll();
}
