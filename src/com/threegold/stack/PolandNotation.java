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
        System.out.printf("后缀表达式%s = %d\n", suffixExpression, res);*/

        // 完成中缀表达式转后缀表达式的功能
        String expression = "1+((2+3)*4)-5";
        List<String> infixList = toInfixExpressionList(expression);
        System.out.println(infixList);
        // System.out.printf("中缀表达式 %s = %d");
    }

    // 将中缀表达式转成对应的 List
    public static List<String> toInfixExpressionList(String expression) {
        List<String> res = new ArrayList<>();
        int i = 0;  // 这是一个指针，用于遍历中缀表达式字符串
        String str; // 对于多位数的拼接
        char c; // 每遍历到一个字符，就放入 c
        do {
            if ((c = expression.charAt(i)) < 48 || (c = expression.charAt(i)) > 57) {  // 如果 c 是一个非数字，直接放入到 res
                res.add(String.valueOf(c));
                i++;
            } else {  // 如果是一个数，则需要考虑多位数
                str = "";
                while (i < expression.length() && 
                    ((c = expression.charAt(i)) >= 48 && (c = expression.charAt(i)) <= 57)) {
                        str += c;
                        i++;
                }
                res.add(str);
            }
        } while (i < expression.length());
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
