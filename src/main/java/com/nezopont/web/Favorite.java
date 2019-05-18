package com.nezopont.web;

import com.nezopont.MainLayout;
import com.nezopont.entity.Category;
import com.nezopont.entity.Movie;
import com.nezopont.service.CategoryService;
import com.nezopont.service.MovieService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
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

    public ComboBox<Category> categoryComboBox;
    public TextField nameTextField;
    public Checkbox isForChildren;
    public HorizontalLayout filterLayout;
    public CategoryService categoryService;
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

        categoryComboBox = new ComboBox<>("Válassz kategóriát!");
        nameTextField = new TextField("Név");
        TextField dateTextField = new TextField("Kiadás");
        isForChildren = new Checkbox("-18");
        //TODO: slider for imdb rating, datepicker for date
        filterLayout = new HorizontalLayout(categoryComboBox, nameTextField, dateTextField, isForChildren);
        add(filterLayout);

        this.movieGrid=new Grid<>(Movie.class);
        add(movieGrid);

        movieGrid.setHeight("300px");
        movieGrid.setColumns("id", "title","imdb","ageLimit","date","categories");
    }
    @PostConstruct
    void listCustomers() {
            categoryComboBox.setItemLabelGenerator(Category::getName);
            categoryComboBox.setItems(categoryService.findAllCategory());
            movieGrid.setItems(movieService.findAllMovies());
    }



}
