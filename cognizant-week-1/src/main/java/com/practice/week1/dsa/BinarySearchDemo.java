package com.practice.week1.dsa;

/**
 * ALGORITHM: Binary Search — O(log n)
 * Requires a sorted array. Repeatedly halves the search space.
 */
public class BinarySearchDemo {

    static int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sorted = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
        System.out.println("Index of 23: " + search(sorted, 23));
        System.out.println("Index of 100: " + search(sorted, 100));
    }
}
