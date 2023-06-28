package Chap13;

public class ThreadEx2 {
    public static void main(String[] args) {
        ThreadEx2_1 t1 = new ThreadEx2_1();
        ThreadEx2_1 t2 = new ThreadEx2_1();
        t1.start();
        t2.run();
    }
}

class ThreadEx2_1 extends Thread {
    public void run() {
        System.out.println(getName());
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
