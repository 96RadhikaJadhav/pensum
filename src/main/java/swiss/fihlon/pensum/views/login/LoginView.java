package swiss.fihlon.pensum.views.login;


import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import swiss.fihlon.pensum.Application;

@Route(value = "login")
@PageTitle("Login | " + Application.APPLICATION_TITLE)
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private final LoginForm login = new LoginForm();

    public LoginView(){
        setId("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        login.setAction("login");
        add(new H1(Application.APPLICATION_TITLE), login);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }

        beforeEnterEvent.getUI().getPage().executeJs(loginPageFocusHack());
    }

    private String loginPageFocusHack() {
        return """
            debugger;
            const observer = new MutationObserver(function(mutations) {
                mutations.forEach(function(mutation) {
                    if (mutation.target.id === "outlet") {
                        document.getElementById("vaadinLoginUsername").focus();
                        observer.disconnect();
                    }
                });
            });

            observer.observe(document.body, {
                childList: true,
                subtree: true,
                attributes: false,
                characterData: false
            });
        """.stripIndent();
    }

}
