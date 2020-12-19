package swiss.fihlon.pensum;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;

import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.vaadin.artur.helpers.LaunchUtil;

@SpringBootApplication
@PWA(name = "Pensum", shortName = "Pensum")
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

    public static final String APPLICATION_TITLE = "Pensum";
    public static final String APPLICATION_VERSION = "0.1";
    public static final String APPLICATION_TITLE_VERSION = "%s %s".formatted(APPLICATION_TITLE, APPLICATION_VERSION);
    public static final String APPLICATION_COPYRIGHT = "Copyright © 2020-%s Marcus Fihlon".formatted(LocalDate.now().getYear());

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
