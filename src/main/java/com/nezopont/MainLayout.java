package com.nezopont;

import com.nezopont.web.*;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import org.springframework.security.core.Authentication;


@Route(value="")
public class MainLayout extends Composite<VerticalLayout> implements HasComponents, RouterLayout, BeforeEnterObserver {
    private Div childWrapper = new Div();

    public static Authentication AUTH;


    public MainLayout() {
        getContent().setSizeFull();
        HorizontalLayout loginContent = new HorizontalLayout();
        TextField usernameField = new TextField();
        usernameField.setThemeName("username-text");

        loginContent.add(new TextField(""));

        PasswordField passwordField = new PasswordField("");
        passwordField.setPlaceholder("********");
        loginContent.add(passwordField);

        Button loginButton=new Button("Bejelentkezés");

        Button regButton=new Button("Regisztráció");
        regButton.addClickListener( e-> {
            regButton.getUI().ifPresent(ui -> ui.navigate("registration"));
        });
        loginContent.add(loginButton);
        loginButton.addClickListener( e-> {
            if(AUTH.authenticate(usernameField.getValue(), passwordField.getValue())){
            //if(usernameField.getValue() != null && passwordField.getValue() != null) {
              //  getApplication().setUser(newUser);
                loginButton.getUI().ifPresent(ui -> ui.navigate("fooldal"));
            }
        });
        loginContent.add(regButton);
        loginContent.setAlignItems(FlexComponent.Alignment.CENTER);
        add(loginContent);
        H1 header = new H1("NézőPont");
        add(header);

        HorizontalLayout mainContent = new HorizontalLayout();
        VerticalLayout menuBar = new VerticalLayout();


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
