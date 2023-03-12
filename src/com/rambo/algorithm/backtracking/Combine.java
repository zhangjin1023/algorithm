package com.rambo.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 组合问题
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * @author: zhangjin27
 * @created: 2023/03/10 14:12
 */
public class Combine {
    public static void main(String[] args) {
        System.out.println(combine(6, 4));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || n < k) {
            return result;
        }
        Stack<Integer> path = new Stack<>();
        backTracking(n, k, 1, path, result);
//        backTrackingPrune(n, k, 1, path, result);
        return result;
    }

    private static void backTracking(int n, int k, int start, Stack<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.push(i);
            System.out.println("递归之前 => " + path);
            backTracking(n, k, i + 1, path, result);
            path.pop();
            System.out.println("递归之后 => " + path);
        }
    }

    /**
     * 剪枝优化
     *
     * @param n
     * @param k
     * @param start
     * @param path
     * @param result
     */
    private static void backTrackingPrune(int n, int k, int start, Stack<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.push(i);
            System.out.println("递归之前 => " + path);
            backTrackingPrune(n, k, i + 1, path, result);
            path.pop();
            System.out.println("递归之后 => " + path);
        }
    }
}
