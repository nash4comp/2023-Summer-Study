package Chap15;

import java.io.*;

public class DataInputStreamEx3 {
    public static void main(String[] args) {
        int sum = 0;
        int score = 0;

        try (FileInputStream fis = new FileInputStream("score.dat");
                DataInputStream dis = new DataInputStream(fis)) {
            while (true) {
                score = dis.readInt();
                System.out.println(score);
                sum += score;
            }
        } catch (EOFException e) {
            System.out.println("Total score: " + sum);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
