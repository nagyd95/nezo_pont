package com.nezopont.repository;

import com.nezopont.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoviesReposit extends JpaRepository<Movie,Long> {

    @Query(value = "SELECT * FROM MOVIE WHERE tvchanel = ?1", nativeQuery = true)
    List<Movie> findAllBy(int tvchanel);

    @Query(value = "SELECT * FROM MOVIE m,MOVIE_CATEGORIES mc where mc.MOVIE_ID =m.id and mc.CATEGORY_ID =?1", nativeQuery = true)
    List<Movie> findAllByKat(long catid);

    @Query(value = "SELECT * FROM MOVIE where title LIKE %?1%", nativeQuery = true)
    List<Movie> findAllByTitle(String title);

    @Query(value = "SELECT * FROM MOVIE where age_Limit=18", nativeQuery = true)
    List<Movie> findAllByKorhat();

    @Override
    List<Movie> findAll();


}
