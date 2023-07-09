package Easy;
// https://www.java67.com/2014/04/java-8-stream-examples-and-tutorial.html
// Counting Empty String

import java.util.*;

public class java67_StreamEx01 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
        long count = strList.stream()
            .filter(s -> s.isEmpty())
            .count();

        System.out.println(count);

    }
}
