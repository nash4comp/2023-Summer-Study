package Chap11;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx1 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("myId", "1234");
        map.put("asdf", "1111");
        map.put("asdf", "1234");

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter your ID and Password.");
            System.out.print("ID: ");
            String id = s.nextLine().trim();

            System.out.print("Password: ");
            String password = s.nextLine().trim();
            System.out.println();

            if (!map.containsKey(id)) {
                System.out.println("The ID does not exist. Please enter the correct ID.");
                continue;
            } else {
                if (!(map.get(id)).equals(password)) {
                    System.out.println("Not matched the password. Please enter the correct password.");
                } else {
                    System.out.println("ID and Password are correctly matched.");
                    break;
                }
            }

        }
    }
}
