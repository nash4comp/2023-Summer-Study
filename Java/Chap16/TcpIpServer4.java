package Chap16;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TcpIpServer4 implements Runnable {
    ServerSocket serverSocket;
    Thread[] threadArr;

    public static void main(String[] args) {
        TcpIpServer4 server = new TcpIpServer4(5);
        server.start();
    } // end of main

    public TcpIpServer4(int num) {
        try {
            serverSocket = new ServerSocket(9999);
            System.out.println(getTime() + " Server is ready.");
            threadArr = new Thread[num];
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // end of try-catch

    public void start() {
        for (int i = 0; i < threadArr.length; i++) {
            threadArr[i] = new Thread(this);
            threadArr[i].start();
        }
    }

    public void run() {
        while (true) {
            try {
                System.out.println(getTime() + " Waiting connection.");

                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + " requested connection.");
                // System.out.println("getPort(): " + socket.getPort());
                // System.out.println("getLocalPort(): " + socket.getLocalPort());

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
    }

    static String getTime() {
        String name = Thread.currentThread().getName();
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date()) + name;
    }

}
