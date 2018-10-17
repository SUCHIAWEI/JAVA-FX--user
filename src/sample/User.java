package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;

public class User {
    @FXML
    MenuItem game1 , tool1 ;

    public void tool()throws Exception{
        Stage stage = new Stage();
        FXMLLoader fload = new FXMLLoader(getClass().getResource("caesar.fxml"));
        Parent par = fload.load();
        stage.setScene(new Scene(par));
        stage.show();
    }
    public void game()throws Exception{
        Stage stage = new Stage();
        FXMLLoader fload = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent par = fload.load();
        stage.setScene(new Scene(par));
        stage.show();
    }
}
