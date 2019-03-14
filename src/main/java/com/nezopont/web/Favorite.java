package com.nezopont.web;

import com.nezopont.MainLayout;
import com.nezopont.entity.Category;
import com.nezopont.service.CategoryService;
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

    @Autowired
   public void setCategoryReposit(CategoryService categoryService){
          this.categoryService=categoryService;
   }


    public Favorite() {
        add(new H2("Kedvencek!"));
        this.grid=new Grid<>(Category.class);
        add( grid);

        grid.setHeight("300px");
        grid.setColumns("id", "name");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);
    }
    @PostConstruct
    void listCustomers() {
            grid.setItems(categoryService.findAllCategory());


    }


}
