package com.rambo.algorithm.linkednode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *  
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * @author: zhangjin27
 * @created: 2022/09/27 16:20
 */
public class Palindrome {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        boolean palindrome2 = isPalindrome2(head);
        System.out.println(palindrome2);
    }

    /**
     * 空间复杂度O(1)，时间复杂度O(n)的方案，是找到链表的中间节点，之后的子链表进行反转，反转后使用双指针，比较值是否相当。
     * @param head
     * @return
     */
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.val == head.next.val;
        }
        Node middleNode = getMiddleNode(head);
        Node rightHeadReversed = reverseList(middleNode.next);

        Node pLeft = head;
        Node pRight = rightHeadReversed;
        boolean result = true;
        while (pRight != null) {
            if (pLeft.val != pRight.val) {
                result = false;
            }
            pLeft = pLeft.next;
            pRight = pRight.next;
        }
        Node reverseAgain = reverseList(rightHeadReversed);
        middleNode.setNext(reverseAgain);
        return result;
    }


    public static Node getMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node first = head;
        Node last = head;

        while (first.next != null && first.next.next != null) {
            first = first.next.next;
            last = last.next;
        }
        return last;
    }

    public static Node reverseList(Node head) {
        if(head == null || head.next==null){
            return head;
        }
        Node newHead = new Node(-1);
        while(head != null){
            Node next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }


    /**
     * 借用数组的方案来存储节点的值，在用双指针头尾同时遍历，时间复杂度O(n),空间复杂度O(n)
     * @param head
     * @return
     */
    public boolean isPalindrome1(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node p = head;
        List<Integer> array = new ArrayList<>();
        while (p != null) {
            array.add(p.val);
            p = p.next;
        }
        int left = 0;
        int right = array.size() - 1;
        while (left < right) {
            if (!array.get(left).equals(array.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
