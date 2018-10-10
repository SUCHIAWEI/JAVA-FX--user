package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class Caesar {
    @FXML
    Button run , close ;
    @FXML
    TextArea ta1 , ta2 ;
    @FXML
    TextField tf1;
    @FXML
    RadioButton ecneypt , decrypt;

    public void run(ActionEvent event) {
        int key = Integer.parseInt(tf1.getText());
        String str = "";
        if (ecneypt.isSelected()) {
            //加密
            for (int i = 0; i < ta1.getLength(); i++) {
                char c = ta1.getText().charAt(i);
                if (c >= 'a' && c <= 'z') {
                    c += key % 26;
                    if (c < 'a') {
                        c += 26;
                    }
                    if (c > 'z') {
                        c -= 26;
                    }
                }
                if (c >= 'A' && c <= 'Z') {
                    c += key % 26;
                    if (c < 'A') {
                        c += 26;
                    }
                    if (c > 'Z') {
                        c -= 26;
                    }
                }
                str = str + c;
                ta2.setText(str);
            }
        }

        if (decrypt.isSelected()) {
            //解密
            for (int i = 0; i < ta2.getLength(); i++) {
                char c = ta2.getText().charAt(i);
                if (c >= 'a' && c <= 'z') {
                    c -= key % 26;
                    if (c < 'a') {
                        c += 26;
                    }
                    if (c > 'z') {
                        c -= 26;
                    }
                }
                if (c >= 'A' && c <= 'Z') {
                    c -= key % 26;
                    if (c < 'A') {
                        c += 26;
                    }
                    if (c > 'Z') {
                        c -= 26;
                    }
                }
                str = str + c;
                ta1.setText(str);
            }
        }
    }
    public void close(ActionEvent event) {
        System.exit(0);
    }
}
