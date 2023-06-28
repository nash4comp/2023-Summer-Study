package Chap15;

import java.io.*;

public class FileEx1 {
    public static void main(String[] args) {
        File f = new File("c:\\jdk\\work\\ch15\\FileEx1.java");
        String fileName = f.getName();
        int pos = fileName.lastIndexOf(".");

        System.out.println("Only file name (excluding the path): " + f.getName());
        System.out.println("Only file name (excluding the extension): " + fileName.substring(0, pos));
        System.out.println("Extension: " + fileName.substring(pos + 1));

        System.out.println("File path separator: " + File.pathSeparator);
        System.out.println("File separator: " + File.separator);

    }
}
