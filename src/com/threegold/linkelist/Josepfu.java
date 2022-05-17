package com.threegold.linkelist;

public class Josepfu {
    public static void main(String[] args) {
        // 测试一下构建环形链表，和遍历是否 ok
        CircleSingleLinkedList cList = new CircleSingleLinkedList();
        cList.addJosepfuNode(5);
        cList.traverse();

        cList.countJosepfuNode(1, 2, 5);
    }
}

class CircleSingleLinkedList {
    private JosepfuNode first = new JosepfuNode(-1);

    // 添加约瑟夫节点，构建一个环形链表
    public void addJosepfuNode(int nums) {
        if (nums < 1) {
            System.out.println("nums 的值不正确");
            return;
        }

        JosepfuNode cur = null; // 辅助指针
        for (int i = 1; i <= nums; i++) {
            JosepfuNode node = new JosepfuNode(i);
            if (i == 1) {
                first = node;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(node);
                node.setNext(first);
                cur = node;
            }
        }
    }

    // 遍历当前的环形链表
    public void traverse() {
        if (first.getNext() == null) {
            System.out.println("没有任何约瑟夫节点");
            return;
        }
        JosepfuNode cur = first;
        while (true) {
            System.out.printf("节点的编号 %d \n", cur.getNo());
            if (cur.getNext() == first)
                break;
            cur = cur.getNext();
        }
    }

    // 根据用户的输入，计算出节点的出圈顺序
    /**
     * 
     * @param startNo  表示从第几个节点开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有几个节点在圈中
     */
    public void countJosepfuNode(int startNo, int countNum, int nums) {
        if (first.getNext() == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误");
            return;
        }
        JosepfuNode helper = first;
        while (true) {
            if (helper.getNext() == first)
                break;
            helper = helper.getNext();
        }
        for (int j = 0; j < startNo-1; j++) {
            first = first.getNext();
            helper = first.getNext();
        }
        while (true) {
            if (helper == first) break;  // 说明圈中只有一个节点了
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("节点 %d 出圈", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的节点编号是 %d \n", first.getNo());
    }
}

class JosepfuNode {
    private int no; // 编号
    private JosepfuNode next; // 下一值域

    public JosepfuNode(int _no) {
        this.no = _no;
    }

    public int getNo() {
        return this.no;
    }

    public void setNo(int _no) {
        this.no = _no;
    }

    public JosepfuNode getNext() {
        return this.next;
    }

    public void setNext(JosepfuNode _next) {
        this.next = _next;
    }
}
