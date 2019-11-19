package com.rambo.algorithm;

import java.util.Stack;

/**
 * @description:单链表反转：比如1→2→3→4→5，反转之后返回5→4→3→2→1
 * 步骤：
 *     从头到尾遍历原链表，每遍历一个结点
 *     将其摘下放在新链表的最前端。
 *     注意链表为空和只有一个结点的情况。
 * @Date : 2019/11/19 14:40
 * @Author : zhang_jin
 */
public class ReverseNode {
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

        printNode(node1);
        Node reverseNode = reverseNode(node1);
        printNode(reverseNode);
//
//        Node reverseByStack = reverseByStack(node1);
//        printNode(reverseByStack);
    }

    private static void printNode(Node node1) {
        Node node = node1;
        StringBuilder sb = new StringBuilder().append(node.val);
        while (node.getNext() != null) {
            node = node.getNext();
            sb.append("->").append(node.val);
        }
        System.out.println(sb.toString());
    }

    /**
     * @description 双指针+过河拆桥+头插法的解题思路
     * 1.双指针：因为处理当前节点的时候，需要修改next域，所以必须得有指针先移动到下一个节点，否则无法寻址
     * 2.过河拆桥：形象化的描述当指针移动到下一个节点后，当前节点的next域指向就可以修改了，类似过河拆桥
     * 3.头插法：将当前节点的next域指向新链表的第一个节点。
     * @param head
     * @return com.rambo.algorithm.Node
     */
    public static Node reverseNode(Node head) {
        // 如果链表为空或只有一个节点，无需反转，直接返回原链表表头
        if (head == null || head.next == null)
            return head;

        Node newHead = null;// 新链表的第一个节点的指针
        Node prePointer = head;// 前指针
        while (prePointer != null) {
            Node curPointer = prePointer;      // 后指针
            prePointer = prePointer.next;        // 前指针“过河”：移动到下一个节点
            curPointer.next = newHead;   // 后指针“拆桥”+ 头插法（将当前处理节点的next域指向新链表的第一个节点）
            newHead = curPointer;        // 头插法（新链表的第一个节点向前移动，也就是刚插入的新节点）
        }
        return newHead;
    }

    public static Node reverseByStack(Node head) {
        // 1.如果链表为空或只有一个节点，无需反转，直接返回原链表表头
        if (head == null || head.next == null) {
            return head;
        }
        // 2.把原链表压入栈内,head指针向后移动
        Stack<Node> stack = new Stack<>();
        while (head.getNext() != null) {
            stack.push(head);
            head = head.getNext();
        }
        // 3.最后一个节点不需要入栈，并且需要把此时head指针保存在新的变量中，后续head指针需要向后移动
        Node newHead = head;
        // 4.弹栈的同时，head指针向后移动
        while (!stack.isEmpty()) {
            head.setNext(stack.pop());
            head = head.getNext();
        }
        // 5.此时head指针移动到新链表的末尾，需要设置next指针为null
        head.setNext(null);
        return newHead;
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}