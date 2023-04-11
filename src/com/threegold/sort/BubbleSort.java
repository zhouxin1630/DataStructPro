package com.threegold.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序（Bubble Sorting）
 * - 基本思想
 * 通过对待排序序列从前向后，依次比较相邻元素的值，若发现逆序则交换，使值较大的元素逐渐从前向后移。
 * 就像水底下的水泡一样逐渐向上冒。
 */
public class BubbleSort {
    public static void main(String[] args) {
        /*
        int[] arr = { 3, 9, -1, 10, -2 };
        System.out.printf("排序前：%s\n", Arrays.toString(arr));
        bubbleSort(arr);
        System.out.printf("排序后：%s\n", Arrays.toString(arr));
        */

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 80000);
        }

        Date start = new Date();
        SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate = sFormat.format(start);
        System.out.println(startDate);
        bubbleSort(arr);
        Date end = new Date();
        String endDate = sFormat.format(end);
        System.out.println(endDate);


        /*
         * // 第一趟排序
         * for (int j = 0; j < arr.length - 1; j++) {
         * if (arr[j] > arr[j + 1]) {
         * temp = arr[j];
         * arr[j] = arr[j + 1];
         * arr[j + 1] = temp;
         * }
         * }
         * System.out.println("第一趟冒泡排序结果：");
         * System.out.println(Arrays.toString(arr));
         * 
         * // 第二趟排序
         * for (int j = 0; j < arr.length - 1 - 1; j++) {
         * if (arr[j] > arr[j + 1]) {
         * temp = arr[j];
         * arr[j] = arr[j + 1];
         * arr[j + 1] = temp;
         * }
         * }
         * System.out.println("第二趟冒泡排序结果：");
         * System.out.println(Arrays.toString(arr));
         * 
         * // 第三趟排序
         * for (int j = 0; j < arr.length - 1 - 2; j++) {
         * if (arr[j] > arr[j + 1]) {
         * temp = arr[j];
         * arr[j] = arr[j + 1];
         * arr[j + 1] = temp;
         * }
         * }
         * System.out.println("第三趟冒泡排序结果：");
         * System.out.println(Arrays.toString(arr));
         * 
         * // 第四趟排序
         * for (int j = 0; j < arr.length - 1 - 3; j++) {
         * if (arr[j] > arr[j + 1]) {
         * temp = arr[j];
         * arr[j] = arr[j + 1];
         * arr[j + 1] = temp;
         * }
         * }
         * System.out.println("第四趟冒泡排序结果：");
         * System.out.println(Arrays.toString(arr));
         */
    }

    public static void bubbleSort(int[] arr) {
        // 冒泡排序时间复杂度 O(n^2)
        int temp = 0;
        boolean flag = false; // 标识变量，表示是否发生交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }

            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
