package com.nezopont.web;

import com.nezopont.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value="favorite", layout = MainLayout.class)
@RouteAlias(value="fa", layout = MainLayout.class)
@PageTitle("Kedvencek")
public class Favorite extends Composite<VerticalLayout> implements HasComponents {
    public Favorite() {
        add(new H2("Kedvencek!"));
    }
}
