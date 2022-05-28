package com.threegold.hashtable;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {

        // 创建一个链表
        HashTab hashTab = new HashTab(7);

        // 写一个简单的菜单
        String key = "";
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit：退出系统");

            key = in.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = in.nextInt();
                    System.out.println("输入名字");
                    String name = in.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("输入id");
                    int i = in.nextInt();
                    hashTab.findEmpById(i);
                    break;
                case "exit":
                    in.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}

class HashTab {
    private EmpLinkedList[] empLinkedListArrays;
    private int size;

    public HashTab(int size) {
        empLinkedListArrays = new EmpLinkedList[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            empLinkedListArrays[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        // 根据员工的 id，得到该员工应该加入那条链表
        int empLinkedListNo = hashFun(emp.id);

        // 将 emp 添加到对应的链表中
        empLinkedListArrays[empLinkedListNo].add(emp);
    }

    // 遍历所有的链表, 遍历 hastab
    public void list() {
        int i = 0;
        for (EmpLinkedList linkedList : empLinkedListArrays) {
            linkedList.list(i++);
        }
    }

    // 根据输入的 id 查找雇员
    public void findEmpById(int id) {
        int no = hashFun(id);
        Emp emp = empLinkedListArrays[no].findEmpById(id);
        if (null != emp) {
            System.out.println("在 hash 表中没有找到该雇员");
        } else {
            System.out.printf("在第%d条链表找到了雇员 id=%d\n", (no + 1), id);
        }
    }

    // 编写一个散列函数，使用过一个简单的取模法
    public int hashFun(int id) {
        return id % size;
    }

}

// 表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next; // 默认为 null

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

// 创建 EmpLinkedList 表示链表
class EmpLinkedList {
    private Emp head;

    /**
     * 添加雇员到链表
     * 
     * @param emp
     */
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
        } else {
            Emp cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = emp;
        }
    }

    // 遍历链表的雇员信息
    public void list(int no) {
        if (head == null) {
            System.out.println("当前链表为空");
            return;
        }
        System.out.println("第" + (no + 1) + "链表的信息为:");
        Emp cur = head;
        while (cur != null) {
            System.out.printf("=> id: %d, name: %s\n", cur.id, cur.name);
            cur = cur.next;
        }
    }

    // 根据 id 查找雇员
    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("当前链表为空!");
            return null;
        }

        Emp cur = head;
        while (cur != null) {
            if (cur.id == id) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}