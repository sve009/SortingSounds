package edu.grinnell.sortingvisualizer.sorts;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Tests {
  @Test
  void testMergeSort() {
    Integer[] sortedArr = {1, 2, 3, 4, 5};
    Integer[] arr1 = {};
    Integer[] sArr1 = {};
    Integer[] arr2 = {0};
    Integer[] sArr2 = {0};
    Integer[] arr3 = {1, 2, 3, 4, 5};
    Integer[] arr4 = {5, 4, 3, 2, 1};
    Integer[] arr5 = {1, 2, 3, 4, 5};
    
    Sorts.mergeSort(arr1);
    assertArrayEquals(sArr1, arr1);
    
    Sorts.mergeSort(arr2);
    assertArrayEquals(sArr2, arr2);
    
    Sorts.mergeSort(arr3);
    assertArrayEquals(sortedArr, arr3);
    
    Sorts.mergeSort(arr4);
    assertArrayEquals(sortedArr, arr4);
    
    for (int i = 0; i < 50; i++) {
      rearrange(arr5);
      Sorts.mergeSort(arr5);
      assertArrayEquals(sortedArr, arr5);
    }
    
  }
  @Test
  void testSelectionSort() {
   
    Integer[] sortedArr = {1, 2, 3, 4, 5};
    Integer[] arr1 = {};
    Integer[] sArr1 = {};
    Integer[] arr2 = {0};
    Integer[] sArr2 = {0};
    Integer[] arr3 = {1, 2, 3, 4, 5};
    Integer[] arr4 = {5, 4, 3, 2, 1};
    Integer[] arr5 = {1, 2, 3, 4, 5};
    
    Sorts.selectionSort(arr1);
    assertArrayEquals(sArr1, arr1);
    
    Sorts.selectionSort(arr2);
    assertArrayEquals(sArr2, arr2);
    
    Sorts.selectionSort(arr3);
    assertArrayEquals(sortedArr, arr3);
    
    Sorts.selectionSort(arr4);
    assertArrayEquals(sortedArr, arr4);
    
    for (int i = 0; i < 50; i++) {
      rearrange(arr5);
      Sorts.selectionSort(arr5);
      assertArrayEquals(sortedArr, arr5);
    }
    
  }@Test
  void testQuickSort() {
    Integer[] sortedArr = {1, 2, 3, 4, 5};
    Integer[] arr1 = {};
    Integer[] sArr1 = {};
    Integer[] arr2 = {0};
    Integer[] sArr2 = {0};
    Integer[] arr3 = {1, 2, 3, 4, 5};
    Integer[] arr4 = {5, 4, 3, 2, 1};
    Integer[] arr5 = {1, 2, 3, 4, 5};

    Sorts.quickSort(arr1);
    assertArrayEquals(sArr1, arr1);
    
    Sorts.quickSort(arr2);
    assertArrayEquals(sArr2, arr2);
    
    Sorts.quickSort(arr3);
    assertArrayEquals(sortedArr, arr3);
    
    Sorts.quickSort(arr4);
    assertArrayEquals(sortedArr, arr4);
    
    for (int i = 0; i < 50; i++) {
      rearrange(arr5);
      Sorts.quickSort(arr5);
      assertArrayEquals(sortedArr, arr5);
    }
    
  }
  
  @Test
  void testInsertionSort() {
    Integer[] sortedArr = {1, 2, 3, 4, 5};
    Integer[] arr1 = {};
    Integer[] sArr1 = {};
    Integer[] arr2 = {0};
    Integer[] sArr2 = {0};
    Integer[] arr3 = {1, 2, 3, 4, 5};
    Integer[] arr4 = {5, 4, 3, 2, 1};
    Integer[] arr5 = {1, 2, 3, 4, 5};
    
    Sorts.insertionSort(arr1);
    assertArrayEquals(sArr1, arr1);
    
    Sorts.insertionSort(arr2);
    assertArrayEquals(sArr2, arr2);
    
    Sorts.insertionSort(arr3);
    assertArrayEquals(sortedArr, arr3);
    
    Sorts.insertionSort(arr4);
    assertArrayEquals(sortedArr, arr4);
    
    for (int i = 0; i < 50; i++) {
      rearrange(arr5);
      Sorts.insertionSort(arr5);
      assertArrayEquals(sortedArr, arr5);
    }
    
  }
  
  @Test
  void testBubbleSort() {
    Integer[] sortedArr = {1, 2, 3, 4, 5};
    Integer[] arr1 = {};
    Integer[] sArr1 = {};
    Integer[] arr2 = {0};
    Integer[] sArr2 = {0};
    Integer[] arr3 = {1, 2, 3, 4, 5};
    Integer[] arr4 = {5, 4, 3, 2, 1};
    Integer[] arr5 = {1, 2, 3, 4, 5};
    
    Sorts.bubbleSort(arr1);
    assertArrayEquals(sArr1, arr1);
    
    Sorts.bubbleSort(arr2);
    assertArrayEquals(sArr2, arr2);
    
    Sorts.bubbleSort(arr3);
    assertArrayEquals(sortedArr, arr3);
    
    Sorts.bubbleSort(arr4);
    assertArrayEquals(sortedArr, arr4);
    
    for (int i = 0; i < 50; i++) {
      rearrange(arr5);
      Sorts.bubbleSort(arr5);
      assertArrayEquals(sortedArr, arr5);
    }
    
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


