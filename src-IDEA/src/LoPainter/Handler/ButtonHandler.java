package LoPainter.Handler;
import LoPainter.assets.Path;
import LoPainter.assets.Size;
import LoPainter.shape.Shapes2D;
import LoPainter.stage.Shape;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.net.URL;
import java.util.*;

public class ButtonHandler{
    private Button toolsPencil;
    private List<Button> buttonList;

    public ButtonHandler(Button toolsPencil){
        this.toolsPencil = toolsPencil;
        toolsPencilHandler();
    }

    private void toolsPencilHandler(){
        toolsPencil.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            String name = ((Button) e.getSource()).getText();//获取它的名字
            System.out.println(name);
            Shape.resetToolName("PENCIL");
        });
    }
}