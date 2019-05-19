package com.nezopont.repository;

import com.nezopont.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoviesReposit extends JpaRepository<Movie,Long> {

    @Query(value = "SELECT * FROM MOVIE WHERE tvchanel = ?1", nativeQuery = true)
    List<Movie> findAllBy(int tvchanel);

    @Override
    List<Movie> findAll();


}
