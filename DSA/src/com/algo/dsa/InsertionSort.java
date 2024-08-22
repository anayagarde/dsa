package com.algo.dsa;
/*
Stable sorting
T(n) = Best Case = O(n)
       Worst case = O(n^2)
 */
public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {3,6,17,8,4,13};
        InsertionSort is = new InsertionSort();
        is.display_array(arr, "\nUnsorted Array");
        is.insertion_sort(arr);
    }
    public void display_array(int[] arr, String text) {
        System.out.println(text);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + " ");
        }
    }
    public void insertion_sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
        // display sorted array
        display_array(arr, "\nSorted Array");
    }
}
