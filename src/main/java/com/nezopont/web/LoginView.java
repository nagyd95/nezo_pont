package com.nezopont.web;

import com.nezopont.MainLayout;
import com.nezopont.service.UserService;
import com.nezopont.web.DTO.LogindDTO;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Route(value="login", layout = MainLayout.class)
@RouteAlias(value="log", layout = MainLayout.class)
@PageTitle("Bejelentkezes")
@SpringComponent
@RestController
public class LoginView extends Composite<VerticalLayout> implements HasComponents {
    public UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public LoginView() {
        add(new H1("Bejelentkezés"));
        FormLayout layoutWithBinder = new FormLayout();
        TextField email = new TextField();
        email.setValueChangeMode(ValueChangeMode.EAGER);
        PasswordField pass = new PasswordField();
        pass.setValueChangeMode(ValueChangeMode.EAGER);

        Button login = new Button("Bejelentkezés");
        Label infoLabel = new Label("");
        layoutWithBinder.addFormItem(email, "Email ");
        layoutWithBinder.addFormItem(pass, "Jelszó");
        layoutWithBinder.addFormItem(infoLabel,"");

        HorizontalLayout actions = new HorizontalLayout();
        actions.add(login);
        login.getStyle().set("marginRight", "10px");
        add(layoutWithBinder);
        add(actions);

        login.addClickListener(event->{
            LogindDTO log=new LogindDTO(email.getValue(),pass.getValue());
            if(!log.empty()) {
                if(log.getEmail().equals("admin") && log.getPassword().equals("admin")){
                    VaadinSession.getCurrent().setAttribute("userL", "admin");
                    UI.getCurrent().getPage().executeJavaScript("window.location.href='fooldal'");
                }else{
                    infoLabel.setText("Hibás adatok!");
                }
            }else{

                infoLabel.setText("Üres mezö!");
            }
        });
    }
}
