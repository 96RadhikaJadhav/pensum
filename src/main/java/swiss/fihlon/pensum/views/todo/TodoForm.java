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

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.shared.Registration;
import swiss.fihlon.pensum.backend.entity.Todo;

public class TodoForm extends FormLayout {

    private final TextField todo = new TextField("Todo");
    private final Button save = new Button("Save");
    private final Binder<Todo> binder = new BeanValidationBinder<>(Todo.class);

    public TodoForm() {
        setId("todo-form");

        todo.setWidthFull();
        todo.setClearButtonVisible(true);
        todo.setValueChangeMode(ValueChangeMode.LAZY);
        todo.setLabel("New todo");

        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        save.addClickShortcut(Key.ENTER);
        save.addClickListener(event -> validateAndSave());
        save.setEnabled(false);

        binder.bindInstanceFields(this);
        binder.addStatusChangeListener(event -> save.setEnabled(binder.isValid()));

        var layout = new HorizontalLayout(todo, save);
        layout.setDefaultVerticalComponentAlignment(Alignment.END);
        add(layout);
    }

    public void setTodo(final Todo todo) {
        binder.setBean(todo);
    }

    private void validateAndSave() {
        if (binder.isValid()) {
            fireEvent(new SaveEvent(this, binder.getBean()));
            setTodo(new Todo());
        }
    }

    // Events
    public static abstract class TodoFormEvent extends ComponentEvent<TodoForm> {
        private final Todo todo;

        protected TodoFormEvent(final TodoForm source, final Todo todo) {
            super(source, false);
            this.todo = todo;
        }

        public Todo getTodo() {
            return todo;
        }
    }

    public static class SaveEvent extends TodoFormEvent {
        SaveEvent(final TodoForm source, final Todo todo) {
            super(source, todo);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(final Class<T> eventType,
                                                                  final ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
