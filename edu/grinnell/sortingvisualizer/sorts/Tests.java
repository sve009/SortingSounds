package edu.grinnell.sortingvisualizer.sorts;

import java.io.PrintWriter;
import java.util.Random;

public class Tests {
    public static void main(String[] args) {
        PrintWriter pen = new PrintWriter(System.out, true);

        testInsertionSort(pen);
        testQuickSort(pen);
    }

    public static void testInsertionSort(PrintWriter pen) {
        Integer[] arr1 = {};
        Integer[] arr2 = {0};
        Integer[] arr3 = {1, 2, 3, 4, 5};
        Integer[] arr4 = {5, 4, 3, 2, 1};
        Integer[] arr5 = {1, 2, 3, 4, 5};

        rearrange(arr5);

        pen.println();
        pen.println("Testing insertion sort");
        pen.println();

        pen.println("Array 1: ");
        printArray(arr1, pen);
        pen.println("Sorted: ");
        Sorts.insertionSort(arr1);
        printArray(arr1, pen);

        pen.println("Array 2: ");
        printArray(arr2, pen);
        pen.println("Sorted: ");
        Sorts.insertionSort(arr2);
        printArray(arr2, pen);

        pen.println("Array 3: ");
        printArray(arr3, pen);
        pen.println("Sorted: ");
        Sorts.insertionSort(arr3);
        printArray(arr3, pen);
        
        pen.println("Array 4: ");
        printArray(arr4, pen);
        pen.println("Sorted: ");
        Sorts.insertionSort(arr4);
        printArray(arr4, pen);

        pen.println("Array 5: ");
        printArray(arr5, pen);
        pen.println("Sorted: ");
        Sorts.insertionSort(arr5);
        printArray(arr5, pen);
    }

    public static void testQuickSort(PrintWriter pen) {
        Integer[] arr1 = {};
        Integer[] arr2 = {0};
        Integer[] arr3 = {1, 2, 3, 4, 5};
        Integer[] arr4 = {5, 4, 3, 2, 1};
        Integer[] arr5 = {1, 2, 3, 4, 5};

        rearrange(arr5);

        pen.println();
        pen.println("Testing insertion sort");
        pen.println();

        pen.println("Array 1: ");
        printArray(arr1, pen);
        pen.println("Sorted: ");
        Sorts.quickSort(arr1);
        printArray(arr1, pen);

        pen.println("Array 2: ");
        printArray(arr2, pen);
        pen.println("Sorted: ");
        Sorts.quickSort(arr2);
        printArray(arr2, pen);

        pen.println("Array 3: ");
        printArray(arr3, pen);
        pen.println("Sorted: ");
        Sorts.quickSort(arr3);
        printArray(arr3, pen);
        
        pen.println("Array 4: ");
        printArray(arr4, pen);
        pen.println("Sorted: ");
        Sorts.quickSort(arr4);
        printArray(arr4, pen);

        pen.println("Array 5: ");
        printArray(arr5, pen);
        pen.println("Sorted: ");
        Sorts.quickSort(arr5);
        printArray(arr5, pen);
    }
    
    public static <T> void printArray(T[] arr, PrintWriter pen) {
        for (T t : arr) {
            pen.print(t + " ");
        }
        pen.println();
    }

    public static <T> void rearrange(T[] arr) {
        int max = arr.length;

        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int i1 = rand.nextInt(max);
            int i2 = rand.nextInt(max);

            T temp = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = temp;
        }
    }
}


