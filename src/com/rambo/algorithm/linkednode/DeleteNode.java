package com.rambo.algorithm.linkednode;

/**
 * @description:删除链表中所有值为v的节点
 * @Date : 2019/11/20 19:37
 * @Author : zhang_jin
 */
public class DeleteNode {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        System.out.print("原链表:");
        node1.printNode();

        System.out.print("删除后链表:");
        Node deleteAll = deleteAll(node1,4);
        deleteAll.printNode();

//        Node newNode = delete(node1, node5);
//        System.out.print("删除后链表：");
//        if (newNode == null) {
//            System.out.println("空");
//        } else {
//            newNode.printNode();
//        }
    }

    /**
     * @description 递归实现删除链表中值为v的所有节点
     * @param head
     * @param v
     * @return com.rambo.algorithm.linkednode.Node
     */
    public static Node deleteAll(Node head, int v) {
        if (head == null) {
            return null;
        }
        Node node = deleteAll(head.next, v);
        if (head.val == v) {
            return node;
        } else {
            head.next = node;
            return head;
        }
    }

    /**
     * @description 给定链表，和指定的节点的指针，需要删除指定的节点,要求时间复杂度是O(1)
     * @param head
     * @param toDelete
     * @return void
     */
    public static Node delete(Node head, Node toDelete) {
        if (head == null || toDelete == null) {
            return null;
        }

        if (toDelete.next != null) {// 非末尾节点
            toDelete.val = toDelete.next.val;
            toDelete.next = toDelete.next.next;
        } else {// 末尾节点，需要从头遍历到待删除节点的上一个节点
            if (head == toDelete) {
                return null;// bug:如果是单节点的链表，因为head参数传递是值传递，所以此处head= null 不能改变原链表。
            } else {
                Node p = head;
                while (p.next != toDelete) {
                    p = p.next;
                }
                p.next = null;
            }
        }
        return head;
    }

}
