package swiss.fihlon.pensum.views.about;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import swiss.fihlon.pensum.Application;

@PageTitle("About | " + Application.APPLICATION_TITLE)
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
                new H3("Handcrafted in Switzerland"),
                new Hr(),
                new Div(
                        new H4("License"),
                        new Paragraph(
                                new Text("""
                                            This program is free software: you can redistribute it and/or modify
                                            it under the terms of the GNU Affero General Public License as
                                            published by the Free Software Foundation, either version 3 of the
                                            License, or (at your option) any later version.
                                            
                                            This program is distributed in the hope that it will be useful,
                                            but WITHOUT ANY WARRANTY; without even the implied warranty of
                                            MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
                                            GNU Affero General Public License for more details.
                                            
                                            You should have received a copy of the GNU Affero General Public License
                                            along with this program.  If not, see <""".stripIndent()),
                                new Anchor("https://www.gnu.org/licenses/", "https://www.gnu.org/licenses/"),
                                new Text(">."))
                ),
                new Hr()
        );
    }

}
