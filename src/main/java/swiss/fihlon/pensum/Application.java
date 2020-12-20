/*
 * Pensum
 * Copyright © 2020 Marcus Fihlon
 * https://github.com/pensum/pensum
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package swiss.fihlon.pensum;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@PWA(name = "Pensum", shortName = "Pensum")
@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

    public static final String APPLICATION_TITLE = "Pensum";
    public static final String APPLICATION_VERSION = "0.1";
    public static final String APPLICATION_TITLE_VERSION = "%s %s".formatted(APPLICATION_TITLE, APPLICATION_VERSION);
    public static final String APPLICATION_COPYRIGHT = "Copyright © 2020-%s Marcus Fihlon".formatted(LocalDate.now().getYear());

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
