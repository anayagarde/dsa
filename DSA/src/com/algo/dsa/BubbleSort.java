package com.algo.dsa;

/*
n elements -> n-1 passes and n-1-i comparisons
T(n) => Best case = O(n)
        Worst Case = O(n^2)
 */

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3,8,16,5,9};
        BubbleSort bs = new BubbleSort();
        bs.display_array(arr, "\nUnsorted Array");
        bs.bubble_sort(arr);
        bs.bubble_sort_optimized(arr);
    }

    public void display_array(int[] arr, String text) {
        System.out.println(text);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + " ");
        }
    }

    public void bubble_sort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        // display sorted array
        display_array(arr, "\nSorted Array");
    }

    void bubble_sort_optimized(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            int flag = 0;
            for(int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0){
                display_array(arr, "\nSorted Array in optimized algorithm");
                System.out.println("\nOnly " + (i+1) + " passes required to sort array");
                break;
            }
        }
    }

}
