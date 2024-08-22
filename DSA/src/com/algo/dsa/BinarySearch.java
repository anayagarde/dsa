package com.algo.dsa;
import java.util.*;

/*
Needs sorted array
T(n): Best case = O(1)
      Worst Case = O(logn)
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3,5,7,4,9,2};
        BinarySearch bs = new BinarySearch();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data to be searched");
        int data = sc.nextInt();
        System.out.println("Data entered: " + data);
        int index = bs.binary_search(arr, 0, arr.length - 1, data);
        if (index >= 0) {
            System.out.println("Found data by recursive method at " + index + " position");
        } else {
            System.out.println("Data not found by recursive way");
        }
        int pos = bs.binary_search_iterative(arr, 0, arr.length - 1, data);
        if (pos >= 0) {
            System.out.println("Found data by iterative method at " + pos + " position");
        } else {
            System.out.println("Data not found by iterative method");
        }

    }

    // recursive
    public int binary_search(int[] arr, int left, int right, int data) {
        int mid;
        if (left <= right) {
            mid = (left + right) /2;
            if (arr[mid] == data) {
                return mid;
            }
            if (arr[mid] > data){
                return binary_search(arr, left, mid - 1, data);
            }
            if (arr[mid] < data) {
                return binary_search(arr, mid + 1, right, data);
            }
        }
        return -1;
    }

    // iterative
    public int binary_search_iterative(int[] arr, int left, int right, int data) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == data) {
                return mid;
            }
            if (arr[mid] > data) {
                right = mid - 1;
            }
            if (arr[mid] < data) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
