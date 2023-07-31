package Medium;
// ChatGPT generated problems #1

// Write a method that returns the average age of all users in a list.
// Assume a User class with name and age fields.

import java.util.*;

public class Ex02 {
    public static void main(String[] args) {
        List<UserData> users = Arrays.asList(
                new UserData("John", 30),
                new UserData("Alice", 45),
                new UserData("Bob", 20),
                new UserData("Charlie", 54),
                new UserData("Diana", 27),
                new UserData("Evan", 35),
                new UserData("Frank", 41),
                new UserData("Tina", 52));

        OptionalDouble average = users.stream()
                .mapToInt(UserData::getAge)
                .average();

        if (average.isPresent()) {
            System.out.println("Average age: " + average.getAsDouble());
        } else {
            System.out.println("No data found");
        }
    }
}
