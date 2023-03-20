package com.rambo.algorithm.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:二叉树的所有路径
 * @author: zhangjin27
 * @created: 2023/03/19 19:43
 */
public class TreePath {

    /**
     * 递归解法：所有路径等于根节点到左右孩子的路径加上左右子树的所有路径
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null)
            return res;
        //到达叶子节点，把路径加入到集合中
        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }
        //遍历左子节点的路径
        for (String path : binaryTreePaths(root.left)) {
            res.add(root.val + "->" + path);
        }
        //遍历右子节点的路径
        for (String path : binaryTreePaths(root.right)) {
            res.add(root.val + "->" + path);
        }
        return res;
    }

}
