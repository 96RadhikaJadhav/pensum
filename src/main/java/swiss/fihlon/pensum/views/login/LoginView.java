package swiss.fihlon.pensum.views.login;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import swiss.fihlon.pensum.Application;
import swiss.fihlon.pensum.backend.service.AuthService;
import swiss.fihlon.pensum.backend.service.AuthService.AuthException;

@Route(value = "login")
@PageTitle("Login | " + Application.APPLICATION_TITLE)
@CssImport("./styles/views/login/login-view.css")
public class LoginView extends Div {

    public LoginView(final AuthService authService) {
        setId("login-view");
        var email = new EmailField("Email");
        var password = new PasswordField("Password");
        add(
                new H1("Welcome"),
                email,
                password,
                new Button("Login", event -> {
                    try {
                        authService.authenticate(email.getValue(), password.getValue());
                        UI.getCurrent().navigate("home");
                    } catch (final AuthException e) {
                        Notification.show("Wrong credentials.");
                    }
                })
        );
    }

}
