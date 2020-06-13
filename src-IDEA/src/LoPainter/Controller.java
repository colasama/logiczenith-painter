package LoPainter;

import LoPainter.Handler.DetailHandler;
import LoPainter.Handler.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable{
    @FXML private ColorPicker colorPicker;
    @FXML private Label label;
    @FXML private Button toolsPencil;
    @FXML private Button toolsEraser;
    @FXML private Button toolsMFB;
    @FXML private Button toolsPaint;
    @FXML private Button toolsText;
    @FXML private Button toolsOval;
    @FXML private Button toolsCircle;
    @FXML private Button toolsTri;
    @FXML private Button toolsRect;
    @FXML private Button toolsRectround;
    @FXML private Button toolsLine;
    @FXML private ComboBox toolsSize;
    @FXML private ComboBox toolsType;
    @FXML private VBox content;
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
        DetailHandler dp = new DetailHandler(content,toolsSize,toolsType);
        drawButtonHandler bch = new drawButtonHandler(pushDrawButtonList(),dp);
        //colorPicker处理，处理全局颜色
        colorPickerHandler cph = new colorPickerHandler(colorPicker,label);
        menuHandler menuh = new menuHandler(pushMenuItemList());
    }

    public List<Button> pushDrawButtonList(){
        List<Button> bl = new ArrayList<Button>();
        bl.add(toolsPencil);
        bl.add(toolsEraser);
        bl.add(toolsMFB);
        bl.add(toolsPaint);
        bl.add(toolsText);
        bl.add(toolsCircle);
        bl.add(toolsTri);
        bl.add(toolsOval);
        bl.add(toolsRect);
        bl.add(toolsRectround);
        bl.add(toolsLine);
        /*
        bl.add(toolsLine);
        bl.add(toolsRedo);
        bl.add(toolsUndo);
         */
        return bl;
    }

    public List<MenuItem> pushMenuItemList(){
        List<MenuItem> menul = new ArrayList<MenuItem>();
        menul.add(menuSave);

        return menul;
    }
    public static drawingHandler getDh(){
        return dh;
    }
}
