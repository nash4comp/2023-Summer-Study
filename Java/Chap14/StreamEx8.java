package Chap14;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student5 {
    String name;
    boolean isMale;
    int grade;
    int classNo;
    int score;

    Student5(String name, boolean isMale, int grade, int classNo, int score) {
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

public class StreamEx8 {
    public static void main(String[] args) {
        Student5[] stuArr = {
                new Student5("Tom", true, 1, 3, 270),
                new Student5("Jane", false, 1, 3, 200),
                new Student5("Eric", true, 2, 2, 100),
                new Student5("Kiffer", true, 1, 4, 150),
                new Student5("Jackie", true, 2, 1, 200),
                new Student5("Alex", true, 2, 2, 290),
                new Student5("Tracy", false, 2, 3, 180),
                new Student5("Ellen", false, 2, 1, 190),
                new Student5("Taylor", true, 3, 1, 110),
                new Student5("Alfred", true, 3, 2, 120),
                new Student5("Albert", true, 1, 3, 130),
                new Student5("Jeff", true, 1, 2, 150),
                new Student5("Bruce", true, 2, 1, 140),
                new Student5("Brenda", false, 3, 4, 120),
                new Student5("Ife", false, 2, 1, 200),
                new Student5("Nash", true, 3, 1, 300),
                new Student5("Gary", true, 3, 2, 210),
        };

        System.out.printf("1. Partitioning by gender %n");
        Map<Boolean, List<Student5>> stuByGender = Stream.of(stuArr).collect(partitioningBy(Student5::isMale));

        List<Student5> maleStudent = stuByGender.get(true);
        List<Student5> femaleStudent = stuByGender.get(false);

        for (Student5 student : maleStudent)
            System.out.println(student);
        for (Student5 student : femaleStudent)
            System.out.println(student);

        System.out.printf("%n2. Partitioning by gender + Statistics by gender%n");
        Map<Boolean, Long> stuNumByGender = Stream.of(stuArr).collect(partitioningBy(Student5::isMale, counting()));
        System.out.println("The number of male students: " + stuNumByGender.get(true));
        System.out.println("The number of female students: " + stuNumByGender.get(false));

        System.out.printf("%n3. Partitioning by gender + Score by gender%n");
        Map<Boolean, Optional<Student5>> topScoreByGender = Stream.of(stuArr)
                .collect(partitioningBy(Student5::isMale, maxBy(comparingInt(Student5::getScore))));
        System.out.println("Top score from the male students: " + topScoreByGender.get(true));
        System.out.println("Top score from the female students: " + topScoreByGender.get(false));

        Map<Boolean, Student5> topScoreByGender2 = Stream.of(stuArr).collect(partitioningBy(Student5::isMale,
                collectingAndThen(maxBy(comparingInt(Student5::getScore)), Optional::get)));
        System.out.println("Top score from the male students: " + topScoreByGender2.get(true));
        System.out.println("Top score from the female students: " + topScoreByGender2.get(false));

        System.out.printf("%n4. Multiple partitioning by failed students%n");
        Map<Boolean, Map<Boolean, List<Student5>>> failedStuByGender = Stream.of(stuArr)
                .collect(partitioningBy(Student5::isMale, partitioningBy(s -> s.getScore() <= 150)));
        List<Student5> failedMaleStu = failedStuByGender.get(true).get(true);
        List<Student5> failedFemaleStu = failedStuByGender.get(false).get(true);

        for (Student5 student : failedMaleStu)
            System.out.println(student);
        for (Student5 student : failedFemaleStu)
            System.out.println(student);

        System.out.printf("%n5. Simple grouping by class%n");
        Map<Integer, List<Student5>> stuByClass = Stream.of(stuArr).collect(groupingBy(Student5::getClassNo));
        for (List<Student5> classNo : stuByClass.values()) {
            for (Student5 student : classNo) {
                System.out.println(student);
            }
        }

        System.out.printf("%n6. Simple grouping by score%n");
        Map<Student5.Level, List<Student5>> stuByLevel = Stream.of(stuArr).collect(groupingBy(s -> {
            if (s.getScore() >= 200)
                return Student5.Level.HIGH;
            else if (s.getScore() >= 100)
                return Student5.Level.MID;
            else
                return Student5.Level.LOW;
        }));

        TreeSet<Student5.Level> keySet = new TreeSet<>(stuByLevel.keySet());
        for (Student5.Level key : keySet) {
            System.out.println("[" + key + "]");
            for (Student5 student : stuByLevel.get(key))
                System.out.println(student);
            System.out.println();
        }

        System.out.printf("%n7. Simple grouping + statistics of score%n");
        Map<Student5.Level, Long> stuCntByLevel = Stream.of(stuArr).collect(groupingBy(s -> {
            if (s.getScore() >= 200)
                return Student5.Level.HIGH;
            else if (s.getScore() >= 100)
                return Student5.Level.MID;
            else
                return Student5.Level.LOW;
        }, counting()));
        for (Student5.Level key : stuCntByLevel.keySet())
            System.out.printf("[%s] - %d, ", key, stuCntByLevel.get(key));
        System.out.println();

        for (List<Student5> level : stuByLevel.values()) {
            System.out.println();
            for (Student5 student : level) {
                System.out.println(student);
            }
        }

        System.out.printf("%n8. Multiple grouping by grade, class%n");
        Map<Integer, Map<Integer, List<Student5>>> stuByGradeAndClass = Stream.of(stuArr)
                .collect(groupingBy(Student5::getGrade, groupingBy(Student5::getClassNo)));
        for (Map<Integer, List<Student5>> grade : stuByGradeAndClass.values()) {
            for (List<Student5> classNo : grade.values()) {
                System.out.println();
                for (Student5 student : classNo)
                    System.out.println(student);
            }
        }

        System.out.printf("%n9. Multiple grouping by grade, class + statistics%n");
        Map<Integer, Map<Integer, Student5>> topStuByGradeAndClass = Stream.of(stuArr)
                .collect(groupingBy(Student5::getGrade, groupingBy(Student5::getClassNo,
                        collectingAndThen(maxBy(comparingInt(Student5::getScore)), Optional::get))));

        for (Map<Integer, Student5> classNo : topStuByGradeAndClass.values())
            for (Student5 s : classNo.values())
                System.out.println(s);

        System.out.printf("%n10. Multiple grouping by grade, grade, class + statistics%n");
        Map<String, Set<Student5.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(groupingBy(s -> s.getGrade() + " - " + s.getClassNo(),
                        mapping(s -> {
                            if (s.getScore() >= 200)
                                return Student5.Level.HIGH;
                            else if (s.getScore() >= 100)
                                return Student5.Level.MID;
                            else
                                return Student5.Level.LOW;
                        }, toSet())));

        Set<String> keySet2 = stuByScoreGroup.keySet();
        for (String key : keySet2) {
            System.out.println("[" + key + "]" + stuByScoreGroup.get(key));
        }

    }
}
