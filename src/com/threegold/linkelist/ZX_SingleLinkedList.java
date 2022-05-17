package com.threegold.linkelist;

/**
 * 带头结点的单链表
 * 
 * 头结点中的值域存储的是元素的个数
 * 
 * @author zhouxin
 */
public class ZX_SingleLinkedList {

    public static void main(String[] args) {
        ZX_SingleLinkedList sList = new ZX_SingleLinkedList();

        sList.add(0, 2);
        System.out.println("After add(0, 2): ");
        sList.traverse();

        sList.addFirst(1);
        System.out.println("After addFirst(1): ");
        sList.traverse();

        sList.addTail(5);
        System.out.println("After addTail(5): ");
        sList.traverse();

        sList.add(2, 3);
        System.out.println("After add(2, 3): ");
        sList.traverse();

        sList.add(3, 4);
        System.out.println("After add(3, 4): ");
        sList.traverse();

        sList.delete(3);
        System.out.println("After delete(3): ");
        sList.traverse();
    }

    private SingleListNode head, tail;

    public ZX_SingleLinkedList() {
        head = new SingleListNode();
        tail = head;
    }

    public SingleListNode getHead() {
        return this.head;
    }

    public boolean isEmpty() {
        return this.head.next == null;
    }

    public int size() {
        return head.val;
    }

    // 在链表头部添加元素
    public void addFirst(Integer _val) {
        SingleListNode newNode = new SingleListNode(_val);
        newNode.next = head.next;
        if (isEmpty()) {
            tail = newNode;
        }
        head.next = newNode;
        head.val++;
    }

    // 在链表的指定位置添加元素
    public void add(Integer _index, Integer _val) {
        if (_index < 0 || _index > head.val) return;
        if (0 == _index) addFirst(_val);
        else if (_index == head.val) addTail(_val);
        else {
            SingleListNode newNode = new SingleListNode(_val);
            SingleListNode pre = head.next;
            for (int i = 1; i < _index; i++) {
                pre = pre.next;
            }
            newNode.next = pre.next;
            pre.next = newNode;
            head.val++;
        }
    }

    // 默认在链尾添加元素
    public void addTail(Integer _val) {
        SingleListNode newNode = new SingleListNode(_val);
        tail.next = newNode;
        tail = newNode;
        this.head.val++;
    }

    public void delete(Integer val) {
        SingleListNode cur = head;
        while (cur.next != null) {
            if (val == cur.next.val) {
                break;
            }
            cur = cur.next;
        }
        if (cur != null) {
            cur.next = cur.next.next;
            this.head.val--;
        } else {
            System.out.printf("can not find %d in single linked list", val);
        }
    }

    public void traverse() {
        SingleListNode cur = head.next;
        System.out.println("当前链表中的元素有: ");
        while (cur != null) {
            if (cur.next == null)
                System.out.println(cur.val);
            else
                System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
    }
}

class SingleListNode {
    public Integer val = 0;
    public SingleListNode next;

    public SingleListNode() {
    }

    public SingleListNode(Integer _val) { this.val = _val; }

    public SingleListNode(Integer _val, SingleListNode _next) {
        this.val = _val;
        this.next = _next;
    }
}
