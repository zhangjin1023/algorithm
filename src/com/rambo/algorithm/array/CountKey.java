package com.rambo.algorithm.array;

/**
 * @description:在排序数组中查找数字出现的次数:
 * 例如，输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，所以输出4.
 * 分析：看到排序数组，需要迅速联想到二分法。
 * 整体的时间复杂度为O(logN)
 * @Date : 2019/11/22 15:49
 * @Author : zhang_jin
 */
public class CountKey {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 2, 5, 5, 7, 8, 9};
        System.out.println(countKey(a, 2));
    }

    public static int countKey(int[] a, int key) {
        if (a == null) {
            return -1;
        }
        return count(a, 0, a.length - 1, key);
    }

    /**
     * @description 二分法加递归
     * @param a
     * @param start
     * @param end
     * @param key
     * @return int
     */
    private static int count(int[] a, int start, int end, int key) {
        if (start > end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        if (a[mid] > key) {
            return count(a, start, mid - 1, key);
        } else if (a[mid] < key) {
            return count(a, mid + 1, end, key);
        } else {
            return 1 + count(a, start, mid - 1, key) + count(a, mid + 1, end, key);
        }
    }
}
