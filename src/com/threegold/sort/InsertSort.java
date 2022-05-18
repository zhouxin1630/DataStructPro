package com.threegold.sort;

import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 插入排序
 * 插入排序属于内部排序法，是对于欲排序的元素以插入的方式寻找合适的位置，已达到排序的目的。
 * 
 * @author zhouxin
 * @since 2022/05/18
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = { 101, 34, 119, 1 };
        // insertSort(arr);
        testSpeed();
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) { // 说明当前插入位置就是正确的位置
                arr[insertIndex + 1] = insertVal;
            }
            // System.out.printf("第 %d 轮插入后\n", i);
            // System.out.println(Arrays.toString(arr));
        }
    }

    public static void insertSort_tuiyan(int[] arr) {
        // 第 1 轮
        int insertVal = arr[1];
        int insertIndex = 1 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        // 当退出 while 时，说明插入位置找到
        arr[insertIndex + 1] = insertVal;
        // System.out.println("第 1 轮插入后");
        // System.out.println(Arrays.toString(arr));

        // 第 2 轮
        insertVal = arr[2];
        insertIndex = 2 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第 2 轮插入后");
        System.out.println(Arrays.toString(arr));

        // 第 3 轮
        insertVal = arr[3];
        insertIndex = 3 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第 3 轮插入后");
        System.out.println(Arrays.toString(arr));
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
        insertSort(arr);
        Date end = new Date();
        String endDate = sFormat.format(end);
        System.out.println(endDate);
    }
}
