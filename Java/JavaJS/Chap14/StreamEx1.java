package Chap14;

import java.util.*;
import java.util.stream.*;

class Student implements Comparable<Student> {
    String name;
    int classNo;
    int totalScore;
    
    Student(String name, int classNo, int totalScore) {
        this.name = name;
        this.classNo = classNo;
        this.totalScore = totalScore;
    }

    public String toString() {
        return String.format("[%s, %d, %d]", name, classNo, totalScore);
    }

    String getName() { return name; }
    int getClassNo() { return classNo; }
    int getTotalScore() { return totalScore; }

    // descending order
    public int compareTo (Student student) {
        return this.totalScore - student.totalScore;
    }
}

public class StreamEx1 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
            new Student("Tom", 3, 300),
            new Student("Jane",3 ,200 ),
            new Student("Eric",2 ,100 ),
            new Student("Kiffer",1 ,150 ),
            new Student("Jackie",1 ,200 ),
            new Student("Alex",2 ,290 ),
            new Student("Tracy",3 ,180 ),
            new Student("Liana",2 ,170 )
        );
        studentStream.sorted(Comparator.comparing(Student::getClassNo)
            .thenComparing(Comparator.naturalOrder()))
            .forEach(System.out::println);
    }
}
