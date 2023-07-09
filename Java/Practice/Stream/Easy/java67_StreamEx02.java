package Easy;
// https://www.java67.com/2014/04/java-8-stream-examples-and-tutorial.html
// Count String whose length is more than three

import java.util.*;

public class java67_StreamEx02 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("abc", "abcd", "a", "asdfsdf", "aas", "asdfsdf", "sdfsfsdf");
        long count = strList.stream()
                .filter(s -> s.length() > 3)
                .count();
        System.out.println(count);
    }
}
