package com.threegold.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {

        // 计算后缀表达式的值
        /*String suffixExpression = "3 4 + 5 * 6 -";
        List<String> rpnList = getListString(suffixExpression);
        int res = calculate(rpnList);
        System.out.printf("%s = %d\n", suffixExpression, res);*/
    }


    // 将中缀表达式转成对应的 List
    public static List<String> toInfixExpressionList(String expression) {
        List<String> res = new ArrayList<>();
        return res;
    }

    // 将后缀表达式（波兰表达式），以此将数据和运算符放入 ArrayList 中
    public static List<String> getListString(String suffixExpressioin) {
        String[] split = suffixExpressioin.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    public static int calculate(List<String> ls) {
        Stack<Integer> stack = new Stack<>();
        for (String item : ls) {
            if (item.matches("\\d+")) {
                stack.push(Integer.parseInt(item));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if ("-".equals(item)) {
                    res = num1 - num2;
                } else if ("*".equals(item)) {
                    res = num1 * num2;
                } else if ("/".equals(item)) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }
}
