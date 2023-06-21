package Chap13;

import java.util.function.*;
import java.util.*;

public class LambdaEx6 {
    public static void main(String[] args) {
        IntSupplier supplier = () -> (int) (Math.random() * 100) + 1;
        IntConsumer consumer = i -> System.out.print(i + ", ");
        IntPredicate predicate = i -> i % 2 == 0;
        IntUnaryOperator operator = i -> i / 10 * 10;

        int[] arr = new int[10];

        makeRandomList(supplier, arr);
        System.out.println(Arrays.toString(arr));

        printEvenNum(predicate, consumer, arr);
        int[] newArr = doSomething(operator, arr);
        System.out.println(Arrays.toString(newArr));
    }

    static void makeRandomList(IntSupplier supplier, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = supplier.getAsInt();
        }
    }

    static void printEvenNum(IntPredicate predicate, IntConsumer consumer, int[] arr) {
        System.out.print("[");
        for (int i : arr) {
            if (predicate.test(i)) {
                consumer.accept(i);
            }
        }
        System.out.println("]");
    }

    static int[] doSomething(IntUnaryOperator operator, int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = operator.applyAsInt(arr[i]);
        }
        return newArr;
    }
}
