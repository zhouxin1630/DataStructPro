package com.threegold.search;

/**
 * 二分查找算法
 * 
 * @author zhouxin
 * @since 2022/05/19
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 8, 10, 89, 1000, 1000, 1000, 1234 };
        test(arr, 0, arr.length - 1, 12345);
        // int index = binarySearch(arr, 0, arr.length - 1, 1234);
        // System.out.println(index);
    }

    public static int binarySearch(int[] arr, int left, int right, int value) {
        if (left > right)
            return -1;
        int mid = left + (right - left) / 2;
        if (arr[mid] > value) { // 向左递归
            return binarySearch(arr, left, mid - 1, value);
        } else if (arr[mid] < value) { // 向右递归
            return binarySearch(arr, mid + 1, right, value);
        } else {
            return mid;
        }
    }

    public static void test(int[] arr, int left, int right, int value) {
        int lo = left;
        int hi = right;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < value) {
                lo = mid + 1;
            } else if (arr[mid] > value) {
                hi = mid - 1;
            } else {
                System.out.println("找到了，下标是: " + mid);
                break;
            }
        }
    }
}
