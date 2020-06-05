import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.canvas;

public class Main extends Application{
    
    @Override  // Override the start method in the Application class
    public void start(Stage primaryStage){
        // Create a scene and place a button in the scene
        Button bOK = new Button("OK");
        Scene scene = new Scene(bOK,1280, 720);
        primaryStage.setTitle("全 山 画 玉");  // Set the stage title
        primaryStage.setScene(scene);  // Place the scene in the stage
        primaryStage.show();  // Display the stage
    }
    
    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args){
         Application.launch(args);
    }
}