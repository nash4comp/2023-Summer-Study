package Chap13;

public class ThreadEx4 {
    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }
        System.out.print("Elapsed time: " + (System.currentTimeMillis() - startTime));
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }
        System.out.print("Elapsed time: " + (System.currentTimeMillis() - startTime));
    }
}
