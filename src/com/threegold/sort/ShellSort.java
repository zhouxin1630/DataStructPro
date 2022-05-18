package com.threegold.sort;

import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 希尔排序
 * 
 * @author zhouxin
 * @since 2022/05/18
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
        // shellSort_change(arr);
        testSpeed();
    }

    // 逐步推导的方式来编写希尔排序
    public static void shellSort_tuiyan(int[] arr) {
        // 第一轮
        // 有 5 组
        for (int i = 5; i < arr.length; i++) {
            // 遍历各组中所有的数组(共有五组，每组两个元素)
            for (int j = i - 5; j >= 0; j -= 5) {
                // 如果当前元素大于加上步长的元素，说明需要交换
                if (arr[j] > arr[j + 5]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = tmp;
                }
            }
        }
        System.out.printf("希尔排序第 1 轮后：%s\n", Arrays.toString(arr));

        // 第 2 轮：将 10 个数据分成了 5/2=2 组
        for (int i = 2; i < arr.length; i++) {
            // 遍历各组中所有的数组(共有五组，每组两个元素)
            for (int j = i - 2; j >= 0; j -= 2) {
                // 如果当前元素大于加上步长的元素，说明需要交换
                if (arr[j] > arr[j + 2]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = tmp;
                }
            }
        }
        System.out.printf("希尔排序第 2 轮后：%s\n", Arrays.toString(arr));

        // 第 3 轮：将 10 个数据分成了 2/2=1 组
        for (int i = 1; i < arr.length; i++) {
            // 遍历各组中所有的数组(共有五组，每组两个元素)
            for (int j = i - 1; j >= 0; j -= 1) {
                // 如果当前元素大于加上步长的元素，说明需要交换
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.printf("希尔排序第 3 轮后：%s\n", Arrays.toString(arr));
    }

    /**
     * 希尔排序 —— 交换法
     * 
     * @param arr
     */
    public static void shellSort_change(int[] arr) {
        for (int gap = arr.length / 2, level = 1; gap > 0; gap /= 2, level++) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = tmp;
                    }
                }
            }
            // System.out.printf("希尔排序第 %d 轮后：%s\n", level, Arrays.toString(arr));
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
        shellSort_change(arr);
        Date end = new Date();
        String endDate = sFormat.format(end);
        System.out.println(endDate);
    }
}
