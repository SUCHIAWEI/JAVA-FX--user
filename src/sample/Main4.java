package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main4 extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("caesar.fxml"));
        primaryStage.setTitle("凱薩加密");
        primaryStage.setScene(new Scene(root2));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
