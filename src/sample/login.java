package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Random;

public class login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Stage stage = new Stage();
        FXMLLoader fload = new FXMLLoader(getClass().getResource("guess_login.fxml"));
        Parent par = fload.load();
        stage.setScene(new Scene(par));
        stage.show();
        stage.setTitle("登入器");

        par.getStylesheets().add(login.class.getResource("Login.css").toExternalForm());

    }


    public static void main(String[] args) {
        launch(args);
    }
}
