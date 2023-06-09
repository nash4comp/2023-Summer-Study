package Chap16;

import java.net.*;
import java.io.*;

public class TcpIpClient5 {
    public static void main(String[] args) {
        try {
            String serverIp = "127.0.0.1";
            Socket socket = new Socket(serverIp, 9999);

            System.out.println("Connected server.");

            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
