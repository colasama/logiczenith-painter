package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML private ColorPicker colorPicker;
    @FXML private Label label;
    @FXML private Button toolsPencil;
    @FXML private Button toolsEraser;
    @FXML private Canvas paintCanvas;

    private GraphicsContext pc;
    public void changeText(){
        paintCanvas.setOnMouseMoved(event -> {
            label.setText(String.format("%.2f, %.2fpx ", event.getX(), event.getY()));
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        changeText();
        paintCanvas = new Canvas(800,600);
        pc = paintCanvas.getGraphicsContext2D();
        pc.setFill(colorPicker.getValue());
        colorPicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                pc.setFill(colorPicker.getValue());
                label.setText(colorPicker.getValue().toString());
                label.setTextFill(colorPicker.getValue());
            }
        });

    }
}
