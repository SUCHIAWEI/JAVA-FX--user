package sample;

import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    String ip;
    public void ip(String string){
        ip=string;

    //Server端
        try {
            ServerSocket serverSocket = new ServerSocket(1234); //建立伺服器
            Socket s = serverSocket.accept();
//            System.out.println("已經和 " +s.getInetAddress().getHostAddress()+"連接");
            OutputStream outputStream = s.getOutputStream();
            String str = "666";
            System.out.println("傳送中");
            outputStream.write(str.getBytes());
            outputStream.close();
            s.close();
        }
        catch (IOException e){
            System.out.println("error");
        }

//
//        //Client端
//        try {
//            Socket s = new Socket(ip,1234);
//        }
//        catch (IOException e2){
//            System.out.println("error");
//        }
    }
}
