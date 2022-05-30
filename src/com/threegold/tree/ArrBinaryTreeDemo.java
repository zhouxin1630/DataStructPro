package com.threegold.tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}

/**
 * 顺序存储二叉树
 * 
 * @author zhouxin
 * @since 2022/05/29
 */
class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] _arr) {
        this.arr = _arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    /**
     * 顺序存储二叉树的前序遍历
     * 
     * @param index 数组的下标
     */
    private void preOrder(int index) {
        if (null == arr || 0 == arr.length) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        System.out.println(arr[index]);
        if ((2 * index + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        if ((2 * index + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}
