package com.threegold.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 快速排序 —— 对冒泡排序的改进
 * 
 * @author zhouxin
 * @since 2022/05/19
 */
public class QuickSort {
    public static void main(String[] args) {
        testSpeed();
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        int left = lo;
        int right = hi;
        int pivot = arr[(left + right) / 2];

        while (left < right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left >= right) {
                break;
            }

            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;

            if (arr[left] == pivot) {
                right--;
            }
            if (arr[right] == pivot) {
                left++;
            }
        }

        if (left == right) {
            left++;
            right--;
        }

        // 向左递归
        if (lo < right) {
            quickSort(arr, lo, right);
        }
        if (hi > left) {
            quickSort(arr, left, hi);
        }
    }

    public static void testSpeed() {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        Date start = new Date();
        SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate = sFormat.format(start);
        System.out.println(startDate);
        quickSort(arr, 0, arr.length - 1);
        Date end = new Date();
        String endDate = sFormat.format(end);
        System.out.println(endDate);
    }
}
