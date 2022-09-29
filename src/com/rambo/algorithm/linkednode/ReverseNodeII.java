package com.rambo.algorithm.linkednode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseNodeII {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        Node newHead = reverseNode(node1,2,4);
    }

    /**
     * @param head
     * @return com.rambo.algorithm.linkednode.Node
     * @description  切割三段，中间反转后，重新接回去
     */
    public static Node reverseNode(Node head, int left, int right) {
        // 如果链表为空或只有一个节点，无需反转，直接返回原链表表头
        if (head == null || head.next == null) {
            return head;
        }
        Node dummy = new Node(-1);
        dummy.next = head;
        Node lNodePre = dummy;//左边界节点前一个节点
        Node lNode;//左边界节点
        Node rNodePost;//右边界节点下一个
        for (int i = 0; i < left - 1; i++) {
            lNodePre = lNodePre.next;
        }
        lNode = lNodePre.next;
        Node rNode = lNodePre;//右边界节点
        for (int i = 0; i < right - left +1; i++) {
            rNode = rNode.next;
        }
        rNodePost = rNode.next;
        //切断右侧
        rNode.next = null;
        //切断左侧
        lNodePre.next = null;
        Node reverseHead = ReverseNode.reverseNode(lNode);
        lNodePre.next = reverseHead;
        lNode.next = rNodePost;
        return dummy.next;
    }

}
