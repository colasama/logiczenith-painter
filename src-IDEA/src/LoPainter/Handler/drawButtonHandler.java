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

public class drawButtonHandler{
    private Button toolsPencil;
    private Button toolsEraser;
    private Button toolsUndo;
    private Button toolsRedo;
    private Button toolsLine;

    private List<Button> buttonList;

    public drawButtonHandler(List<Button> buttonList){
        this.buttonList=buttonList;
        //this.toolsPencil = buttonList.get(0);
        //this.toolsEraser = buttonList.get(1);
        toolsHandler();
    }

    private void toolsHandler(){
        for(Button btn:buttonList){
            btn.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
                String name = ((Button) e.getSource()).getText();//获取它的名字
                System.out.println(name);
                Shape.resetToolName("PENCIL");
            });
        }
        /*toolsPencil.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            String name = ((Button) e.getSource()).getText();//获取它的名字
            System.out.println(name);
            Shape.resetToolName("PENCIL");
        });*/
    }

}