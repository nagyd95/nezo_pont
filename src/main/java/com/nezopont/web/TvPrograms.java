package com.nezopont.web;

import com.nezopont.MainLayout;
import com.nezopont.entity.Category;
import com.nezopont.entity.Movie;
import com.nezopont.entity.TvChanels;
import com.nezopont.service.MovieService;
import com.nezopont.service.TvChanelService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Route(value="tvprograms", layout = MainLayout.class)
@RouteAlias(value="tv", layout = MainLayout.class)
@PageTitle("Tv Műsor")
public class TvPrograms extends Composite<VerticalLayout> implements HasComponents {
    public ComboBox<TvChanels> categoryComboBox;
    public HorizontalLayout filterLayout;
    public TvChanelService tvChanelService;
    public Grid<Movie> movieGrid;
    public MovieService movieService;
    private int id;
    @Autowired
    public void setMovieService(TvChanelService tvChanelService) {
        this.tvChanelService = tvChanelService;
    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }




    public TvPrograms() {
        add(new H2("Csatornák"));
        categoryComboBox = new ComboBox<>("Válassz csatornát!");
        filterLayout = new HorizontalLayout(categoryComboBox);
        add(filterLayout);


        this.movieGrid=new Grid<>(Movie.class);
        add(movieGrid);
        movieGrid.setHeight("300px");
        movieGrid.setColumns("title","imdb","date","categories");
    }

    @PostConstruct
    void listCustomers() {
        categoryComboBox.setItemLabelGenerator(TvChanels::getName);
        categoryComboBox.setItems(tvChanelService.findAllChanel());
        categoryComboBox.addValueChangeListener(event -> {
            if (event.getSource().isEmpty()) {

            } else {

                movieGrid.setItems(movieService.findAllby(categoryComboBox.getValue().getId()));

            }
        });

    }



}
