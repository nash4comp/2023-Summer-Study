package Chap13;

import java.util.function.*;
import java.util.*;

public class LambdaEx5 {
    public static void main(String args[]) {
        Supplier<Integer> supplier = () -> (int) (Math.random() * 100) + 1;
        Consumer<Integer> consumer = i -> System.out.print(i + ", ");
        Predicate<Integer> predicate = i -> i % 2 == 0;
        Function<Integer, Integer> function = i -> i / 10 * 10;

        List<Integer> list = new ArrayList<>();
        makeRandomList(supplier, list);
        System.out.println("Random list: " + list);

        printEvenNum(predicate, consumer, list);

        List<Integer> newList = doSomething(function, list);
        System.out.println("doSomething: " + newList);
    }

    static <T> List<T> doSomething(Function<T, T> function, List<T> list) {
        List<T> newList = new ArrayList<T>(list.size());
        for (T i : list) {
            newList.add(function.apply(i));
        }
        return newList;
    }

    static <T> void printEvenNum(Predicate<T> predicate, Consumer<T> consumer, List<T> list) {
        System.out.print("PrintEvenNum: ");
        System.out.print("[");
        for (T i : list) {
            if (predicate.test(i)) {
                consumer.accept(i);
            }
        }
        System.out.println("]");
    }

    static <T> void makeRandomList(Supplier<T> supplier, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(supplier.get());
        }
    }
}
