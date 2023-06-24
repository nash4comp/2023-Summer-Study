package Chap15;

import java.io.*;

public class RandomAccessFileEx1 {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");
            System.out.println("The location of file pointer: " + raf.getFilePointer());
            raf.writeInt(100);
            System.out.println("The location of file pointer: " + raf.getFilePointer());
            raf.writeLong(100L);
            System.out.println("The location of file pointer: " + raf.getFilePointer());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
