package Chap07;

import java.util.*;

public class VectorExample {
    public static void main(String[] args) {
        Vector<String> fruits = new Vector<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        System.out.println("Size of vector: " + fruits.size());
        System.out.println("Contents of vector: " + fruits);
        System.out.println("Capacity of vector: " + fruits.capacity());



    }
}