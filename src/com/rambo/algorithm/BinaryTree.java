package com.rambo.algorithm;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @description:二叉树遍历
 * @Date : 2019/11/20 11:05
 * @Author : zhang_jin
 */
public class BinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.print("队列实现广度优先遍历：");
        levelTraversal(root);
        System.out.println();

        System.out.print("栈实现前序遍历：");
        preorderTraversal(root);
        System.out.println();

        System.out.print("递归实现前序遍历：");
        preorderTraversalRec(root);
        System.out.println();

        System.out.print("递归实现中序遍历：");
        inorderTraversalRec(root);
        System.out.println();

        System.out.print("递归实现后续遍历：");
        postorderTraversalRec(root);
        System.out.println();

        int nodeNum = getNodeNumRec(root);
        System.out.println("递归计算二叉树节点数：" + nodeNum);

        int nodeDepth = getNodeDepthRec(root);
        System.out.println("递归计算二叉树深度：" + nodeDepth);

        int k = 2;
        int nodeNumKthLevel = getNodeNumKthLevelRec(root, k);
        System.out.println("递归计算二叉树第" + k + "层节点数：" + nodeNumKthLevel);

        int leafNum = getNodeLeafNumRec(root);
        System.out.println("递归计算二叉树叶子节点数：" + leafNum);
    }

    /**
     * @description 用队列实现二叉树的广度优先遍历
     * @param root
     * @return void
     */
    public static void levelTraversal(TreeNode root) {
        if (root == null) return;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.remove();
            System.out.print(treeNode.val + " ");
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
    }

    /**
     * @description 用栈实现深度优先遍历的前序遍历（根左右）
     * @param root
     * @return void
     */
    public static void preorderTraversal(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.print(treeNode.val + " ");
            // 前序遍历，需要右子树先进栈
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
    }

    /**
     * 前序遍历，中序遍历，后序遍历
     *  前序遍历递归解法：
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，访问根节点，前序遍历左子树，前序遍历右子树
     */
    public static void preorderTraversalRec(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);
    }

    /**
     * 前序遍历，中序遍历，后序遍历
     *  中序遍历递归解法：
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树
     */
    public static void inorderTraversalRec(TreeNode root) {
        if (root == null)
            return;
        inorderTraversalRec(root.left);
        System.out.print(root.val + " ");
        inorderTraversalRec(root.right);
    }

    /**
     * 后序遍历递归解法
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，后序遍历左子树，后序遍历右子树，访问根节点
     */
    public static void postorderTraversalRec(TreeNode root) {
        if (root == null)
            return;
        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * @description 递归获取二叉树节点数
     * @param root
     * @return int
     */
    public static int getNodeNumRec(TreeNode root) {
        if (root == null)
            return 0;
        return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
    }

    /**
     * @description 递归获取二叉树深度
     * @param root
     * @return int
     */
    public static int getNodeDepthRec(TreeNode root) {
        if (root == null)
            return 0;
        int depthLeft = getNodeDepthRec(root.left);
        int depthRight = getNodeDepthRec(root.right);
        return (depthLeft > depthRight ? depthLeft : depthRight) + 1;
    }

    /**
     * @description 递归求二叉树中第K层的节点个数
     * @param root
     * @return int
     */
    public static int getNodeNumKthLevelRec(TreeNode root, int k) {
        if (root == null || k < 1)
            return 0;
        if (k == 1)
            return 1;
        int numLeft = getNodeNumKthLevelRec(root.left, k - 1);
        int numRight = getNodeNumKthLevelRec(root.right, k - 1);
        return numLeft + numRight;
    }

    /**
     * @description 递归求二叉树叶子节点个数
     * @param root
     * @return int
     */
    public static int getNodeLeafNumRec(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getNodeLeafNumRec(root.left) + getNodeLeafNumRec(root.right);
    }

}

