package com.rambo.algorithm.linkednode;

/**
 * @description: 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date : 2019/11/20 20:45
 * @Author : zhang_jin
 */
public class CycleNodeII {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node3);

        boolean result = hasCycle2(head);
        System.out.println("链表是否有环：" + result);
        Node node = detectCycle(head);
        System.out.println("首个进入环的节点：" + node.val);
    }

    /**
     * 可以将快慢指针交点和入环的点，将链表切割为a,b,c三段：
     * a:头节点遍历到入环节点的距离；
     * b:入环节点遍历到交点的距离；
     * c:交点到入环节点的距离；
     * 快慢指针相交则必然是，2(a+b) = a+b+c+b ==>a=c
     * 因此，要找到入环的点，则需要找到相交的点之后，再让一个指针从头节点开始遍历，交点继续遍历，二者相交的点就是入环点
     *
     * @param head
     * @return
     */
    public static Node detectCycle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        Node interSecNode = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                interSecNode = slow;
                break;
            }
        }
        if (interSecNode == null) {
            return null;
        }
        //从头节点触发的指针和从交点触发的指针会相交，交点就是入环的点
        Node p1 = head;
        Node p2 = interSecNode;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    /**
     * 双指针法判断链表是否有环：快慢指针，如果相交则有环
     *
     * @param head
     * @return
     */
    public static boolean hasCycle2(Node head) {
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
