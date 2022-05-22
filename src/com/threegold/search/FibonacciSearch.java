package com.threegold.search;

import java.util.Arrays;

/**
 * 斐波那契搜索算法
 * 
 * @author zhouxin
 * @since 2022/05/20
 */
public class FibonacciSearch {

    public static final int MAXSIZE = 20;

    public static void main(String[] args) {
        int[] arr = { 1, 8, 10, 89, 1000, 1234 };
        System.out.println(fibonacciSearch(arr, 189));
    }

    /**
     * 获取一个斐波那契数列
     * 使用非递归的方法获取
     * 
     * @return
     */
    public static int[] fib() {
        int[] f = new int[MAXSIZE];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < MAXSIZE; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 斐波那契查找算法
     * 
     * @param arr 数组
     * @param key 需要查找的关键码
     * @return 对应的下标
     */
    public static int fibonacciSearch(int[] arr, int key) {
        int low = 0;
        int hi = arr.length - 1;
        int k = 0; // 表示斐波那契分割数值的下标
        int mid = 0; // 存放 mid 值
        int[] f = fib(); // 获取到斐波那契数列

        // 获取斐波那契分割数值的下标
        while (hi > f[k] - 1) {
            k++;
        }

        // 因为 f[k] 值可能大于数组的长度
        // 不足的部分会使用 0 填充
        int[] tmp = Arrays.copyOf(arr, f[k]);

        // 用数组的最后一个元素来扩展
        for (int i = hi + 1; i < tmp.length; i++) {
            tmp[i] = arr[hi];
        }

        while (low <= hi) {
            mid = low + f[k - 1] - 1; // 借助斐波纳契数确定位置
            if (key < tmp[mid]) {
                hi = mid - 1;
                /*
                为什么是 k-- ？
                说明：
                    1. 全部元素 = 前面的元素 + 后面的元素
                    2. f[k] = f[k - 1] + f[k - 2]
                因为前面有 f[k - 1] 个元素，所以可以继续拆分 f[k - 1] = f[k - 2] + f[k - 3]
                即在 f[k - 1] 的前部分继续查找
                */
                k--;
            } else if (key > tmp[mid]) { // 我们应该在数组的后半部分进行查找
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= hi) {
                    return mid;
                } else {
                    return hi;
                }
            }
        }
        return -1;
    }
}
