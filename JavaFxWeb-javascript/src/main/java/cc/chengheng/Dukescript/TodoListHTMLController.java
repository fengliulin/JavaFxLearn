package cc.chengheng.Dukescript;

import com.dukescript.api.javafx.beans.ActionDataEvent;
import com.dukescript.api.javafx.beans.FXBeanInfo;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;

public class TodoListHTMLController implements FXBeanInfo.Provider {
    final ObjectProperty<String> input = new SimpleObjectProperty<>(this, "input");

    final ObjectProperty<TodoElement> selected = new
            SimpleObjectProperty<>(this, "selected");
    final ListProperty<TodoElement> todos =
            new SimpleListProperty<>(this, "todos", FXCollections.observableArrayList());
    final Property<EventHandler<Event>> add = new
            SimpleObjectProperty<>(this, "add");
    final Property<EventHandler<ActionDataEvent>> remove = new
            SimpleObjectProperty<>(this, "remove");
    final FXBeanInfo info = FXBeanInfo.newBuilder(this).
            property(input).
            property(selected).
            property(todos).
            action(remove).
            action(add).
            build();

    public TodoListHTMLController() {
        todos.add(new TodoElement("Buy milk!"));
        add.setValue(e -> todos.add(new TodoElement(input.get())));
        remove.setValue((event) -> {
                    TodoElement toRemove = event.getSource(TodoElement.class);
                    todos.get().remove(toRemove);
                }
        );
    }

    @Override
    public FXBeanInfo getFXBeanInfo() {
        return info;
    }

    private static final class TodoElement implements FXBeanInfo.Provider {
        final String message;
        final FXBeanInfo info;

        TodoElement(String message) {
            this.message = message;
            this.info = FXBeanInfo.newBuilder(this).
                    constant("message", message).
                    build();
        }

        @Override
        public FXBeanInfo getFXBeanInfo() {
            return info;
        }
    }
}