package com.nezopont.web;

import com.nezopont.MainLayout;
import com.nezopont.entity.Category;
import com.nezopont.entity.Movie;
import com.nezopont.service.CategoryService;
import com.nezopont.service.MovieService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Route(value="favorite", layout = MainLayout.class)
@RouteAlias(value="fa", layout = MainLayout.class)
@PageTitle("Kedvencek")
@RestController
@SpringComponent
public class Favorite extends Composite<VerticalLayout> implements HasComponents {

    public CategoryService categoryService;
    public Grid<Category> grid;
    public Grid<Movie> movieGrid;
    public MovieService movieService;
    @Autowired
   public void setCategoryReposit(CategoryService categoryService){
          this.categoryService=categoryService;
   }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    public Favorite() {
        add(new H2("Kedvencek!"));
        this.movieGrid=new Grid<>(Movie.class);
        this.grid=new Grid<>(Category.class);
        add( grid);
        add(movieGrid);

        grid.setHeight("300px");
        grid.setColumns("id", "name");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);
        movieGrid.setHeight("300px");
        movieGrid.setColumns("id", "title","imdb","ageLimit","date","categories");
        grid.getColumnByKey("id").setWidth("10px").setFlexGrow(0);
    }
    @PostConstruct
    void listCustomers() {
            grid.setItems(categoryService.findAllCategory());
            movieGrid.setItems(movieService.findAllMovies());

    }



}
