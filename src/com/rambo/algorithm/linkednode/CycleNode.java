package com.rambo.algorithm.linkednode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:单链表是否有环 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

    /**
     * 双指针法判断链表是否有环：快慢指针，如果相交则有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
