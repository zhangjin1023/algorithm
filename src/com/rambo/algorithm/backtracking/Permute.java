package com.rambo.algorithm.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @description: 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * @author: zhangjin27
 * @created: 2023/03/10 14:12
 */
public class Permute {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[nums.length];
        backTracking(nums, path, used, result);
        return result;
    }

    private static void backTracking(int[] nums, Stack<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) {
                continue;
            } else {
                path.push(nums[i]);
                used[i] = true;
                System.out.println("递归之前 => " + path);
                backTracking(nums, path, used, result);
                path.pop();
                used[i] = false;
                System.out.println("递归之后 => " + path);
            }
        }
    }

}
