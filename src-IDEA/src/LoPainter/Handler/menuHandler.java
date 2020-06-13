package LoPainter.Handler;

import LoPainter.Controller;
import LoPainter.Assets.Size;
import LoPainter.Components.*;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

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
