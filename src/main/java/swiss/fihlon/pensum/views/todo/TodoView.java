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
package swiss.fihlon.pensum.views.todo;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.stereotype.Component;
import swiss.fihlon.pensum.Application;
import swiss.fihlon.pensum.backend.entity.Todo;
import swiss.fihlon.pensum.backend.service.TodoService;
import swiss.fihlon.pensum.views.main.MainView;
import swiss.fihlon.pensum.views.todo.TodoForm.SaveEvent;

@Component
@Route(value = "todo", layout = MainView.class)
@PageTitle("Todo | " + Application.APPLICATION_TITLE)
@CssImport("./styles/views/todo/todo-view.css")
public class TodoView extends VerticalLayout {

    private final TodoService todoService;

    private final Grid<Todo> grid = new Grid<>(Todo.class);
    private final TodoForm form = new TodoForm();

    public TodoView(final TodoService todoService) {
        this.todoService = todoService;

        setId("todo-view");
        setSizeFull();
        configureGrid();

        form.addListener(SaveEvent.class, this::saveTodo);
        form.setTodo(new Todo());

        final Div content = new Div(grid, form);
        content.addClassName("content");
        content.setSizeFull();
        add(content);

        updateGrid();
    }

    private void configureGrid() {
        grid.setId("todo-grid");
        grid.setWidthFull();
        grid.setColumns("todo");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void updateGrid() {
        grid.setItems(todoService.findAll());
    }

    private void saveTodo(final SaveEvent event) {
        todoService.save(event.getTodo());
        updateGrid();
        grid.scrollToEnd();
    }

}
