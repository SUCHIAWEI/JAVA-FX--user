package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client extends Thread{
    public TextArea txr;
    public TextField txf;
    private Socket socket ;
    private PrintStream outputStream ;
    private BufferedReader inputStream ;

    public void initialize(){
        this.start();
    }


    public void send(ActionEvent event) {
        send(txf.getText());
        txr.setText(txr.getText()+"Client:"+txf.getText()+"\n");
        txf.setText("");
        if (txf.getText().equals("88")){
        }
    }


    public void run(){
        try {
            socket = new Socket("10.51.3.61", 1234);
            outputStream = new PrintStream(socket.getOutputStream());
            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("welcome");
            String str ="";
            while (!(str=inputStream.readLine()).equals("")){
                addMessage(str);
            }
        }
        catch (IOException  e){
            System.out.println("error");
        }
    }
    public void addMessage(String message){
        txr.setText(txr.getText()+"Server:"+message +"\n");
    }
    public void send (String send){
        try {
            if (outputStream!=null){
                outputStream.println(send);
            }
        }catch (Exception e){
            System.out.println("error");
        }
    }
}

