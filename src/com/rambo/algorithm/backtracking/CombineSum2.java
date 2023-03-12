package com.rambo.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @description:40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。 
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * @author: zhangjin27
 * @created: 2023/03/10 14:12
 */
public class CombineSum2 {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return result;
        }
        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[candidates.length];
        backTracking2(candidates, target, 0, path, 0, result, used);
        return result;
    }

    /**
     * used数组方式去重，树层去重。排序后的数组，相同的两个数字会相邻出现，
     *
     * @param candidates
     * @param target
     * @param start
     * @param path
     * @param pathSum
     * @param result
     */
    private static void backTracking2(int[] candidates, int target, int start, Stack<Integer> path, int pathSum, List<List<Integer>> result, boolean[] used) {
        if (pathSum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i >= 1 && candidates[i] == candidates[i - 1] && used[i-1] == false) {
                continue;
            }
            pathSum += candidates[i];
            //剪枝
            if (pathSum > target) {
                break;
            }
            path.push(candidates[i]);
            used[i] = true;
            System.out.println("递归之前 => " + path);
            backTracking2(candidates, target, i + 1, path, pathSum, result, used);
            path.pop();
            pathSum -= candidates[i];
            used[i] = false;
            System.out.println("递归之后 => " + path);
        }
    }

    /**
     * 此去重方式会导致运行超时
     *
     * @param candidates
     * @param target
     * @param start
     * @param path
     * @param pathSum
     * @param result
     * @param resultSet
     */
    private static void backTracking(int[] candidates, int target, int start, Stack<Integer> path, int pathSum, List<List<Integer>> result, Set<String> resultSet) {
        if (pathSum == target) {
            if (!contains(resultSet, toStr(path))) {
                result.add(new ArrayList<>(path));
                resultSet.add(toStr(path));
            }
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            pathSum += candidates[i];
            //剪枝
            if (pathSum > target) {
                break;
            }
            path.push(candidates[i]);
            System.out.println("递归之前 => " + path);
            backTracking(candidates, target, i + 1, path, pathSum, result, resultSet);
            path.pop();
            pathSum -= candidates[i];
            System.out.println("递归之后 => " + path);
        }
    }

    private static String toStr(Stack<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (Integer item : path) {
            sb.append(item).append("_");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    private static boolean contains(Set<String> resultSet, String path) {
        return resultSet.contains(path);
    }

}
