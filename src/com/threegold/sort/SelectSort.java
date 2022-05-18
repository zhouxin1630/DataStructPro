package com.threegold.sort;

import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        // int[] arr = { 3, 9, -1, 10, -2 };
        // System.out.printf("排序前：%s\n", Arrays.toString(arr));
        // selectSort(arr);
        // System.out.printf("排序后：%s\n", Arrays.toString(arr));

        testSpeed();
    }

    public static void selectSort(int[] arr) {
        int min = 0;
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
    }

    public static void testSpeed() {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 80000);
        }
        Date start = new Date();
        SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate = sFormat.format(start);
        System.out.println(startDate);
        selectSort(arr);
        Date end = new Date();
        String endDate = sFormat.format(end);
        System.out.println(endDate);
    }
}
