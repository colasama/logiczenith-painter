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

public class colorPickerHandler {
    private ColorPicker colorPicker;
    private Label label;

    public colorPickerHandler(ColorPicker colorPicker,Label label){
        this.label=label;
        this.colorPicker=colorPicker;
        colorPickerListener();
    }

    public void colorPickerListener(){
        colorPicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                Shape.resetColor(colorPicker.getValue());
                label.setText(colorPicker.getValue().toString());
                label.setTextFill(colorPicker.getValue());
            }
        });
    }

}
