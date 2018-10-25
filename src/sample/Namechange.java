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

    public void initialize(){
        combobox1.getItems().addAll("Caesar","XOR");
    }
    public void choose1(){
        try {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            tf1.setText(file.getPath());
        }
        catch (IOException i){
            JOptionPane.showMessageDialog(null , "error");
        }


    }
    public void choose2(){
//        try {
//            FileChooser fileChooser = new FileChooser();
//            File file = fileChooser.showOpenDialog(null);
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//            tf1.setText(file.getPath());
//        }
//        catch (IOException i){
//            JOptionPane.showMessageDialog(null , "error");
//        }
    }

    public void run(){
        if (combobox1.getValue().equals("Caesar")){
            try {
                FileChooser fileChooser = new FileChooser();
                File file = fileChooser.showOpenDialog(null);
                BufferedInputStream bufferedInputStream  = new BufferedInputStream(new FileInputStream(file));
                int data[] = new int[bufferedInputStream.available()];
                for (int i = 0 ; i<data.length ; i++){
                    data[i] = bufferedInputStream.read()+Integer.parseInt(tfk.getText());
                }
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
