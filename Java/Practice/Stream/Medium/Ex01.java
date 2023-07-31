package Medium;
// ChatGPT generated problems #1

// Write a method to collect the names of all employees in a list
// that earn more than $50,000 a year, 
// sorted by their name in ascending order. 
// Assume an Employee class with name and salary fields.

import java.util.*;
import java.util.stream.Collectors;

public class Ex01 {
    public static void main(String[] args) {
        List<EmployeeData> employees = Arrays.asList(
                new EmployeeData("John", 70000),
                new EmployeeData("Jane", 60000),
                new EmployeeData("Jim", 50000),
                new EmployeeData("Jill", 40000),
                new EmployeeData("Joe", 30000),
                new EmployeeData("Alice", 75000),
                new EmployeeData("Bob", 80000),
                new EmployeeData("Charlie", 65000),
                new EmployeeData("Diana", 78000),
                new EmployeeData("Evan", 66000),
                new EmployeeData("Frank", 64000),
                new EmployeeData("Grace", 83000),
                new EmployeeData("Harry", 60000),
                new EmployeeData("Irene", 67000),
                new EmployeeData("Jack", 70000));

        List<EmployeeData> result = employees.stream()
                .filter(s -> s.getSalary() > 50000)
                .sorted(Comparator.comparing(EmployeeData::getName))
                .collect(Collectors.toList());

        result.forEach(e -> System.out.println(e.getName() + ": " + e.getSalary()));

    }
}
