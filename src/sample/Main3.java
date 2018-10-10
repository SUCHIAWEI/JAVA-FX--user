package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main3 extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("user.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root2, 300, 275));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
