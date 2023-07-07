// https://www.java67.com/2014/04/java-8-stream-examples-and-tutorial.html
// Create a List with String more than 2 characters

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class java67_StreamEx05 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk", "a", "AAA");
        List<String> resultList = strList.stream()
                .filter(s -> s.length() > 2)
                .collect(Collectors.toList());
        resultList.forEach(System.out::println);
    }
}
