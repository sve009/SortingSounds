package edu.grinnell.sortingvisualizer.sorts;

import java.lang.Comparable;
import edu.grinnell.sortingvisualizer.events;

public class Sorts {
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {

    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        int index = 0;

        for (int i = 1; i < arr.length; i++) {
            T temp = arr[i];

            index = i;
            while (temp.compareTo(arr[index - 1]) < 0 && index >= 1) {
                arr[index] = arr[index - 1];
                index--;
            }

            arr[index] = temp;
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr) {

    }
    
    public static <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length);
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr, int lo, int hi) {
        if (hi - lo <= 1) {
            return;
        }

        int pivot = pivot(arr, lo, hi, hi - 1);

        quickSort(arr, lo, pivot);
        quickSort(arr, pivot + 1, hi);
    }

    public static <T extends Comparable<T>> void whateverSort(T[] arr) {

    }

    public static <T extends Comparable<T>> void eventSort(T[] arr, List<SortEvent<T>> events) {
        for (SortEvent<T> se : events) {
            event.apply(arr);
        }
    }

    public static <T extends Comparable<T>> int pivot(T[] arr, int lo, int hi, int pivotIndex) {
        T pivot = arr[pivotIndex];

        int index = lo;
        for (int j = lo; j < hi; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                T temp = arr[index];
                arr[index] = arr[j];
                arr[j] = temp;
                index++;
            }
        }

        T temp = arr[index];
        arr[index] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        return index;
    }
}
