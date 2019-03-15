package com.nezopont.web;

import com.nezopont.MainLayout;
import com.nezopont.service.UserService;
import com.nezopont.web.DTO.UserRegistrationDTO;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
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
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Route(value="registration", layout = MainLayout.class)
@RouteAlias(value="reg", layout = MainLayout.class)
@PageTitle("Regisztráció")
@SpringComponent
@RestController
public class RegistrationView extends Composite<VerticalLayout> implements HasComponents{
    public UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public RegistrationView() {
        add(new H1("Regisztráció"));
        FormLayout layoutWithBinder = new FormLayout();
        TextField firstName = new TextField();
        firstName.setValueChangeMode(ValueChangeMode.EAGER);
        TextField lastName = new TextField();
        lastName.setValueChangeMode(ValueChangeMode.EAGER);

        TextField email = new TextField();
        email.setValueChangeMode(ValueChangeMode.EAGER);
        TextField emailAgain = new TextField();
        email.setValueChangeMode(ValueChangeMode.EAGER);
        PasswordField password=new PasswordField();
        password.setValueChangeMode(ValueChangeMode.EAGER);
        PasswordField passwordAgain=new PasswordField();
        password.setValueChangeMode(ValueChangeMode.EAGER);
        Label infoLabel = new Label();
        Button save = new Button("Mentés");
        Button reset = new Button("Törlés");

        layoutWithBinder.addFormItem(firstName, "Vezetéknév");
        layoutWithBinder.addFormItem(lastName, "Keresztnév");

        layoutWithBinder.addFormItem(email, "E-mail");
        layoutWithBinder.addFormItem(emailAgain, "E-mail újra");

        layoutWithBinder.addFormItem(password,"Jelszó");
        layoutWithBinder.addFormItem(passwordAgain,"Jelszó ujra");


        HorizontalLayout actions = new HorizontalLayout();
        actions.add(save, reset);
        save.getStyle().set("marginRight", "10px");
        add(layoutWithBinder);
        add(actions);
        reset.addClickListener(event -> {
            email.setValue("");
            emailAgain.setValue("");
            firstName.setValue("");
            lastName.setValue("");
            infoLabel.setText("");
            password.setValue("");
            passwordAgain.setValue("");
        });
        save.addClickListener(event->{
            //Megnézni minden kivan e töltve, email validacio,password BCryptPasswordEncoder majd mentés
            UserRegistrationDTO user=new UserRegistrationDTO(firstName.getValue(),lastName.getValue(),email.getValue(),emailAgain.getValue(),password.getValue(),passwordAgain.getValue());
            userService.save(user);
            email.setValue("");
            emailAgain.setValue("");
            firstName.setValue("");
            lastName.setValue("");
            infoLabel.setText("");
            password.setValue("");
            passwordAgain.setValue("");
        });
    }

}
