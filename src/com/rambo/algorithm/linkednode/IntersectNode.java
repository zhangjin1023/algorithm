package com.rambo.algorithm.linkednode;

/**
 * @description:判断两个单链表是否相交:
 * 如果两个链表相交于某一节点，那么在这个相交节点之后的所有节点都是两个链表所共有的.
 * 也就是说，如果两个链表相交，那么最后一个节点肯定是共有的。
 * 先遍历第一个链表，记住最后一个节点，然后遍历第二个链表， 到最后一个节点时和第一个链表的最后一个节点做比较，如果相同，则相交，
 * 否则不相交。时间复杂度为O(n)，因为只需要一个额外指针保存最后一个节点地址， 空间复杂度为O(1)
 * @Date : 2019/11/20 17:56
 * @Author : zhang_jin
 */
public class IntersectNode {
    public static void main(String[] args) {
        Node a1 = new Node(1);
        Node a2 = new Node(3);
        Node a3 = new Node(7);

        a1.setNext(a2);
        a2.setNext(a3);

        Node b1 = new Node(2);
        Node b2 = new Node(4);
        Node b3 = new Node(3);
        Node b4 = new Node(7);

        b1.setNext(b2);
        b2.setNext(a2);
//        b3.setNext(b4);
        b3.setNext(a3);

        System.out.println(isIntersect(a1, b1));
        Node firstIntersectNode = getFirstIntersectNode(a1, b1);
        System.out.println(firstIntersectNode.val);
    }

    public static boolean isIntersect(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return false;
        }
        Node p1 = head1;
        while (p1.next != null) {
            p1 = p1.next;
        }
        //此时p1 指向了第一个链表的末尾节点
        Node p2 = head2;
        while (p2.next != null) {
            p2 = p2.next;
        }
        //此时p2 指向了第二个链表的末尾节点
        return p1 == p2;
    }

    /**
     * @description求两个单链表相交的第一个节点 对第一个链表遍历，计算长度len1，同时保存最后一个节点的地址。
     * 对第二个链表遍历，计算长度len2，同时检查最后一个节点是否和第一个链表的最后一个节点相同，若不相同，不相交，结束。
     * 两个链表均从头节点开始，假设len1大于len2
     * 那么将第一个链表先遍历len1-len2个节点，此时两个链表当前节点到第一个相交节点的距离就相等了，然后一起向后遍历，直到两个节点的地址相同。
     * 时间复杂度，O(len1+len2)
     * @param head1
     * @param head2
     * @return com.rambo.algorithm.linkednode.Node
     */
    public static Node getFirstIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node p1 = head1;
        int len1 = 1;
        while (p1.next != null) {
            p1 = p1.next;
            len1++;
        }
        //此时p1 指向了第一个链表的末尾节点

        Node p2 = head2;
        int len2 = 1;
        while (p2.next != null) {
            p2 = p2.next;
            len2++;
        }
        //此时p2 指向了第二个链表的末尾节点

        Node cur1 = head1;
        Node cur2 = head2;
        int offset;
        // 长的链表头指针向前移动offset偏移量之后，两条链表的指针同步移动，直到遇到相等的节点就是相交的第一个节点
        if (len1 >= len2) {
            offset = len1 - len2;
            for (int i = 0; i < offset; i++) {
                cur1 = cur1.next;
            }
        } else {
            offset = len2 - len1;
            for (int i = 0; i < offset; i++) {
                cur2 = cur2.next;
            }
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
