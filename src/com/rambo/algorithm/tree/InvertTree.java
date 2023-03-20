package com.rambo.algorithm.tree;

/**
 * @description:翻转二叉树
 * @author: zhangjin27
 * @created: 2023/03/19 17:49
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        return doInvert(root);
    }

    public TreeNode doInvert(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode temp = doInvert(root.left);
        root.left = doInvert(root.right);
        root.right = temp;
        return root;
    }
}
