package edu.grinnell.sortingvisualizer.sorts;

import java.lang.Comparable;
import java.util.List;
import java.util.ArrayList;

import edu.grinnell.sortingvisualizer.events.SortEvent;
import edu.grinnell.sortingvisualizer.events.CompareEvent;
import edu.grinnell.sortingvisualizer.events.SwapEvent;
import edu.grinnell.sortingvisualizer.events.CopyEvent;

public class Sorts {

  public static <T> void swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }// swap(int[] arr, int i, int j)


  public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(T[] arr) {
    ArrayList<SortEvent<T>> events = new ArrayList<SortEvent<T>>();

    for (int i = 0; i < arr.length - 1; i++) {

      int lowestIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        // add compare event in log
        ArrayList<Integer> compareIndices = new ArrayList<Integer>();
        compareIndices.add(i);
        compareIndices.add(j);
        events.add(new CompareEvent<T>(compareIndices));
        // compare i and j
        if (arr[j].compareTo(arr[i]) < 0) {

          lowestIndex = j;
        } // if
      } // for

      // add compare event in log
      ArrayList<Integer> compareIndices = new ArrayList<Integer>();
      compareIndices.add(i);
      compareIndices.add(lowestIndex);
      events.add(new CompareEvent<T>(compareIndices));
      if (i != lowestIndex) {
        swap(arr, i, lowestIndex);
        // log swap event
        events.add(new SwapEvent<T>(compareIndices));
      } // if
    } // for(int i)
    return events;
  } // selectionSort(T[] arr)

  /**
   * Just a common insertionSort implementation.
   * Not super fast or anything.
   *
   * @post The array is in order from least to greatest
   * @post An array of events is returned, the array is
   *       in the order the events were called in.
   */
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

      //Shift everything over until the element to the left is <= the current
      while (index >= 1 && temp.compareTo(arr[index - 1]) < 0) {
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

  public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(T[] arr) {
    ArrayList<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
    mergeSort(arr, 0, arr.length, events);

    return events;
  }

  public static <T extends Comparable<T>> void mergeSort(T[] arr, int lb, int ub,
      List<SortEvent<T>> events) {

    // Base case. A list of zero or one elements is sorted, by definition.
    if (ub - lb <= 1) {
      return;
    } else {
      // Recursive case. First, divide the list into equal-sized sublists
      // consisting of the first half and second half of the list.
      // This assumes lists start at index 0.
      int half = ub + (lb - ub) / 2;
      mergeSort(arr, 0, half, events);
      mergeSort(arr, half, ub, events);
      merge(arr, lb, half, ub, events);
    }
  }

  public static <T extends Comparable<T>> void merge(T[] arr, int lb, int mid, int ub,
      List<SortEvent<T>> events) {
    int leftP = lb;
    int rightP = mid;

    T[] copy = (T[]) new Object[(ub - lb)];

    int i = lb;

    while (leftP < mid && rightP < ub) {
      ArrayList<Integer> compareIndices = new ArrayList<Integer>();
      compareIndices.add(leftP);
      compareIndices.add(rightP);
      events.add(new CompareEvent<T>(compareIndices));
      if (arr[leftP].compareTo(arr[rightP]) <= 0) {
        // events.add(new CopyEvent<T>(i));
        copy[i++] = arr[leftP];
        leftP++;
      } else {
        // events.add(new CopyEvent<T>(i));
        copy[i++] = arr[rightP];
        rightP++;
      }
    } // while

    // Either left or right may have elements left; consume them.
    // (Only one of the following loops will actually be entered.)
    while (leftP < mid) {
      // events.add(new CopyEvent<T>(i));
      copy[i++] = arr[leftP++];
    }
    while (rightP < ub) {
      // events.add(new CopyEvent<T>(i));
      copy[i++] = arr[rightP];
    }
    for (int j = 0; j < (ub - lb); j++) {
      //events.add(new CopyEvent<T>((lb + j)));
      arr[lb + j] = copy[j];
    } // for

  }// merge(T[] arr, int leftlb, int mid,int ub, List<SortEvent<T>> events))

  /**
   * Quicksort implementation.
   *
   * @post The array is in order from least to greatest
   * @post A list of events is returned that is in the same order the events were called in.
   */
  public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr) {
    return quickSort(arr, 0, arr.length, new ArrayList<SortEvent<T>>());
  }

  public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr, int lo, int hi,
      List<SortEvent<T>> events) {
    if (hi - lo <= 1) {
      return events;
    }

    int pivot = pivot(arr, lo, hi, hi - 1, events);

    quickSort(arr, lo, pivot, events);
    quickSort(arr, pivot + 1, hi, events);

    return events;
  }

  // based on wikipedia pseudocode//https://en.wikipedia.org/wiki/Bubble_sort#Optimizing_bubble_sort
  public static <T extends Comparable<T>> List<SortEvent<T>> bubbleSort(T[] arr) {
    ArrayList<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
    
    int n = arr.length;
    int newN=0;
    while(n<=1) {
        newN = 0;
        for(int i = 1; i<n;i++) {
          //add compare log
          ArrayList<Integer> compareIndices = new ArrayList<Integer>();
          compareIndices.add(i);
          compareIndices.add(i-1);
          events.add(new CompareEvent<T>(compareIndices));
          if( arr[i].compareTo(arr[i-1]) >0){
            events.add(new SwapEvent<T>(compareIndices));
                swap(arr, i-1, i);
                newN = i;
            }//if
        }//for
        n = newN; 
    }//while
    return events;
  }//bubbleSort(T[] arr)

  public static <T extends Comparable<T>> void eventSort(T[] arr, List<SortEvent<T>> events) {
    for (SortEvent<T> se : events) {
      se.apply(arr);
    }
  }

  public static <T extends Comparable<T>> int pivot(T[] arr, int lo, int hi, int pivotIndex,
      List<SortEvent<T>> events) {
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
