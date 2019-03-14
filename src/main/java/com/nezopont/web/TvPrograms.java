package com.nezopont.web;

import com.nezopont.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value="tvprograms", layout = MainLayout.class)
@RouteAlias(value="tv", layout = MainLayout.class)
@PageTitle("Tv Műsor")
public class TvPrograms extends Composite<VerticalLayout> implements HasComponents {

}
