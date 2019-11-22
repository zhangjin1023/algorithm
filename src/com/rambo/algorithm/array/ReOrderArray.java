package com.rambo.algorithm.array;

import java.util.Arrays;

/**
 * @description:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 思路：使用双指针，left和right；left从前往后移动，直到遇到偶数；right指针向前移动，直到遇到一个奇数；交换两个指针所指向的元素。
 * @Date : 2019/11/22 17:44
 * @Author : zhang_jin
 */
public class ReOrderArray {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        reOrderArray(a);
        System.out.println(Arrays.toString(a));
    }

    public static void reOrderArray(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            // 找到左边的偶数
            while (a[left] % 2 != 0) {
                left++;
            }
            // 找到右边的奇数
            while (a[right] % 2 != 1) {
                right--;
            }

            // 找到了，并且是左指针小于右指针就交换
            if (left < right) {
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;
            }
        }

    }
}
