package com.rambo.algorithm.linkednode;

/**
 * @description:有序链表合并：将两个有序链表合并,合并后仍然有序
 * @Date : 2019/11/20 9:55
 * @Author : zhang_jin
 */
public class MergeNode {

    public static void main(String[] args){
        Node a1 = new Node(1);
        Node a2 = new Node(3);
        Node a3 = new Node(6);

        a1.setNext(a2);
        a2.setNext(a3);

        Node b1 = new Node(2);
        Node b2 = new Node(4);
        Node b3 = new Node(5);
        Node b4 = new Node(6);

        b1.setNext(b2);
        b2.setNext(b3);
        b3.setNext(b4);

        System.out.print("合并前 a：");
        a1.printNode();
        System.out.print("合并前 b：");
        b1.printNode();
//        Node result = mergeTwoNode(a1, b1);
        Node result = mergeTwoLists(a1, b1);
        System.out.print("合并后 resut：");
        result.printNode();
    }

    public static Node mergeTwoNode(Node a, Node b) {
        Node result;
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        if (a.getVal() <= b.getVal()) {
            result = a;
            result.setNext(mergeTwoNode(a.getNext(), b));
        } else {
            result = b;
            result.setNext(mergeTwoNode(b.getNext(), a));
        }
        return result;
    }

    //方法2：循环+双指针
    public static Node mergeTwoLists(Node list1, Node list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        Node result = new Node(0);
        Node r = result;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                r.next = list1;
                list1 = list1.next;
                r = r.next;
            }else{
                r.next = list2;
                list2 = list2.next;
                r = r.next;
            }
        }
        if(list1 == null){
            r.next = list2;
        }
        if(list2 == null){
            r.next = list1;
        }
        return result.next;
    }
}
