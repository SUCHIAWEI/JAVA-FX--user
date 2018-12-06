package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    @FXML
    public TextArea txr;
    @FXML
    public TextField txf;
    private ServerSocket serverSocket ;
    private InetAddress inetAddress;
    private Socket socket ;
    private PrintStream outputStream ;
    private BufferedReader inputStream ;
     String ip;
     private Server s ;
     public void initialize(){
         ip("123");
       this.start();
     }

    public void ip(String string) {
        ip = string;
        //Server端
        try {
            serverSocket = new ServerSocket(1234); //建立伺服器
            inetAddress = InetAddress.getLocalHost();
        } catch (IOException e) {
            System.out.println("error");
        }
    }
    public void send(ActionEvent event) {
         sendM(txf.getText());
         txr.setText(txr.getText()+"Sever:"+txf.getText()+"\n");
         txf.setText("");
    }
        public void run(){
        try {
            socket = serverSocket.accept();
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

    public String getIp() {
        return ip;
    }

    public void addMessage(String message){
            txr.setText(txr.getText()+"Client"+message +"\n");
    }

    public void sendM (String send){
        try {
            if (outputStream!=null){
                outputStream.println(send);
                outputStream.flush();
            }
        }catch (Exception e){
            System.out.println("error");
        }
    }


}
