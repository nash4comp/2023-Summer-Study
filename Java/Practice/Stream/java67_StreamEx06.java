// https://www.java67.com/2014/04/java-8-stream-examples-and-tutorial.html
// Convert String to uppercase and Join them with coma

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class java67_StreamEx06 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk", "a", "AAA");
        String resultList = strList.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.joining(", "));

        System.out.println(resultList);
    }
}
