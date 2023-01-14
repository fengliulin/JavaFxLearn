
import cc.chengheng.Dukescript.HTMLController;
import com.dukescript.api.javafx.beans.ActionDataEvent;
import com.dukescript.api.javafx.beans.FXBeanInfo;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/******************************************
 * ProjectName : 程衡服装进销存            
 * Web         : www.chengheng.cc
 * Start Date  : 2023/1/13
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
public class HTMLControllerTest {

    @Test
    public void method() {
        HTMLController controller = new HTMLController();
        FXBeanInfo fxBeanInfo = controller.getFXBeanInfo ();
        ObservableValue<?> labelText = fxBeanInfo.getProperties().get("labelText");
        assertEquals("", labelText.getValue());
        EventHandler<? super ActionDataEvent> action =
                fxBeanInfo.getActions().get("action").getValue();
        action.handle(null);
        assertEquals("Hello World!", labelText.getValue());
    }

}