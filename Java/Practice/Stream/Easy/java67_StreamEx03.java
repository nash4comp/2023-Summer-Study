package Easy;
// https://www.java67.com/2014/04/java-8-stream-examples-and-tutorial.html
// Count number of String which starts with "a"

import java.util.*;

public class java67_StreamEx03 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("abc", "abcd", "a", "asdfsdf", "aas", "asdfsdf", "sdfsfsdf");
        long count = strList.stream()
                .filter(s -> s.charAt(0) == 'a')
                .count();
        System.out.println(count);

    }

}
