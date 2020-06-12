package LoPainter;

import LoPainter.assets.Path;
import LoPainter.assets.Size;
import LoPainter.shape.Shapes2D;
import LoPainter.stage.Shape;
import LoPainter.Handler.*;
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
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable{
    @FXML private ColorPicker colorPicker;
    @FXML private Label label;
    @FXML private Button toolsPencil;
    @FXML private Button toolsEraser;
    /*
    @FXML private Button toolsUndo;
    @FXML private Button toolsRedo;
    @FXML private Button toolsLine;
    @FXML private Canvas paintCanvas;
    */
    @FXML private VBox vbo;

    @FXML private MenuItem menuSave;

    public static drawingHandler dh;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //绘图处理，处理所有的绘图操作
        dh = new drawingHandler(vbo,label);
        //创建绘画按钮列表然后传给ButtonHandler
        drawButtonHandler bch = new drawButtonHandler(pushDrawButtonList());
        //colorPicker处理，处理全局颜色
        colorPickerHandler cph = new colorPickerHandler(colorPicker,label);
        menuHandler menuh = new menuHandler(pushMenuItemList());
    }

    public List<Button> pushDrawButtonList(){
        List<Button> bl = new ArrayList<Button>();
        bl.add(toolsPencil);
        bl.add(toolsEraser);
        /*
        bl.add(toolsLine);
        bl.add(toolsRedo);
        bl.add(toolsUndo);
         */
        return bl;
    }

    public List<Button> pushMenuItemList(){
        List<MenuItem> menul = new ArrayList<MenuItem>();
        menul.add(menuSave);

        return menul;
    }
    public static drawingHandler getDh(){
        return dh;
    }
}
