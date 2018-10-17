package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Random;

public class Controller {
    @FXML
    private TextField txf1;
    @FXML
    private PasswordField ps1;
    @FXML
    public Button exit ;

    public void password(String p){
        ps1.setText(p);
    }

    public void login(ActionEvent event) throws Exception{
        String acc = "h103";//帳號
        String ps ="106021381";//密碼
        if (txf1.getText().equals(acc)){
            if (ps1.getText().equals(ps)){
                Stage stage = new Stage();
                FXMLLoader fload = new FXMLLoader(getClass().getResource("user.fxml"));
                Parent par = fload.load();
                stage.setScene(new Scene(par));
                stage.show();
            }
        }
    }
    @FXML
    public void keyboard(ActionEvent event) throws Exception{
        //開啟鍵盤畫面
        Stage stage = new Stage();
        FXMLLoader fload = new FXMLLoader(getClass().getResource("keysample.fxml"));
        Parent par = fload.load();//解析fxml黨
        stage.setScene(new Scene(par));
        stage.show();

        Keyboard ctrl = fload.getController();
        ctrl.setC(Controller.this);
        Random ran = new Random();
        int a[] = new int[10];
        Button b[]= new Button[10];

        for (int i = 0 ;i<10 ; i++){
            a[i]= ran.nextInt(10);
                for (int j=0 ; j<i;){
                    if (a[j] == a[i]){
                        a[i]= ran.nextInt(10);
                        j=0;
                    }
                    else j++;
                }
            b[i] = (Button) par.lookup("#btn"+Integer.toString(i+1));
            b[i].setText(Integer.toString(a[i]));
        }
        ctrl.setBtn(b);
    }


    public void exit(){
        System.exit(0);
    }
}