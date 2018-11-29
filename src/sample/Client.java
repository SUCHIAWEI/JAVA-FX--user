package sample;

import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public void Client () {

//    Client端
        byte buff[] = new byte[1024];

        try {
            Socket s = new Socket("10.51.3.61", 1234);
            System.out.println("開始連線");
            InputStream inputStream= s.getInputStream();
            int n = inputStream.read(buff);
            System.out.println(new String(buff ,0 , n));
            inputStream.close();
            s.close();
        }
        catch (IOException i){
            System.out.println("error");
        }
    }
}

