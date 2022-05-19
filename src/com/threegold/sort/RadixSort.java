package com.threegold.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 基数排序(桶排序)
 * 
 * @author zhouxin
 * @since 2022/05/19
 */
public class RadixSort {
    public static void main(String[] args) {
        // int[] arr = { 53, 3, 542, 748, 14, 214 };
        // radixSort(arr);
        testSpeed();
    }

    public static void radixSort_tuiyan(int[] arr) {
        // 定义一个二维数组，表示 10 个桶
        int[][] bucket = new int[10][arr.length];

        // 记录各个桶中放入数据的个数
        int[] bucketEleCounts = new int[10];

        // 第 1 轮：针对每个元素的个位进行排序
        for (int item : arr) {
            int index = item % 10;
            bucket[index][bucketEleCounts[index]++] = item;
        }
        // 输出第 1 轮排序的结果
        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < bucketEleCounts[i]; j++) {
                arr[k++] = bucket[i][j];
            }
            bucketEleCounts[i] = 0;
        }
        System.out.print("第一轮排序的结果: ");
        System.out.println(Arrays.toString(arr));

        // 第 2 轮：针对每个元素的个位进行排序
        for (int item : arr) {
            int index = (item / 10) % 10;
            bucket[index][bucketEleCounts[index]++] = item;
        }
        // 输出第 2 轮排序的结果
        k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < bucketEleCounts[i]; j++) {
                arr[k++] = bucket[i][j];
            }
            bucketEleCounts[i] = 0;
        }
        System.out.print("第二轮排序的结果: ");
        System.out.println(Arrays.toString(arr));

        // 第 3 轮：针对每个元素的个位进行排序
        for (int item : arr) {
            int index = (item / 100) % 10;
            bucket[index][bucketEleCounts[index]++] = item;
        }
        // 输出第 3 轮排序的结果
        k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < bucketEleCounts[i]; j++) {
                arr[k++] = bucket[i][j];
            }
            bucketEleCounts[i] = 0;
        }
        System.out.print("第三轮排序的结果: ");
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        int maxLength = String.valueOf(max).length();
        int k = 0;

        // 定义一个二维数组，表示 10 个桶
        int[][] bucket = new int[10][arr.length];

        // 记录各个桶中放入数据的个数
        int[] bucketEleCounts = new int[10];

        for (int p = 0, n = 1; p < maxLength; p++, n *= 10) {
            for (int item : arr) {
                int index = (item / n) % 10;
                bucket[index][bucketEleCounts[index]++] = item;
            }
            // 输出第 3 轮排序的结果
            k = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < bucketEleCounts[i]; j++) {
                    arr[k++] = bucket[i][j];
                }
                bucketEleCounts[i] = 0;
            }
        }
        // System.out.printf("最终结果: %s\n", Arrays.toString(arr));
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
        radixSort(arr);
        Date end = new Date();
        String endDate = sFormat.format(end);
        System.out.println(endDate);
    }
}
