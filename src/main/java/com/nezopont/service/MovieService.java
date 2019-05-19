package com.nezopont.service;

import com.nezopont.entity.Movie;
import com.nezopont.repository.MoviesReposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    public MoviesReposit moviesReposit;

    @Autowired
    public void setMoviesReposit(MoviesReposit moviesReposit) {
        this.moviesReposit = moviesReposit;
    }
    public List<Movie> findAllMovies(){
        return moviesReposit.findAll();
    }
    public List<Movie> findAllby(int id){
        return moviesReposit.findAllBy(id);
    }

    public List<Movie> findallBykat(long id){
        return moviesReposit.findAllByKat(id);
    }

    public List<Movie> findallByTitle(String title){
        return moviesReposit.findAllByTitle(title);
    }
    public List<Movie> findallByKorhat(){
        return moviesReposit.findAllByKorhat();
    }
}
