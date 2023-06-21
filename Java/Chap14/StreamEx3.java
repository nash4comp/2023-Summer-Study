package Chap14;

import java.util.*;
import java.util.stream.*;

class Student2 implements Comparable<Student2> {
    String name;
    int classNo;
    int totalScore;

    Student2(String name, int classNo, int totalScore) {
        this.name = name;
        this.classNo = classNo;
        this.totalScore = totalScore;
    }

    public String toString() {
        return String.format("[%s, %d, %d]", name, classNo, totalScore);
    }

    String getName() {
        return name;
    }

    int getClassNo() {
        return classNo;
    }

    int getTotalScore() {
        return totalScore;
    }

    // descending order
    public int compareTo(Student2 student) {
        return this.totalScore - student.totalScore;
    }

}

public class StreamEx3 {
    public static void main(String[] args) {
        Student2[] stuArr = {
                new Student2("Tom", 3, 300),
                new Student2("Jane", 3, 200),
                new Student2("Eric", 2, 100),
                new Student2("Kiffer", 1, 150),
                new Student2("Jackie", 1, 200),
                new Student2("Alex", 2, 290),
                new Student2("Tracy", 3, 180),
                new Student2("Liana", 2, 170)
        };

        Stream<Student2> stuStream = Stream.of(stuArr);
        stuStream.sorted(Comparator.comparing(Student2::getClassNo)
                .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

        stuStream = Stream.of(stuArr);
        IntStream stuScoreStream = stuStream.mapToInt(Student2::getTotalScore);
        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        System.out.println("count: " + stat.getCount());
        System.out.println("sum: " + stat.getSum());
        System.out.printf("average: %.2f\n", stat.getAverage());
        System.out.println("min: " + stat.getMin());
        System.out.println("max: " + stat.getMax());

    }
}
