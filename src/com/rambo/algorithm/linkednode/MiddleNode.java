package com.rambo.algorithm.linkednode;

/**
 * @description:查找单链表的中间结点
 * @Date : 2019/11/20 17:08
 * @Author : zhang_jin
 */
public class MiddleNode {
    public static void main(String[] args){
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
        Node middleNode = getMiddleNode(node1);
        System.out.println(middleNode.val);
    }

    /**
     * @description 运用双指针的思想，前指针走两步，后指针走一步。
     * 等到前指针到达链表末尾，后指针走的长度就是前指针长度的一半，所在位置也就是链表的中间节点！
     * @param head
     * @return com.rambo.algorithm.linkednode.Node
     */
    public static Node getMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node first = head;
        Node last = head;

        while (first.next != null) {
            first = first.next;
            last = last.next;
            if (first != null) {
                first = first.next;
            }
        }
        return last;
    }
}
