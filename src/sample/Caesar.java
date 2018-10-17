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
    @FXML
    MenuItem mitem1 , mitem2 , mitem3;
    public void run() {
        if (mitem1.isVisible()) {
            int key = Integer.parseInt(tf1.getText());
            if (ecneypt.isSelected()) {
                //加密
                char c[] = ta1.getText().toCharArray();
                for (int i = 0; i < ta1.getLength(); i++) {
                    ta2.setText(ta2.getText() + (char) (c[i] + key));

                }
            }

            if (decrypt.isSelected()) {
                //解密
                for (int i = 0; i < ta2.getLength(); i++) {
                    char c[] = ta2.getText().toCharArray();
                    ta1.setText(ta1.getText() + (char) (c[i] - key));
                }
            }
        }
    }
    public void close(ActionEvent event) {
        System.exit(0);
    }
}
