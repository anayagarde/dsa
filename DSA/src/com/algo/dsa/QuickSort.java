package com.algo.dsa;

/*
T(n): BC = O(nlogn)
      WC = (On^2)

Pivot taken as first element here
Divide and Conquer Rule -> Partitioning
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7,6,10,5,9,2,1,15,7};
        QuickSort qs = new QuickSort();
        qs.display_array(arr, "\nUnsorted Array");
        qs.quick_sort(arr, 0, arr.length-1);
    }

    public void display_array(int[] arr, String text) {
        System.out.println(text);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + " ");
        }
    }

    public void quick_sort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quick_sort(arr, low, p - 1);
            quick_sort(arr, p + 1, high);
        }
    }

    int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; //pivot as first element
        int i = low + 1;
        int j = high;
        do {
            while (arr[i] <= pivot && i < high) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                arr = swap(arr, i, j);
            }

        } while (i < j);
        arr = swap(arr, j, low); // swap arr[j] and pivot
        display_array(arr, "\nPartition");
        System.out.println(" || Pivot = "+ pivot);
        return j;
    }

    int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

 }
