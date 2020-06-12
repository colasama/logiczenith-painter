package LoPainter;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoPainter.fxml"));

        primaryStage.setTitle("全 山 画 玉");
        Scene scene =new Scene(root, 1280, 720);
        scene.getStylesheets().add(
                getClass().getResource("LoPainter.css")
                        .toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                alert2.setTitle("退出程序");
                alert2.setHeaderText("你确定要退出吗？");
                Optional<ButtonType> result = alert2.showAndWait();
                if (result.get() == ButtonType.OK){
                    primaryStage.close();
                } else {
                    event.consume();
                }
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
