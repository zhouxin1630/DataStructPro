package com.threegold.stack;

import java.util.Scanner;

public class ZX_ArrayStackDemo {
    public static void main(String[] args) {
        ZX_ArrayStack stack = new ZX_ArrayStack(4);
        String key = "";
        boolean loop = true; // 控制是否退出菜单
        Scanner input = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 显示栈");
            System.out.println("exit: 退出");
            System.out.println("push: 入栈");
            System.out.println("pop: 出栈");
            System.out.println("--------------------");
            System.out.println("请输入你的选择: ");
            key = input.next();
            switch (key) {
                case "exit":
                    loop = false;
                    input.close();
                    break;
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = input.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d \n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出了");
    }
}

class ZX_ArrayStack {
    private int maxSize; // 栈的大小
    private int[] stack;
    private int top;

    public ZX_ArrayStack(int _maxSize) {
        this.maxSize = _maxSize;
        this.top = -1;
        this.stack = new int[_maxSize];
    }

    // 栈满
    public boolean isFull() {
        return this.top == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[this.top--];
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("栈空");
        return stack[top];
    }

    public void push(int _val) {
        if (this.isFull()) {
            System.out.println("栈已经满了");
            return;
        }
        this.top++;
        this.stack[this.top] = _val;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~~~~");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
        System.out.println();
    }
}
