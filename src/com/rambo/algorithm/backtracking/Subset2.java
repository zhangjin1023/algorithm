package com.rambo.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @description: 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * @author: zhangjin27
 * @created: 2023/03/10 14:12
 */
public class Subset2 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 2, 3}));
//        System.out.println(subsets(new int[]{1, 2, 2}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums, 0, path, result, used);
        return result;
    }

    private static void backTracking(int[] nums, int start, Stack<Integer> path, List<List<Integer>> result, boolean[] used) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i >= 1 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            path.push(nums[i]);
            used[i] = true;
            System.out.println("递归之前 => " + path);
            backTracking(nums, i + 1, path, result, used);
            path.pop();
            used[i] = false;
            System.out.println("递归之后 => " + path);
        }
    }

}
