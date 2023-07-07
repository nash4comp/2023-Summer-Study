// https://www.java67.com/2014/04/java-8-stream-examples-and-tutorial.html
// Remove all empty Strings from List

import java.util.*;
import java.util.stream.Collectors;

public class java67_StreamEx04 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
        List<String> resultStr = strList.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        resultStr.forEach(System.out::println);

    }
}
