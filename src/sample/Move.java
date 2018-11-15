package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.security.Key;


public class Move {
    @FXML
    ImageView imgv;

    Image img = new Image("sample/稻草人_右.png");
    Image img2 = new Image("sample/稻草人_左.png");

    int i =0;
    public void key(KeyEvent event){

        if (event.getCode().equals(KeyCode.RIGHT)){
            i=0;
            imgv.setImage(img);
            System.out.println("123");
        }
        else  if (event.getCode().equals(KeyCode.LEFT)){
            i=1;
            imgv.setImage(img2);
            System.out.println("123");
        }
        else  if (event.getCode().equals(KeyCode.UP)){
            i=2;
            System.out.println("123");
        }
        else if (event.getCode().equals(KeyCode.DOWN)){
            i=3;
            System.out.println("123");

        }
    }
    Timer t = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {

            if (i==0){
                imgv.setX(imgv.getX()+10);
            }
            else if (i==1){
                imgv.setX(imgv.getX()-10);

            }
            else if (i==2){
                imgv.setY(imgv.getY()-10);
            }
            else if (i==3){
                imgv.setY(imgv.getY()+10);
            }
        }
    });

    public void up(ActionEvent actionEvent) {
        t.start();
    }

    public void down(ActionEvent actionEvent) {
    }

    public void left(ActionEvent actionEvent) {
    }

    public void right(ActionEvent actionEvent) {
    }

    public void trtrtrtr(ActionEvent actionEvent) {

    }
}
