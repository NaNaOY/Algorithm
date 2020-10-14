package com.company;

public class CircularLinkedList {

    public static int solve(int n, int d) {
        if(d == 1 || n < 2)
            return n;
        // 创建环形链表
        Node head = createLinkedList(n);
        // 遍历删除
        int count = 1;
        Node cur = head;
        Node pre = null;//前驱节点
        while (head.next != head) {
            // 删除节点
            if (count == d) {
                count = 1;
                pre.next = cur.next;
                cur = pre.next;
            } else {
                count++;
                pre = cur;
                cur = cur.next;
            }
        }
        return head.date;
    }

    static Node createLinkedList(int n) {
        Node head = new Node(1);
        Node next = head;
        for (int i = 2; i <= n; i++) {
            Node tmp = new Node(i);
            next.next = tmp;
            next = next.next;
        }
        // 头尾串联
        next.next = head;
        return head;
    }
}

