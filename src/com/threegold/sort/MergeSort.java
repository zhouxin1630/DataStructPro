package com.threegold.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 归并排序
 * 
 * @author zhouxin
 * @since 2022/05/19
 */
public class MergeSort {
    private static int[] tmp;

    public static void main(String[] args) {
        // int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        // tmp = new int[arr.length];
        // mergeSort(arr, 0, arr.length - 1);
        // System.out.println(Arrays.toString(arr));
        testSpeed();
    }

    /**
     * 归并排序
     * 
     * @param arr 排序的原始数组
     * @param lo 左边有序序列的初始索引
     * @param hi 
     */
    public static void mergeSort(int[] arr, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2; // 这么写防止整数溢出
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    public static void merge(int[] arr, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            tmp[i] = arr[i];
        }
        
        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                arr[p] = tmp[j++];
            } else if (j == hi + 1) {
                arr[p] = tmp[i++];
            } else if (tmp[i] < tmp[j]) {
                arr[p] = tmp[i++];
            } else {
                arr[p] = tmp[j++];
            }
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
        tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        Date end = new Date();
        String endDate = sFormat.format(end);
        System.out.println(endDate);
    }
}
