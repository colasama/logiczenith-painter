package LoPainter.Handler;

import LoPainter.Assets.Shape;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

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
