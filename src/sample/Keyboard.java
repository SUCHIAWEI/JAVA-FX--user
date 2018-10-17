package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class Keyboard {
    Controller c;
    Button btn[] ;

    @FXML
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
    @FXML
    private PasswordField ps;

    public void setC(Controller c) {
        this.c = c;
    }

    public void setBtn(Button[] j){
        this.btn = j;
    }

    //抓九顆按鈕的值
    public void ran(ActionEvent event){
        Button button = (Button) event.getSource();
        ps.setText(ps.getText()+button.getText());
    }
    @FXML
    public void change(){
        Random ran = new Random();
        int a[] = new int[10];
        //製造亂數
        for (int i = 0 ;i<10 ; i++){
            a[i]= ran.nextInt(10);
            for (int j=0 ; j<i;){
                if (a[j] == a[i]){
                    a[i]= ran.nextInt(10);
                    j=0;
                }
                else j++;
            }
        }
        btn1.setText(Integer.toString(a[0]));
        btn2.setText(Integer.toString(a[1]));
        btn3.setText(Integer.toString(a[2]));
        btn4.setText(Integer.toString(a[3]));
        btn5.setText(Integer.toString(a[4]));
        btn6.setText(Integer.toString(a[5]));
        btn7.setText(Integer.toString(a[6]));
        btn8.setText(Integer.toString(a[7]));
        btn9.setText(Integer.toString(a[8]));
        btn10.setText(Integer.toString(a[9]));
    }

    public void send(){
       c.password(ps.getText());
       Stage s =(Stage) ps.getScene().getWindow();
       s.close();
    }
}
