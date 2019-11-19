package com.rambo.algorithm;

import java.util.Arrays;

/**
 * @description: 快速排序：是一种分区交换排序算法。采用分治策略对两个子序列再分别进行快速排序，是一种递归算法。
 * 时间复杂度：
 * 最优时间复杂度O(nlogn)
 * 最差时间复杂度O(n^2),等于退化为冒泡排序
 * 平均时间复杂度等于最优时间复杂度O(nlogn)
 * @Date : 2019/11/19 11:06
 * @Author : zhang_jin
 */
public class QuikSort {
    public static void main(String[] args) {
//        int[] a = new int[]{49, 38, 65, 97, 76, 13, 27};
        int[] a = new int[]{13, 15, 20, 6, 3, 2, 17, 50};
        System.out.println("排序前：" + Arrays.toString(a));
        sort(a, 0, 6);
        System.out.println("排序后：" + Arrays.toString(a));
    }

    static void sort(int[] a, int low, int high) {
        int i = low;
        int j = high;
        int key = a[low];
        int n = 0;// 记录排序趟次

        if (low < high) {
            while (i < j) {
                n++;
                while (i < j && a[j] >= key) {
                    j--;
                }
                a[i] = a[j];
                while (i < j && a[i] <= key) {
                    i++;
                }
                a[j] = a[i];
                a[i] = key;
                System.out.println("第" + n + "次排序结果：" + Arrays.toString(a));
            }
            sort(a, low, i - 1);
            sort(a, i + 1, high);
        }
    }
}
