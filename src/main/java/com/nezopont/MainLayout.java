package com.nezopont;

import com.nezopont.entity.User;
import com.nezopont.service.UserService;
import com.nezopont.web.*;
import com.nezopont.web.DTO.LogindDTO;
import com.vaadin.flow.component.*;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.*;
import org.springframework.security.core.Authentication;


import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;


@Route(value="")
public class MainLayout extends Composite<VerticalLayout> implements HasComponents, RouterLayout, BeforeEnterObserver {
    private Div childWrapper = new Div();

    private User currentUser;
   
    public MainLayout() {
        getContent().setSizeFull();

        if(VaadinSession.getCurrent().getAttribute("userL") ==null){
            HorizontalLayout loginContent = new HorizontalLayout();
            Button loginButton = new Button("Bejelentkezés");
            Button regButton = new Button("Regisztráció");
            loginButton.addClickListener(e -> {
                loginButton.getUI().ifPresent(ui -> ui.navigate("login"));



            });


            regButton.addClickListener(e -> {
                regButton.getUI().ifPresent(ui -> ui.navigate("registration"));
            });
            loginContent.add(loginButton);
            loginContent.add(regButton);
            loginContent.setAlignItems(FlexComponent.Alignment.CENTER);
            add(loginContent);
        }else{

            HorizontalLayout loginContent = new HorizontalLayout();
            Button kijelentkezes = new Button("Kijelentkezés");
            loginContent.add(kijelentkezes);
            add(loginContent);
            kijelentkezes.addClickListener(e -> {
                VaadinSession.getCurrent().getSession().invalidate();
                kijelentkezes.getUI().ifPresent(ui -> ui.navigate("fooldal"));
            });
        }
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

    private User authenticate(String username, String password) throws Exception{
        User user = new User("username", "password");

        if(user.equals(null)){
            throw new Exception("Login failed");
        }else{
            return user;
        }

    }



}
