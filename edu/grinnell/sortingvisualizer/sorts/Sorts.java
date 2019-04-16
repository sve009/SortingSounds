package edu.grinnell.sortingvisualizer.sorts;

import java.lang.Comparable;
import java.util.List;
import java.util.ArrayList;
import edu.grinnell.sortingvisualizer.events.SortEvent;
import edu.grinnell.sortingvisualizer.events.CompareEvent;
import edu.grinnell.sortingvisualizer.events.SwapEvent;
import edu.grinnell.sortingvisualizer.events.CopyEvent;

public class Sorts {
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {

    }

    public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(T[] arr) {
        int index = 0;

        ArrayList<SortEvent<T>> events = new ArrayList<SortEvent<T>>();

        for (int i = 1; i < arr.length; i++) {
            T temp = arr[i];

            index = i;

            ArrayList<Integer> compareIndices = new ArrayList<Integer>();
            compareIndices.add(index);
            compareIndices.add(index - 1);
            events.add(new CompareEvent<T>(compareIndices));

            while (temp.compareTo(arr[index - 1]) < 0 && index >= 1) {
                compareIndices = new ArrayList<Integer>();
                compareIndices.add(index);
                compareIndices.add(index - 1);
                events.add(new CompareEvent<T>(compareIndices));

                arr[index] = arr[index - 1];
                index--;

                events.add(new SwapEvent<T>(compareIndices));
            }

            arr[index] = temp;
            events.add(new CopyEvent<T>(temp, index));
        }

        return events;
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr) {

    }
    
    public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr) {
        return quickSort(arr, 0, arr.length, new ArrayList<SortEvent<T>>());
    }

    public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr, int lo, int hi, List<SortEvent<T>> events) {
        if (hi - lo <= 1) {
            return events;
        }

        int pivot = pivot(arr, lo, hi, hi - 1, events);

        quickSort(arr, lo, pivot, events);
        quickSort(arr, pivot + 1, hi, events);

        return events;
    }

    public static <T extends Comparable<T>> void whateverSort(T[] arr) {

    }

    public static <T extends Comparable<T>> void eventSort(T[] arr, List<SortEvent<T>> events) {
        for (SortEvent<T> se : events) {
            se.apply(arr);
        }
    }

    public static <T extends Comparable<T>> int pivot(T[] arr, int lo, int hi, int pivotIndex, List<SortEvent<T>> events) {
        T pivot = arr[pivotIndex];

        int index = lo;
        for (int j = lo; j < hi; j++) {
            ArrayList<Integer> compareIndices = new ArrayList<Integer>();
            compareIndices.add(j);
            compareIndices.add(pivotIndex);
            events.add(new CompareEvent<T>(compareIndices));

            if (arr[j].compareTo(pivot) < 0) {
                ArrayList<Integer> swapIndices = new ArrayList<Integer>();
                swapIndices.add(j);
                swapIndices.add(index);
                events.add(new SwapEvent<T>(swapIndices));

                T temp = arr[index];
                arr[index] = arr[j];
                arr[j] = temp;
                index++;
            }
        }

        ArrayList<Integer> swapIndices = new ArrayList<Integer>();
        swapIndices.add(pivotIndex);
        swapIndices.add(index);
        events.add(new SwapEvent<T>(swapIndices));

        T temp = arr[index];
        arr[index] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        return index;
    }
}
