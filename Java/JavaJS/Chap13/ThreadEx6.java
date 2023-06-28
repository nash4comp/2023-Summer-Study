package Chap13;

import javax.swing.JOptionPane;

public class ThreadEx6 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Please enter any sting.");
        System.out.println("You entered " + input + ".");

        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

}
