package com.nezopont.web;

import com.nezopont.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value="contact", layout = MainLayout.class)
@RouteAlias(value="co", layout = MainLayout.class)
@PageTitle("Kapcsolat")
public class Contact extends Composite<VerticalLayout> implements HasComponents {

}
