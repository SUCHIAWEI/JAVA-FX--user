package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class loginF extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        FXMLLoader fload = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent par = fload.load();
        primaryStage.setScene(new Scene(par));
        primaryStage.show();
        primaryStage.setTitle("登入器");
        primaryStage.setResizable(false);
        par.getStylesheets().add(loginF.class.getResource("Login.css").toExternalForm());

    }


    public static void main(String[] args) {
        launch(args);
    }
}
