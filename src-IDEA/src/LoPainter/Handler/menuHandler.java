package LoPainter.Handler;

import LoPainter.Controller;
import LoPainter.assets.Path;
import LoPainter.assets.Size;
import LoPainter.shape.Shapes2D;
import LoPainter.stage.Shape;
import LoPainter.shape.*;
import LoPainter.Handler.*;
import javafx.event.ActionEvent;
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
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.*;

public class menuHandler {
    private MenuItem menuSave;

    public menuHandler(List<MenuItem> menuList){
        this.menuSave=menuList.get(0);
        menuSaveHandler();
    }

    public void menuSaveHandler(){
            menuSave.setAccelerator(KeyCombination.keyCombination("Ctrl+s"));
            menuSave.setOnAction((ActionEvent t) -> {
                List<Canvas> saveList = Controller.getDh().getDraw();
                FileSaver fileSaver = new FileSaver(saveList, (int)Size.CANVAS_WIDTH,(int)Size.CANVAS_HEIGHT);
                fileSaver.saveToFile();
                fileSaver = null;
                saveList = null;
                System.gc();
            });

    }
}
