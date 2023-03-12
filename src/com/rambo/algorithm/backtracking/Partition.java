package com.rambo.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 *  
 * 提示：
 * <p>
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 * @author: zhangjin27
 * @created: 2023/03/12 11:27
 */
public class Partition {

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        Stack<String> path = new Stack<>();
        backTracking(s, 0, path, result);
        return result;
    }

    private static void backTracking(String s, int start, Stack<String> path, List<List<String>> result) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            //如果是回文子串，则记录
            if (isPalindrome(s, start, i)) {
                String str = s.substring(start, i + 1);
                path.push(str);
            } else {
                continue;
            }
            System.out.println("递归之前 => " + path);
            backTracking(s, i + 1, path, result);
            path.pop();
            System.out.println("递归之后 => " + path);
        }
    }

    //判断是否是回文串
    private static boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
