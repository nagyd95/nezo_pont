package com.nezopont.web;

import com.nezopont.MainLayout;
import com.nezopont.service.MessageService;
import com.nezopont.web.DTO.MessageDTO;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@Route(value="contact", layout = MainLayout.class)
@RouteAlias(value="co", layout = MainLayout.class)
@PageTitle("Kapcsolat")
@RestController
@SpringComponent
public class Contact extends Composite<VerticalLayout> implements HasComponents {
    public MessageService messageService;

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public Contact() {
        add(new H2("Lépjen velünk kapcsolatba"));
        FormLayout layoutWithBinder = new FormLayout();
        TextField name=new TextField();
        name.setValueChangeMode(ValueChangeMode.EAGER);
        TextArea textArea=new TextArea();
        textArea.setHeight("large");


        Button save = new Button("Küldés");
        textArea.getStyle().set("height","40px");
        layoutWithBinder.addFormItem(name, "Adja meg nevét");
        layoutWithBinder.addFormItem(textArea, "Üzenet");
        HorizontalLayout actions = new HorizontalLayout();
        actions.add(save);
        save.getStyle().set("marginRight", "10px");
        Label answer=new Label("");
        add(layoutWithBinder);
        add(actions,answer);
        save.addClickListener(event ->{
            MessageDTO msg=new MessageDTO(name.getValue(),textArea.getValue());
            messageService.save(msg);
            name.setValue("");
            textArea.setValue("");
            answer.setText("Köszönjük észrevételét");
        });
    }
}
