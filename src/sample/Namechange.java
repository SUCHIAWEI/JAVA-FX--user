package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.*;


public class Namechange {

    @FXML
    TextField tfk , tf1 , tf2;
    @FXML
    ComboBox <String>combobox1;

    public int data[];
    private File in ,save;

    public void initialize(){
        combobox1.getItems().addAll("Caesar","XOR");
    }
    public void choose1(){
            FileChooser fileChooser = new FileChooser();
            in = fileChooser.showOpenDialog(null);
            tf1.setText(in.getPath());
    }
    public void choose2() {
        if (in != null) {
            try {
                FileChooser chooser = new FileChooser();
                save = chooser.showSaveDialog(null);
                tf2.setText(save.getPath());
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(save));
                for (int i = 0; i < data.length; i++) {
                    bufferedOutputStream.write(data[i]);
                    bufferedOutputStream.flush();
                }
                bufferedOutputStream.close();
            }
            catch (IOException i) {
                JOptionPane.showMessageDialog(null , "沒有檔案");
            }
        }
    }

    public void run(){
        if (combobox1.getValue().equals("Caesar")){
            try {
                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(in));
                data = new int[inputStream.available()];
                for (int i = 0 ; i<data.length ; i++){
                    data[i] = inputStream.read()+Integer.parseInt(tfk.getText());
                }
                tf2.setText("加密完成 點選Choose 儲存檔案");
                inputStream.close();
            }catch (IOException i){
                JOptionPane.showMessageDialog(null , "沒有檔案");
            }
        }
    }

    public void tf(){

    }

    public void exit(){
        System.exit(0);
    }

}
