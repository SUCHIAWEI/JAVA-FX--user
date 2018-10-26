package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
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
            ta2.setText("");
            int key = Integer.parseInt(tf1.getText());
            if (ecneypt.isSelected()) {
                //加密
                char c[] = ta1.getText().toCharArray();
                for (int i = 0; i < ta1.getLength(); i++) {
                    ta2.setText(ta2.getText() + (char) (c[i] + key));
                }
            }

            if (decrypt.isSelected()) {
                ta1.setText("");
                //解密
                for (int i = 0; i < ta2.getLength(); i++) {
                    char c[] = ta2.getText().toCharArray();
                    ta1.setText(ta1.getText() + (char) (c[i] - key));
                }
            }
        }
    }
    public void file(ActionEvent event)throws Exception{
        if ((event.getSource()).equals(mitem1)){

            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (bufferedReader.ready()){
                ta1.setText(ta1.getText()+bufferedReader.readLine());
            }
            bufferedReader.close();
        }
        else if ((event.getSource()).equals(mitem2)){
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(null);
            file.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(ta1.getText());
            bufferedWriter.flush(); // 把緩存區內容壓入文檔
            bufferedWriter.close();

        }
    }
    public void close() {
        System.exit(0);
    }

}
