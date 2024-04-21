package com.rambo.algorithm.string;

/**
 * @description:
 * @author: zhangjin27
 * @created: 2024/04/20 14:23
 */
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("123","23"));//146
        System.out.println(addStrings("1753","839"));//2592
        System.out.println(addStrings("9","99"));//108
    }
    //把字符串拆解为单个字符，从右向左依次相加，考虑进位。
    public static String addStrings(String num1, String num2) {
        //进位
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        for (; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int no1 = 0;
            int no2 = 0;
            if (i >= 0) {
                no1 = num1.charAt(i) - '0';
            }
            if (j >= 0) {
                no2 = num2.charAt(j) - '0';
            }
            sb.append((no1 + no2 + carry) % 10);
            carry = (no1 + no2 + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
