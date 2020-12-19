package swiss.fihlon.pensum.backend.service;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.server.VaadinSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import swiss.fihlon.pensum.backend.entity.Role;
import swiss.fihlon.pensum.backend.entity.User;
import swiss.fihlon.pensum.backend.repository.UserRepository;
import swiss.fihlon.pensum.views.about.AboutView;
import swiss.fihlon.pensum.views.logout.LogoutView;
import swiss.fihlon.pensum.views.main.MainView;

@Service
public class AuthService {

    public record AuthorizedRoute(String route, String name, Class<? extends Component> view) {}

    public class AuthException extends Exception {}

    private final UserRepository userRepository;

    public AuthService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void authenticate(final String email, final String password) throws AuthException {
        final User user = userRepository.getByEmail(email);
        if (user != null && user.checkPassword(password)) {
            VaadinSession.getCurrent().setAttribute(User.class, user);
            createRoutes(user.getRole());
        } else {
            throw new AuthException();
        }
    }

    private void createRoutes(final Role role) {
        getAuthorizedRoutes(role)
                .forEach(route -> RouteConfiguration.forSessionScope().setRoute(
                        route.route, route.view, MainView.class
                ));
    }

    public List<AuthorizedRoute> getAuthorizedRoutes(final Role role) {
        var routes = new ArrayList<AuthorizedRoute>();

        if (role.equals(Role.USER) || role.equals(Role.ADMIN)) {
            routes.add(new AuthorizedRoute("about", "About", AboutView.class));
            routes.add(new AuthorizedRoute("logout", "Logout", LogoutView.class));
        }

        return routes;
    }
}
