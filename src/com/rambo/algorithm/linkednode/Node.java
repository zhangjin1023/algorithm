package com.rambo.algorithm.linkednode;

/**
 * @description:
 * @Date : 2019/11/20 16:25
 * @Author : zhang_jin
 */
public class Node {
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

    public void printNode() {
        Node node = this;
        StringBuilder sb = new StringBuilder().append(node.val);
        while (node.getNext() != null) {
            node = node.getNext();
            sb.append("->").append(node.val);
        }
        System.out.println(sb.toString());
    }
}
