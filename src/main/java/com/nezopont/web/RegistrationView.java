package com.nezopont.web;

import com.nezopont.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value="registration", layout = MainLayout.class)
@RouteAlias(value="reg", layout = MainLayout.class)
@PageTitle("Regisztráció")
public class RegistrationView extends Composite<VerticalLayout> implements HasComponents{

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
            //Megnézni minden kivan e töltve, email validacio, majd mentés
        });
    }
}
