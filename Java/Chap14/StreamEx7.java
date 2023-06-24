package Chap14;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student4 {
    String name;
    boolean isMale;
    int grade;
    int classNo;
    int score;

    Student4(String name, boolean isMale, int grade, int classNo, int score) {
        this.name = name;
        this.isMale = isMale;
        this.grade = grade;
        this.classNo = classNo;
        this.score = score;
    }

    String getName() {
        return name;
    }

    boolean isMale() {
        return isMale;
    }

    int getGrade() {
        return grade;
    }

    int getClassNo() {
        return classNo;
    }

    int getScore() {
        return score;
    }

    public String toString() {
        return String.format("[%s, %s, Grade-%d, Class-%d, Score: %3d]", name, isMale ? "Male" : "Female", grade,
                classNo, score);
    }

    enum Level {
        HIGH, MID, LOW
    };
}

public class StreamEx7 {
    public static void main(String[] args) {
        Student4[] stuArr = {
                new Student4("Tom", true, 1, 3, 270),
                new Student4("Jane", false, 1, 3, 200),
                new Student4("Eric", true, 2, 2, 100),
                new Student4("Kiffer", true, 1, 4, 150),
                new Student4("Jackie", true, 2, 1, 200),
                new Student4("Alex", true, 2, 2, 290),
                new Student4("Tracy", false, 2, 3, 180),
                new Student4("Ellen", false, 2, 1, 190),
                new Student4("Taylor", true, 3, 1, 110),
                new Student4("Alfred", true, 3, 2, 120),
                new Student4("Albert", true, 1, 3, 130),
                new Student4("Jeff", true, 1, 2, 150),
                new Student4("Bruce", true, 2, 1, 140),
                new Student4("Brenda", false, 3, 4, 120),
                new Student4("Ife", false, 2, 1, 200),
                new Student4("Nash", true, 3, 1, 300),
                new Student4("Gary", true, 3, 2, 210),
        };

        System.out.printf("1. Partitioning by gender %n");
        Map<Boolean, List<Student4>> stuByGender = Stream.of(stuArr).collect(partitioningBy(Student4::isMale));

        List<Student4> maleStudent = stuByGender.get(true);
        List<Student4> femaleStudent = stuByGender.get(false);

        for (Student4 student : maleStudent)
            System.out.println(student);
        for (Student4 student : femaleStudent)
            System.out.println(student);

        System.out.printf("%n2. Partitioning by gender + Statistics by gender%n");
        Map<Boolean, Long> stuNumByGender = Stream.of(stuArr).collect(partitioningBy(Student4::isMale, counting()));
        System.out.println("The number of male students: " + stuNumByGender.get(true));
        System.out.println("The number of female students: " + stuNumByGender.get(false));

        System.out.printf("%n3. Partitioning by gender + Score by gender%n");
        Map<Boolean, Optional<Student4>> topScoreByGender = Stream.of(stuArr)
                .collect(partitioningBy(Student4::isMale, maxBy(comparingInt(Student4::getScore))));
        System.out.println("Top score from the male students: " + topScoreByGender.get(true));
        System.out.println("Top score from the female students: " + topScoreByGender.get(false));

        Map<Boolean, Student4> topScoreByGender2 = Stream.of(stuArr).collect(partitioningBy(Student4::isMale,
                collectingAndThen(maxBy(comparingInt(Student4::getScore)), Optional::get)));
        System.out.println("Top score from the male students: " + topScoreByGender2.get(true));
        System.out.println("Top score from the female students: " + topScoreByGender2.get(false));

        System.out.printf("%n4. Multiple partitioning by failed students%n");
        Map<Boolean, Map<Boolean, List<Student4>>> failedStuByGender = Stream.of(stuArr)
                .collect(partitioningBy(Student4::isMale, partitioningBy(s -> s.getScore() <= 150)));
        List<Student4> failedMaleStu = failedStuByGender.get(true).get(true);
        List<Student4> failedFemaleStu = failedStuByGender.get(false).get(true);

        for (Student4 student : failedMaleStu)
            System.out.println(student);
        for (Student4 student : failedFemaleStu)
            System.out.println(student);

    }
}
