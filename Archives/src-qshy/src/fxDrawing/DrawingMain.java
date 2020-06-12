package fxDrawing;

import fxDrawing.stage.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;


public class DrawingMain extends Application {

    public void start(Stage arg0) throws Exception {
        MainStage start=new MainStage();
        start.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                //对话框
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                //设置对话框标题
                alert2.setTitle("Exit");
                //设置内容
                alert2.setHeaderText("Are you sure to exit");
                //显示对话框
                Optional<ButtonType> result = alert2.showAndWait();
                //如果点击OK
                if (result.get() == ButtonType.OK){
                    // ... user chose OK
                    start.close();
                    //否则
                } else {
                    event.consume();
                }
            }
        });
    }
    public static void main(String args[]) {
        launch(args);
    }
}