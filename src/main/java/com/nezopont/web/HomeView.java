package com.nezopont.web;

import com.nezopont.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.VaadinSession;

@Route(value="fooldal", layout = MainLayout.class)
@RouteAlias(value="fo", layout = MainLayout.class)
@PageTitle("Főoldal")
public class HomeView extends Composite<VerticalLayout> implements HasComponents {
    public HomeView() {


        add(new H2("Föoldal!"));
        if(VaadinSession.getCurrent().getAttribute("userL") != null) {
            System.out.println("Bent vagy admin");
        }
        if(VaadinSession.getCurrent().getAttribute("userL") == null) {
            System.out.println("nem vagy admin");
        }
    }
}
