package com.rambo.algorithm.linkednode;

/**
 * @description:查找单链表中的倒数第K个结点（k > 0）
 * 主要思路就是使用两个指针，先让前面的指针走到正向第k个结点
 * 这样前后两个指针的距离差是k-1，之后前后两个指针一起向前走
 * 前面的指针走到最后一个结点时，后面指针所指结点就是倒数第k个结点
 * @Date : 2019/11/20 16:36
 * @Author : zhang_jin
 */
public class LastKthNode {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        System.out.print("链表:");
        node1.printNode();
        int k = 1;
        System.out.print("链表倒数第" + k + "个节点为：" + (getLastKthNode(node1, k) == null ? "null" : getLastKthNode(node1, k).val));
    }

    public static Node getLastKthNode(Node head, int k) {
        if (k <= 0 || head == null) {
            return null;
        }
        Node first = head;// 前指针
        Node last = head;// 后指针

        // 前指针需要向前移动k-1次，所在位置就是正向第k个节点
        for (int i = 0; (i < k - 1) && first != null; i++) {
            first = first.next;
        }
        // 此时前指针所在的节点为null，说明k长度超过链表最大长度
        if (first == null) {
            return null;
        }
        // 前后指针同时向前移动，直到前指针到达链表末尾
        while (first.next != null) {
            first = first.next;
            last = last.next;
        }
        return last;
    }
}
