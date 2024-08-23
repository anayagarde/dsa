package com.algo.dsa;

/*
Selection sort
Unstable sorting
Tn => BC = O(n^2)
      WC = O(n^2)

Find min element from unsorted array and place at first location of the unsorted array.
With every pass unsorted array decreases by 1 and sorted array increases by 1.
 */
public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort sc = new SelectionSort();
        int[] arr = {3,6,12,45,8,68};
        sc.display_array(arr, "\nUnsorted Array");
        sc.selection_sort(arr);
    }

    public void display_array(int[] arr, String text) {
        System.out.println(text);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + " ");
        }
    }
    public void selection_sort(int[] arr) {
        for (int i = 0; i< arr.length - 1; i++) { // n-1 passes
            int minpos = i; // code for finding min element in unsorted array
            for (int j = i+1; j< arr.length; j++) {
                if (arr[j] < arr[minpos]) {
                    minpos = j;
                }
            }
            if (minpos != i) { //swap (arr[i], arr[minpos])
                int temp = arr[minpos];
                arr[minpos] = arr[i];
                arr[i] = temp;
            }
        }
        display_array(arr, "\nSorted Array");
    }
}
