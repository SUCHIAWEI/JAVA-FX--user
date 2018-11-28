package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Login {
    @FXML
    Button goLobbyButton;
    @FXML
    TextField userNameTextField ,ipTextField , portTextField;

    Server server ;

    public void setServer(Server server) {
        this.server = server;
    }
    public void getip(){
        server.ip(ipTextField.getText());
    }

    public void initialize(){

//        int port = Integer.parseInt(portTextField.getText());

        //Server端
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket s = serverSocket.accept(); //為平台命名稱 可開始接受
            System.out.println("已經和 " +s.getInetAddress().getHostAddress()+"連接");

            s.close();
        }
        catch (IOException e){
            System.out.println("error");
        }

        //Client端
        try {
            Socket s = new Socket(ipTextField.getText(),1234);

        }
        catch (IOException e2){
            System.out.println("error");
        }
    }
    public void goLobbyButton(ActionEvent event) {

    }
}
