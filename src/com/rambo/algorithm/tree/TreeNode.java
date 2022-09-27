package com.rambo.algorithm.tree;

/**
 * @description:二叉树结构体
 * @Date : 2019/11/20 10:57
 * @Author : zhang_jin
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TreeNode{");
        sb.append("val=").append(val);
        sb.append(", left=").append(left);
        sb.append(", right=").append(right);
        sb.append('}');
        return sb.toString();
    }

    public TreeNode(int val) {
        this.val = val;
    }


}
