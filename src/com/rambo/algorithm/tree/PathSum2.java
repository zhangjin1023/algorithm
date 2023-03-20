package com.rambo.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * @author: zhangjin27
 * @created: 2023/03/19 21:10
 */
public class PathSum2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.println(pathSum(root, 12));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (targetSum <= 0 || root == null) {
            return result;
        }
        Stack<Integer> path = new Stack<>();
        path.push(root.val);
        backTracking(root, targetSum, path, result);
        return result;
    }

    private static void backTracking(TreeNode root, int targetSum, Stack<Integer> path, List<List<Integer>> result) {
        //当前节点为叶子节点，且路径和为目标值，加入结果集
        if (sum(path) == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            path.push(root.left.val);
            backTracking(root.left, targetSum, path, result);
            path.pop();
        }
        if (root.right != null) {
            path.push(root.right.val);
            backTracking(root.right, targetSum, path, result);
            path.pop();
        }
    }

    private static int sum(Stack<Integer> path) {
        int sum = 0;
        for (Integer item : path) {
            sum += item;
        }
        return sum;
    }

}
