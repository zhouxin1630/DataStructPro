# 1. 单向的环形链表 - 约瑟夫问题
## 1.1 构建思路
1. 先创建第一个节点，让 first 指向该节点，并形成环形。
2. 后面我们每创建一个新的节点，就把该节点加入到已有的环形链表中即可
```java
public void addJosepfuNode(int nums) {
    if (nums < 1) {
        System.out.println("nums 的值不正确");
        return;
    }

    JosepfuNode cur = null;  // 辅助指针
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
```

## 1.2 遍历环形链表
1. 先让一个辅助指针变量 cur 指向 first 节点
2. 然后通过一个 while 循环遍历该环形变量即可。cur.next == first 结束。
```Java
public void traverse() {
    if (first.getNext() == null) {
        System.out.println("没有任何约瑟夫节点");
        return;
    }
    JosepfuNode cur = first;
    while (true) {
        System.out.printf("节点的编号 %d \n", cur.getNo());
        if (cur.getNext() == first) break;
        cur = cur.getNext();
    }
}
```

## 1.3 从环形链表中删除
1. 需要创建一个辅助指针 helper，事先应该指向环形链表的最后这个节点。
> 补充：报数前，先让 first 和 helper 移动 k-1 次。
2. 当开始数数的时候，让 first 和 helper 指针同时的移动 m-1 次
3. 这时就可以将 first 出圈。
    ```java
    first = first.next;
    helper.next = first;
    ```
    原来 first 指向的节点就没有任何引用，就会被回收。
4. 