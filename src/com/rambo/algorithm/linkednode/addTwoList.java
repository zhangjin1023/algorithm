package com.rambo.algorithm.linkednode;

/**
 * @description:
 * @author: zhangjin27
 * @created: 2022/09/28 20:24
 */
public class addTwoList {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(3);

        ListNode head2 = new ListNode(4);
        ListNode node21 = new ListNode(5);
        ListNode node22 = new ListNode(7);
        ListNode node23 = new ListNode(7);

        head1.next = node11;
        node11.next = node12;

        head2.next = node21;
        node21.next = node22;
        node22.next = node23;

        ListNode sumNode = addTwoNumbers(head1, head2);
        System.out.println(sumNode);
    }
//问题代码---
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if (l1 == null && l2 == null) {
//            return null;
//        }
//        if (l1 == null && l2 != null) {
//            return l2;
//        }
//        if (l1 != null && l2 == null) {
//            return l1;
//        }
//        ListNode r1 = l1;
//        ListNode r2 = l2;
//        ListNode sumHead = new ListNode(0);
//        ListNode sumPointer = sumHead;
//        while (r1 != null && r2 != null) {
//            if (r1.val + r2.val + sumHead.val >= 10) {
//                sumHead.val = r1.val + r2.val - 10;
//                ListNode sumNextNode = new ListNode(1);
//                sumHead.next = sumNextNode;
//            } else {
//                sumHead.val = r1.val + r2.val + sumHead.val;
//                ListNode sumNextNode = new ListNode(0);
//                sumHead.next = sumNextNode;
//            }
//            sumHead = sumHead.next;
//            r1 = r1.next;
//            r2 = r2.next;
//        }
//        ListNode singlePointer = r1 == null ? r2 : r1;
//        while (singlePointer != null) {
//            ListNode sumNextNode;
//            if (singlePointer.val + sumHead.val >= 10) {
//                sumHead.val = singlePointer.val + sumHead.val - 10;
//                sumNextNode = new ListNode(1);
//            } else {
//                sumHead.val = singlePointer.val + sumHead.val;
//                sumNextNode = new ListNode(0);
//            }
//            sumHead.next = sumNextNode;
//            sumHead = sumHead.next;
//            singlePointer = singlePointer.next;
//        }
//        return sumPointer;
//    }
//

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // 辅助节点
        ListNode pre = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            pre.next = new ListNode(sum % 10);
            carry = sum / 10;

            pre = pre.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) pre.next = new ListNode(carry);

        return dummy.next;
    }


}
