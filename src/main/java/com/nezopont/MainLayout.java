package com.nezopont;

import com.nezopont.web.*;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import com.vaadin.flow.theme.Theme;


@Route(value="")
@Theme(MyTheme.class)
public class MainLayout extends Composite<VerticalLayout> implements HasComponents, RouterLayout, BeforeEnterObserver {
    private Div childWrapper = new Div();

    public MainLayout() {
        getContent().setSizeFull();
        HorizontalLayout loginContent = new HorizontalLayout();

        TextField usernameField = new TextField();
        usernameField.setThemeName("username-text");

        loginContent.add(new TextField(""));
        usernameField.addClassName("field");
        PasswordField passwordField = new PasswordField("");
        passwordField.addClassName("field");
        passwordField.setPlaceholder("********");
        loginContent.add(passwordField);

        Button loginButton=new Button("Bejelentkezés");
        loginButton.addClassName("button");
        Button regButton=new Button("Regisztráció");
        regButton.addClassName("button");
        regButton.addClickListener( e-> {
            regButton.getUI().ifPresent(ui -> ui.navigate("registration"));
        });
        loginContent.add(loginButton);
        loginContent.add(regButton);
        loginContent.getStyle().set("margin-left","auto");
        loginContent.setAlignSelf(FlexComponent.Alignment.END);

        add(loginContent);
        H1 header = new H1("NézőPont");
        add(header);

        HorizontalLayout mainContent = new HorizontalLayout();
        VerticalLayout menuBar = new VerticalLayout();

        menuBar.addClassName("menu");
        menuBar.setWidth("15%");
        menuBar.add(new RouterLink("Föoldal", HomeView.class));
        menuBar.add(new RouterLink("Tv műsor", TvPrograms.class));
        menuBar.add(new RouterLink("Kedvencek", Favorite.class));
        menuBar.add(new RouterLink("Kapcsolat", Contact.class));

        mainContent.add(menuBar);
        mainContent.add(childWrapper);
        mainContent.setFlexGrow(1, childWrapper);

        add(mainContent);



        getContent().setFlexGrow(1, mainContent);
        getContent().setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, header);
        getContent().setHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH, mainContent);

    }
    @Override
    public void showRouterLayoutContent(HasElement content) {
        childWrapper.getElement().appendChild(content.getElement());
    }
    @Override
    public void beforeEnter(BeforeEnterEvent event) {

    }
}
