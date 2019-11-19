package com.rambo.algorithm;

/**
 * @description:二分查找：非递归实现
 * @Date : 2019/11/19 13:56
 * @Author : zhang_jin
 */
public class BinarySearch2 {
    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 6, 9, 20, 50, 90};
        int index = search(a, 50);
        System.out.println(index);
    }

    static int search(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;// 防止int类型溢出
            if (key > a[mid]) {
                low = mid + 1;
            } else if (key < a[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
