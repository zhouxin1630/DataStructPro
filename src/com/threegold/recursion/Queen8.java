package com.threegold.recursion;

/**
 * 八皇后问题思路：
 * 1. 第一个皇后先放第一行第一列
 * 2. 第二个皇后放在第二行第一列，然后判断是否 OK，如果不 OK 继续放在 第二列、第三列、依次把所有列都放完，找到一个合适
 * 3. 继续第三个皇后，还是第一列、第二列......直到第 8 个皇后也能放在一个不冲突的位置，算是找到了一个正确解
 * 4. 当得到一个正确解的时，在栈上回退到上一栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，全部得到。
 * 5. 然后回头继续第一个皇后放第二列，后面继续循环执行 1， 2， 3， 4 的步骤。
 * 
 * @author zhouxin
 * @since 2022/5/17
 */
public class Queen8 {

    // 定义一个 max 表示共有多少个皇后
    int max = 8;
    int count = 0;

    // 定义数组 array 保存皇后放置位置的结果
    int[] array = new int[max];

    public static void main(String[] args) {
        Queen8 obj = new Queen8();
        obj.check(0);
        System.out.println(obj.count);
    }

    // 编写一个方法，放置第 n 个皇后
    // 特别注意：check 是每一次递归时，进入到 check 方法中都有一个 for 循环
    private void check(int n) {
        if (n == max) { // 当前已经放置完了 8 个皇后
            print();
            count++;
            return;
        }

        // 依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前这个皇后 n，放到改行的第一列
            array[n] = i;
            
            // 判断当放置第 n 个皇后的时候，是否冲突
            if (judge(n)) { // 不冲突
                check(n+1); // 接着放 n+1 个皇后，即开始递归
            }

            // 如果冲突，就继续执行 array[n] = i 放到本行的下一列
        }
    }

    /**
     * 查看当我们放置第 n 个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
     * 
     * @param n 第 n 个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // 说明
            // 1. array[i] == array[n] 表示判断第 n 个皇后是否和前面的 n-1 个皇后在同一列
            // 2. Math.abs(n-i) == Math.abs(array[n]-array[i]) 表示判断第 n 个皇后是否和第 i 个皇后在同一斜线(斜率)
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    // 写一个方法可以将皇后摆放的位置打印输出
    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}