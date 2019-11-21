package com.rambo.algorithm.tree;

/**
 * @description:给定一棵二叉树和一个sum值，判断树中是否存在一条从根节点到叶子节点的路径，
 * 使得路径上的值加起来刚好等于sum。
 * @Date : 2019/11/21 15:28
 * @Author : zhang_jin
 */
public class PathSum {

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

        System.out.println(pathSumI(root, 13));
        System.out.println(pathSumIII(root, 8));
    }

    public static boolean pathSumI(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        } else {
            return pathSumI(root.left, sum - root.val) || pathSumI(root.right, sum - root.val);
        }

    }

    public static int pathSumIII(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return path(root, sum) + path(root.left, sum) + path(root.right, sum);
    }

    /**
     * @description 辅助函数
     * @param root
     * @param sum
     * @return int
     */
    private static int path(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return (root.val == sum ? 1 : 0) + path(root.left, sum - root.val) + path(root.right, sum - root.val);
    }
}
