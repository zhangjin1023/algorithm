package com.rambo.algorithm.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @description:17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangjin27
 * @created: 2023/03/10 14:12
 */
public class PhoneNumber {
    static Map<Character, String[]> map = new HashMap<>();

    static {
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});
    }


    public static void main(String[] args) {
//        System.out.println(phoneNumber("23"));
//        System.out.println(phoneNumber("2"));
        List<String> collect = phoneNumber("23");
        System.out.println(collect);
    }

    public static List<String> phoneNumber(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Stack<String> path = new Stack<>();
        // 多少个数字构成的，就由多少个字母组合
        int k = digits.length();
        backTracking(digits, k, 0, path, result);
        return result;
    }

    private static void backTracking(String digits, int k, int start, Stack<String> path, List<String> result) {
        if (path.size() == k) {
            result.add(toStr(path));
            return;
        }
        char c0 = digits.charAt(start);
        String[] strs = map.get(c0);
        for (int i = 0; i < strs.length; i++) {
            path.push(strs[i]);
            System.out.println("递归之前 => " + path);
            backTracking(digits, k, start + 1, path, result);
            path.pop();
            System.out.println("递归之后 => " + path);
        }
    }

    private static String toStr(Stack<String> path) {
        if (path == null || path.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        path.forEach(item -> sb.append(item));
        return sb.toString();
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
