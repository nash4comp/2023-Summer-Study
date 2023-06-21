package Chap14;

import java.util.*;
import java.util.stream.*;

public class StreamEx {
    public static void main(String[] args) {
        IntStream intStream = new Random().ints(1, 46);
        Stream<String> lottoStream = intStream.distinct().limit(6).sorted().mapToObj(i -> i +",");
        lottoStream.forEach(System.out::print);
        
    }
    
}
