package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class Test {
    @FXML
    Button add ;
    @FXML
            Panel panel ;


    Label lb =new Label("456");

    public void initialize(){
//        square s = new square("123");
//        Thread s2 = new Thread(new square("456"));
//        s2.start();
        lb.setText("123");
        lb.setPrefWidth(50);
        lb.setPrefHeight(50);
        lb.setLayoutX(100);
        lb.setLayoutY(200);

    }
    public void add(){
        Thread s = new Thread(new square(800,600));
        s.start();
        lb.setPrefWidth(50);
        lb.setPrefHeight(50);
        lb.setLayoutX(100);
        lb.setLayoutY(200);
//        panel.add;

    }



    public class square extends Label implements Runnable {
        int x , y ,frmW , frmH ,r ,red ,blue , green;
        Random ran = new Random();
        boolean flag = true;
        square (int frmW,int frmH){
            this.frmH = frmH ;
            this.frmW = frmW ;
            this.setText(Integer.toString(ran.nextInt(10)));
            System.out.println(this.getText());
            x = ran.nextInt(frmW-100);
            y = ran.nextInt(frmH-100);
            r = ran.nextInt(2);
            red = ran.nextInt(255);
            green = ran.nextInt(255);
            blue = ran.nextInt(255);
            if (r == 1){
                this.flag = false;
            }
            this.setWidth(100);
            this.setHeight(100);
            this.setLayoutX(x);
            this.setLayoutY(y);
//            this.setBackground(Color.color(red,green,blue));
        }

        public void run(){
            javax.swing.Timer t = new javax.swing.Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (square.this.flag){
                        if (x-10>0){
                            x = x-10;
                        }
                        else {
                            square.this.flag = !square.this.flag;
                                r=1;
                                x = x+10 ;
                        }
                    }
                    else {
                        if (x+square.this.getWidth()+20< frmW){
                            x = x+10 ;
                        }else {
                            square.this.flag = !square.this.flag;
                            r = 0;
                            x =x-10;

                        }
                        square.this.setWidth(x);
                        square.this.setHeight(y);
                    }
                }
            });
            t.start();
        }
    }
}
