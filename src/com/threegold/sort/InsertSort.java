package com.threegold.sort;

import java.util.Arrays;

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
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
            System.out.printf("第 %d 轮插入后\n", i);
            System.out.println(Arrays.toString(arr));
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
        System.out.println("第 1 轮插入后");
        System.out.println(Arrays.toString(arr));

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
    }
}
