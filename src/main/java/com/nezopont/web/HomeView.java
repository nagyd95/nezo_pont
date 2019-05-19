package com.nezopont.web;

import com.nezopont.MainLayout;
import com.nezopont.entity.Category;
import com.nezopont.entity.User;
import com.nezopont.service.UserService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Route(value="fooldal", layout = MainLayout.class)
@RouteAlias(value="fo", layout = MainLayout.class)
@PageTitle("Főoldal")
public class HomeView extends Composite<VerticalLayout> implements HasComponents {

    public UserService userService;
    private User loggedUser;



    @Autowired
    public void setMovieService(UserService userService) {
        this.userService = userService;
    }

    public HomeView() {
        //HorizontalLayout mainContent = new HorizontalLayout();
        VerticalLayout menuBar = new VerticalLayout();

        add(new H2("Üdvözöllek!"));
        Label uvozloszoveg=new Label("Üdvözlünk az oldalon ! Kellemes idötöltés !");
        if(VaadinSession.getCurrent().getAttribute("userL") != null) {
            Button edit=new Button("Profil");
            menuBar.add(edit);
            edit.addClickListener(e -> {
                edit.getUI().ifPresent(ui -> ui.navigate("edit"));
            });
            System.out.println("Bent vagy admin");
        }
        if(VaadinSession.getCurrent().getAttribute("userL") == null) {
            System.out.println("nem vagy admin");
        }
        menuBar.add(uvozloszoveg);
        H3 friss=new H3("Friss hireink:");
        Label hir1=new Label("Elindult az M3 internetes adása\n" +
                "2019. május 1-jén az M3 új korszakába lépett. A klasszikus tévécsatorna helyett olyan online platform indult, mely nagyobb teret enged az egyéni nézői ízlésnek és érdeklődésnek.");
        Label hir2=new Label("Két hétre hosszabbítja a gyereknapot a UPC Direct\n"+
        "Nemcsak korábban kezdődik idén a gyereknap, de tovább is tart a UPC Direct kódolatlan időszakának köszönhetően, amely \n"+
                "keretében a legkisebb tévénézők korlátlanul nézhetik a Cartoon Network, a Boomerang és a Nick Jr. csatornákat. Május 20. és június 2. között,\n"+
                "két teljes héten keresztül élvezhetik a mesék, rajzfilmek, vicces és tanulságos történetek széles választékát. A fent említett gyerekcsatornák a UPC Direct összes ügyfele számára elérhetők lesznek ezen időszak alatt.");
        menuBar.add(friss);

        menuBar.add(hir1);
        menuBar.add(hir2);
        add(menuBar);
    }
    @PostConstruct
    void listUser() {
        loggedUser=userService.findAllCategory().get(0);
        System.out.println(loggedUser.getEmail()+loggedUser.getId());


    }
}
