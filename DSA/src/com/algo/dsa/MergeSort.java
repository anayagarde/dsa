package com.algo.dsa;

/*
Merge sort works on Divide and Conquer rule
Divide array till it reaches to atomic value, then merge by comparing elements in sub arrays recursively

T(n) => BC = WC =  O(nlogn)
Merge Sort always divides the array into 2 halves and takes linear time to merge two halves.
 */
public class MergeSort {

    public static void main(String args[]) {
        MergeSort ms = new MergeSort();
        int[] arr = {2,5,7,13,8,34,76,32};
        ms.display_array(arr, "\nUnsorted Array");
        ms.merge_sort(arr, 0, arr.length - 1);
    }

    public void display_array(int[] arr, String text) {
        System.out.println(text);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + " ");
        }
    }

    void merge_sort(int[] arr, int low, int high) {
        int mid;
        if (low < high) {
            mid = (low + high) / 2;
            merge_sort(arr, low, mid);
            merge_sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] c = new int[high - low + 1];
        while(i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                c[k] = arr[i];
                i++;
            } else {
                c[k] = arr[j];
                j++;
            }
            k++;
        }
       // Add remaining elements in sorted array
        while (i <= mid) {
            c[k] = arr[i];
            i++;
            k++;
        }
        while (j <= high) {
            c[k] = arr[j];
            j++;
            k++;
        }

        for (int m = low; m <= high; m++) {
            arr[m] = c[m - low];
        }
        display_array(arr, "\nMerge and Sort");
    }
}
