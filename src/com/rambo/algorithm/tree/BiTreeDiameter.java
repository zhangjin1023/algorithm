package com.rambo.algorithm.tree;

/**
 * @description:543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * @author: zhangjin27
 * @created: 2023/03/20 21:18
 */
public class BiTreeDiameter {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }

    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int depthL = depth(root.left);
        int depthR = depth(root.right);
        res = Math.max(depthL+depthR,res);
        return Math.max(depthL,depthR)+1;
    }
}
