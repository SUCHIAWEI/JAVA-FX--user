package sample;

import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    String ip;
    public void ip(String string){
        ip=string;

    //Server端
        try {
            ServerSocket serverSocket = new ServerSocket(1234); //建立伺服器
            Socket s = serverSocket.accept(); //為平台命名稱 可開始接受
            System.out.println("已經和 " +s.getInetAddress().getHostAddress()+"連接");
            s.close();
        }
        catch (IOException e){
            System.out.println("error");
        }


        //Client端
        try {
            Socket s = new Socket(ip,1234);
        }
        catch (IOException e2){
            System.out.println("error");
        }
    }
}
