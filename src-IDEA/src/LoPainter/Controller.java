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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable{
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Label label;
    @FXML
    private Button toolsPencil;
    @FXML
    private Button toolsEraser;
    @FXML
    private Canvas paintCanvas;
    //@FXML private AnchorPane acPane;
    @FXML
    private VBox vbo;
    /*
    public void changeText(){
        paintCanvas.setOnMouseMoved(event -> {
            label.setText(String.format("%.2f, %.2fpx ", event.getX(), event.getY()));
        });
        paintCanvas.setOnMouseExited(event -> {
            label.setText("");
        });
    }
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DrawingHandler dh = new DrawingHandler(vbo,label);
        ButtonHandler bc = new ButtonHandler(toolsPencil);

        colorPicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                Shape.resetColor(colorPicker.getValue());
                label.setText(colorPicker.getValue().toString());
                label.setTextFill(colorPicker.getValue());
            }
        });
    }
}
