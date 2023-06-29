package Practice;

import java.util.*;
import java.util.stream.Collectors;

// Write a Java program to convert a list of strings to uppercase or lowercase using streams.

public class StreamEx02 {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("I am IronMan.", "hello", "Bye");
        List<String> uppercase = str.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(uppercase);
        
        List<String> lowercase = str.stream()
        .map(s -> s.toLowerCase())
        .collect(Collectors.toList());
        System.out.println(lowercase);
        
    }
}
