package com.rambo.algorithm.linkednode;

/**
 * @description:给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 * @author: zhangjin27
 * @created: 2024/03/30 20:00
 */
public class DeleteDuplicates {
    // 方法1：遍历
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode l = head;
        ListNode r = head.next;
        while(r != null){
            if(l.val == r.val){
                l.next = r.next;
                r = r.next;
            }else{
                l = l.next;
                r = r.next;
            }
        }
        return head;
    }

    //方法2：递归
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            head = deleteDuplicates2(head.next);
        } else {
            head.next = deleteDuplicates2(head.next);
        }
        return head;
    }
}
