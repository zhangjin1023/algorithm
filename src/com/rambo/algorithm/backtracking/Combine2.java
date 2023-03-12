package com.rambo.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 组合问题
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次 
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * 示例 3:
 * <p>
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 * @author: zhangjin27
 * @created: 2023/03/10 14:12
 */
public class Combine2 {
    public static void main(String[] args) {
        System.out.println(combine(9, 3, 7));
    }

    public static List<List<Integer>> combine(int n, int k, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || n < k) {
            return result;
        }
        Stack<Integer> path = new Stack<>();
        backTracking(n, k, sum, 1, path, result);
//        backTrackingPrune(n, k, 1, path, result);
        return result;
    }

    private static void backTracking(int n, int k, int sum, int start, Stack<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            if (pathSum(path) == sum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            path.push(i);
            System.out.println("递归之前 => " + path);
            backTracking(n, k, sum, i + 1, path, result);
            path.pop();
            System.out.println("递归之后 => " + path);
        }
    }

    private static int pathSum(Stack<Integer> path) {
        int sum = 0;
        for (Integer item : path) {
            sum += item;
        }
        return sum;
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
    private static void backTrackingPrune(int n, int k, int sum,int start, Stack<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            if (pathSum(path) == sum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.push(i);
            System.out.println("递归之前 => " + path);
            backTrackingPrune(n, k, sum, i + 1, path, result);
            path.pop();
            System.out.println("递归之后 => " + path);
        }
    }
}
