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

    /**
     * The function "merge" takes an array, divides it into two subarrays, and
     * copies the elements of the
     * subarrays into separate arrays.
     * 
     * @param arr    The input array that needs to be merged. It is an array of
     *               integers.
     * @param left   The index of the leftmost element of the subarray to be merged.
     * @param middle The "middle" parameter represents the index of the middle
     *               element in the array. It is
     *               used to divide the array into two subarrays for merging.
     * @param right  The parameter "right" represents the index of the rightmost
     *               element in the array or
     *               subarray that needs to be merged.
     */
    static private void merge(int arr[], int left, int middle, int right) {
        // Find the sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    static private void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    static long myMergeSort(int[] arr) {
        Instant start = Instant.now();
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
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

        arr = new int[] { 25, 15, 10, 4, 12, 22, 18, 24, 31, 35, 44, 50, 70, 66, 90 };
        System.out.print("Merge sort: ");
        myMergeSort(arr);
        printArray(arr);

    }

}
