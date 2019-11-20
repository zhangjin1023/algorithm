package com.rambo.algorithm.linkednode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:单链表是否有环
 * @Date : 2019/11/20 20:45
 * @Author : zhang_jin
 */
public class CycleNode {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node3);

//        System.out.print("链表:");
        //node1.printNode();
        boolean hasCycle = hasCycle(node1);
        Node firstNodeInCycle = getFirstNodeInCycleHashMap(node1);
        System.out.println("链表是否有环：" + hasCycle);
        System.out.println("首个进入环的节点：" + firstNodeInCycle.val);
    }

    public static boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node p = head;
        Map<Node, Boolean> map = new HashMap<>();
        while (p != null) {
            if (map.containsKey(p)) {
                return true;
            } else {
                map.put(p, true);
                p = p.next;
            }
        }
        return false;
    }

    public static Node getFirstNodeInCycleHashMap(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        Map<Node, Boolean> map = new HashMap<>();
        while (p != null) {
            if (map.containsKey(p)) {
                return p;
            } else {
                map.put(p, true);
                p = p.next;
            }
        }
        return null;
    }
}
