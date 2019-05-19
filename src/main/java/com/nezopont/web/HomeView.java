package com.nezopont.web;

import com.nezopont.MainLayout;
import com.nezopont.entity.Category;
import com.nezopont.entity.Movie;
import com.nezopont.entity.TvChanels;
import com.nezopont.entity.User;
import com.nezopont.service.CategoryService;
import com.nezopont.service.MovieService;
import com.nezopont.service.TvChanelService;
import com.nezopont.service.UserService;
import com.sun.org.apache.bcel.internal.generic.LADD;
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
import java.text.SimpleDateFormat;
import java.util.Date;

@Route(value="fooldal", layout = MainLayout.class)
@RouteAlias(value="fo", layout = MainLayout.class)
@PageTitle("Főoldal")
public class HomeView extends Composite<VerticalLayout> implements HasComponents {

    public UserService userService;
    private User loggedUser;
    Label top=new Label();

    public TvChanelService tvChanelService;
    public MovieService movieService;
    @Autowired
    public void setCategoryReposit(TvChanelService tvChanelService){
        this.tvChanelService=tvChanelService;
    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @Autowired
    public void setUserService(UserService userService) {
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
        }
        if(VaadinSession.getCurrent().getAttribute("userL") == null) {
        }

        H3 napi=new H3("Napi ajanló:");
        menuBar.add(uvozloszoveg);

        menuBar.add(napi);
        menuBar.add(top);
        H3 friss=new H3("Friss híreink:");
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        loggedUser=userService.findAllCategory().get(0);
        Movie topmovie=movieService.findfirst();
        TvChanels tvChanels=tvChanelService.findByid(topmovie.getTvchanel());
        top.setText("Cim: "+topmovie.getTitle()+" Kategoria: "+topmovie.getCategories() +" IMDB:"+topmovie.getImdb()+" Start: "+format.format(topmovie.getDate())+" "+topmovie.getStart()+":00" +" a(z) "+tvChanels.getName()+"-en");



    }
}
