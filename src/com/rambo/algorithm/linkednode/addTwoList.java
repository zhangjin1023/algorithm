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

    /**
     * 两数相加：反向存放、反向输出。
     * @param l1
     * @param l2
     * @return
     */
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

    /**
     * 两数相加II：正向存放，正向输出。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // 辅助节点
        ListNode pre = dummy;
        int carry = 0;
        l1 = reverseNode(l1);
        l2 = reverseNode(l2);
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

        return reverseNode(dummy.next);
    }

    public static ListNode reverseNode(ListNode head) {
        // 如果链表为空或只有一个节点，无需反转，直接返回原链表表头
        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = null;// 新链表的头指针
        ListNode prePointer = head;// 前指针
        while (prePointer != null) {
            ListNode curPointer = prePointer;      // 后指针
            prePointer = prePointer.next;        // 前指针“过河”：移动到下一个节点
            curPointer.next = newHead;   // 后指针“拆桥”+ 头插法（将当前处理节点的next域指向新链表的第一个节点）
            newHead = curPointer;        // 头插法（新链表的头指针前移，即指向刚插入的节点）
        }
        return newHead;
    }


}
