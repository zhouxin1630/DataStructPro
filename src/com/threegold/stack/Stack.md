# 1. 栈
## 1.1 介绍
- 栈是一个**先入后出**的有序列表
- 栈是限制线性表中元素的插入和删除**只能在线性表的同一端**进行的一种特殊线性表。允许插入和删除的一端，为变化的一端，成为**栈顶(Top)**，另一端为固定的一端，称为**栈底(Botton)**。
- 最先放入栈中元素在栈底，最后放入的元素在栈顶，而删除元素刚好相反，最后放入的元素最先删除，最先放入的元素最后删除。

## 1.2 栈的应用场景
- 子程序的调用
- 处理递归调用
- 表达式的转换与求值（实际解决）
- 二叉树的遍历
- 图形的深度优先（depth-fisrt）搜索法

## 1.3 栈的实现 - 数组模拟栈
1. 定义一个 top 来模拟栈顶，初始化 -1
2. 入栈的操作，当有数据加入到栈时，top++, stack[top] = data;
3. 出栈的操作，int value = stack[pop];top--;


# 2. 栈的应用 —— 表达式求值
## 2.1 思路
1. 通过一个 index 值，来遍历表达式
2. 发现是一个数字，则压入数栈
3. 如果发现扫描是一个符号：
    - 如果当前符号栈为空，就直接入栈
    - 如果符号栈有操作符，就进行比较，如果**当前的操作符的优先级小于或者等于栈中的操作符**，就需要从数栈中 pop 出两个数，从符号栈中 pop 出一个操作符，进行计算得到的结果入数栈，然后将当前的操作符入符号栈，**如果当前的操作符优先级大于栈中的操作符，就直接入符号栈**。
    - 当扫描完毕，就顺序的从数栈和符号栈中 pop 出相应的数和符号，并运行。
    - 最后在数栈中只有一个数字，就是表达式的结果。

## 2.2 实现
```Java
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
```

# 3. 栈的应用 —— 逆波兰计算器
## 3.1 需求
- 输入一个逆波兰表达式，使用栈计算其结果
- 支持小括号和多位数整数。

## 3.2 思路
