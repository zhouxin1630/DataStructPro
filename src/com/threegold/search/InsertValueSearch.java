package com.threegold.search;

/**
 * 插值查找算法
 * 
 * @author zhouxin
 * @since 2022/05/20
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int res = insertValueSearch(arr, 0, arr.length - 1, 90);
        System.out.println(res);
    }

    public static int insertValueSearch(int[] arr, int lo, int hi, int findValue) {
        System.out.println("hello");
        if (lo > hi || findValue < arr[0] || findValue > arr[hi]) {
            return -1;
        }
        int mid = lo + (hi - lo) * (findValue - arr[lo]) / (arr[hi] - arr[lo]);
        if (arr[mid] > findValue) {
            return insertValueSearch(arr, lo, mid - 1, findValue);
        } else if (arr[mid] < findValue) {
            return insertValueSearch(arr, mid + 1, hi, findValue);
        } else {
            return mid;
        }
    }
}
