package com.threegold.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "300+2*6-2";
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        int index = 0;  // 用于扫描的索引
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';  // 将每次扫描得到的结果存储到 ch 中
        String keepNum = "";  // 用于拼接多位数的
        
        while (true) {
            ch = expression.substring(index, index+1).charAt(0);
            if (operStack.isOper(ch)) {
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                } else {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.calc(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);   
                    } else {
                        operStack.push(ch);
                    }
                }
            } else {
                keepNum += ch;
                if (index == expression.length()-1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operStack.isOper(expression.substring(index+1, index+2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length())
                break;
        }
        
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.calc(num1, num2, oper);
            numStack.push(res);
        }
        System.out.printf("表达式 %s = %d", expression, numStack.pop());
    }
}

class ArrayStack {
    private int maxSize; // 栈的大小
    private int[] stack;
    private int top;

    public ArrayStack(int _maxSize) {
        this.maxSize = _maxSize;
        this.top = -1;
        this.stack = new int[_maxSize];
    }

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

    // 返回运算符的优先级, 优先级使用数字表示，数字越大，优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;  // 假定目前的表达式只有 +，-，*，/
        }
    }

    // 判断是否是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    public int calc(int num1, int num2, int oper) {
        int res = 0; // res 用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1; // 注意后抛出来的数是表达式前面的值
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}
