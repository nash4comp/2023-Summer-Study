package Medium;
// This is a data class for medium stream problems

import java.util.*;

public class EmployeeData {
    String name;
    int salary;

    EmployeeData(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    String getName() {
        return this.name;
    }

    int getSalary() {
        return this.salary;
    }

    public static void main(String[] args) {

        // Problem 3
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "cherry", "banana");

        // Problem 4 & 5
        List<String> stringList = Arrays.asList("abc", "aaa", "ana", "bbb", "acc");
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 15, 20, 25, 30);

    }

}
