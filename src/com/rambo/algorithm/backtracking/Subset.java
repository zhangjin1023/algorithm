package com.rambo.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 78. 子集
 * 你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 * @author: zhangjin27
 * @created: 2023/03/10 14:12
 */
public class Subset {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Stack<Integer> path = new Stack<>();
        backTracking(nums, 0, path, result);
        return result;
    }

    private static void backTracking(int[] nums, int start, Stack<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.push(nums[i]);
            System.out.println("递归之前 => " + path);
            backTracking(nums, i + 1, path, result);
            path.pop();
            System.out.println("递归之后 => " + path);
        }
    }

}
