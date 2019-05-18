package com.nezopont.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double imdb;
    private int ageLimit;
    private Date date;
    private int start;
    private int end;
    private String imgPath;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "MOVIE_CATEGORIES",
            joinColumns = @JoinColumn(
                    name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "category_id", referencedColumnName = "id"))
    private Collection<Category> categories = new ArrayList<>();

    public Movie() {
    }

    public Movie(String title, double imdb, int ageLimit, Date date, int start, int end, String imgPath, List<Category> categories) {
        this.title = title;
        this.imdb = imdb;
        this.ageLimit = ageLimit;
        this.date = date;
        this.start = start;
        this.end = end;
        this.imgPath = imgPath;
        this.categories = categories;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getCategories() {

        return categories.toString();
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imdb=" + imdb +
                ", ageLimit=" + ageLimit +
                ", start=" + start +
                ", end=" + end +
                ", imgPath='" + imgPath + '\'' +
                ", categories=" + categories +
                '}';
    }
}
