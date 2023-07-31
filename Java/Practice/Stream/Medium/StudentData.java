package Medium;
// This is a data class for medium stream problems

import java.util.*;

public class StudentData {

    List<String> courses;

    StudentData(List<String> courses) {
        this.courses = courses;
    }

    List<String> getCourses() {
        return this.courses;
    }

    public List<StudentData> setEmployeesData() {
        // Problem 6
        List<StudentData> students = Arrays.asList(
                new StudentData(Arrays.asList("Math", "Science")),
                new StudentData(Arrays.asList("Art", "Math")),
                new StudentData(Arrays.asList("Science", "Geography")));
        return students;
    }
}
