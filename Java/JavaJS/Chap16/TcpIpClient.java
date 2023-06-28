package Chap16;

import java.net.*;
import java.io.*;

public class TcpIpClient {
    public static void main(String[] args) {
        try {
            String serverIp = "127.0.0.1";
            System.out.println("Connecting server. Server IP: " + serverIp);
            Socket socket = new Socket(serverIp, 9999);

            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            System.out.println("The message from server: " + dis.readUTF());
            System.out.println("Finishing connection.");

            dis.close();
            socket.close();
            System.out.println("Connection has finished.");
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } // end of try-catch
    } // end of main
}
