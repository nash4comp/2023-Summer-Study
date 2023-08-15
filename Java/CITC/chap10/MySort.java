package CITC.chap10;

import java.time.*;

public class MySort {

    static long myBubbleSort(int arr[]) {
        Instant start = Instant.now();
        int i, j, temp;
        int n = arr.length;
        boolean swapped;

        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
        // This requires O(N^2) time complexity

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        return timeElapsed.toNanos();
    }

    static long mySelectionSort(int arr[]) {
        Instant start = Instant.now();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        return timeElapsed.toNanos();
    }

    static long myInsertionSort(int arr[]) {
        Instant start = Instant.now();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        return timeElapsed.toNanos();
    }

    static void printArray(int arr[]) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 25, 15, 10, 4, 12, 22, 18, 24, 31, 35, 44, 50, 70, 66, 90 };
        System.out.print("Bubble sort: ");
        myBubbleSort(arr);
        printArray(arr);

        arr = new int[] { 25, 15, 10, 4, 12, 22, 18, 24, 31, 35, 44, 50, 70, 66, 90 };
        System.out.print("Selection sort: ");
        mySelectionSort(arr);
        printArray(arr);

        arr = new int[] { 25, 15, 10, 4, 12, 22, 18, 24, 31, 35, 44, 50, 70, 66, 90 };
        System.out.print("Insertion sort: ");
        myInsertionSort(arr);
        printArray(arr);
    }

}
