package Chap16;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TcpIpServer2 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(9999);
            System.out.println(getTime() + " Server is ready.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                System.out.println(getTime() + " Waiting connection.");
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + " requested connection.");
                System.out.println("getPort(): " + socket.getPort());
                System.out.println("getLocalPort(): " + socket.getLocalPort());

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                dos.writeUTF("[Notice] Test message1 from server.");
                System.out.println(getTime() + " Sent the data.");

                dos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            } // end of try-catch
        } // end of while
    } // end of main

    static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }

}
