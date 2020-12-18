package swiss.fihlon.pensum.views.about;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import swiss.fihlon.pensum.Application;
import swiss.fihlon.pensum.views.main.MainView;

@Route(value = "about", layout = MainView.class)
@PageTitle("About | " + Application.APPLICATION_TITLE)
@RouteAlias(value = "", layout = MainView.class)
@CssImport("./styles/views/about/about-view.css")
public class AboutView extends VerticalLayout {

    public AboutView() {
        setId("about-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(
                new H1(Application.APPLICATION_TITLE_VERSION),
                new H2(Application.APPLICATION_COPYRIGHT),
                new H3("Handcrafted in Switzerland")
        );
    }

}
