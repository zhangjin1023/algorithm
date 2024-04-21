package com.rambo.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description:
 * @author: zhangjin27
 * @created: 2024/04/20 13:02
 */
public class ValidString {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Map<String, String> map = new HashMap<>();
        map.put("}", "{");
        map.put("]", "[");
        map.put(")", "(");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c.toString()) && !stack.isEmpty()) {
                String top = stack.pop();
                if (!top.equals(map.get(c.toString()))) {
                    return false;
                }
            } else {
                stack.push(c.toString());
            }
        }
        // 遍历完了字符串，栈是空的说明是有效括号，非空则存在左括号没有对应的右括号匹配
        return stack.isEmpty();
    }
}
