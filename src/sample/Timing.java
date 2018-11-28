package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timing {

    Image img[] = new Image[10];
    int s = 0;
    int m = 0;
    int h = 0;

    @FXML
    ImageView imgv1 , imgv2 , imgv3 , imgv4 ,imgv5 , imgv6 ;
    @FXML
    Button run , pause , exit;
    @FXML
    Label lb1;


    public void initialize(){
        for (int i = 0 ;i < 10 ;i++){
            img[i] = new Image("sample/number/"+i+".png");
        }
    }

    Timer t = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            s=s+1;
            if (s==60){
                s=0;
                m++;
                if (m==60){
                    m=0;
                    h++;
                }
            }
            else {
                imgv6.setImage( img[s%10] );
                imgv5.setImage( img[s/10] );
                imgv4.setImage( img[m%10] );
                imgv3.setImage( img[m/10] );
                imgv2.setImage( img[h%10] );
                imgv1.setImage( img[h/10] );
            }
        }
    });
    public void run(){
        t.start();
    }


    public void pause(javafx.event.ActionEvent actionEvent) {
        t.stop();
    }


    public void exit(javafx.event.ActionEvent actionEvent) {
        System.exit(0);
    }
}
