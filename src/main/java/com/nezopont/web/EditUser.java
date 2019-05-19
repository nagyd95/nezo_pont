package com.nezopont.web;

import com.nezopont.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.web.bind.annotation.RestController;

@Route(value="edit", layout = MainLayout.class)
@RouteAlias(value="ed", layout = MainLayout.class)
@PageTitle("Szerkesztés")
@SpringComponent
@RestController
public class EditUser extends Composite<VerticalLayout> implements HasComponents {
    public EditUser() {
        add(new H2("Profil szerkesztése"));
        add(new Label("Hamarosan...."));
    }
}
