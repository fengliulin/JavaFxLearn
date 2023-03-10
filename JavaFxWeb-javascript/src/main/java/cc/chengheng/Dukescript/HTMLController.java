package cc.chengheng.Dukescript;

import com.dukescript.api.javafx.beans.FXBeanInfo;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HTMLController implements FXBeanInfo.Provider {
    private final StringProperty labelText = new SimpleStringProperty(this, "labelText", "");

    private final Property<EventHandler<ActionEvent>> action =
            new SimpleObjectProperty<EventHandler<ActionEvent>>(
                    this, "action",
                    (e) -> labelText.set("Hello World!"));
    private final FXBeanInfo info = FXBeanInfo
            .newBuilder(this)
            .action(action)
            .property(labelText)
            .build();

    public HTMLController() {
    }

    @Override
    public FXBeanInfo getFXBeanInfo() {
        return info;
    }
}