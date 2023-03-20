package com.rambo.algorithm.search;

/**
 * @description: test
 * @author: zhangjin27
 * 给定按照非递减顺序排列的整数数组 nums 和一个目标值 target。请你找出给定目标值在数组中最右侧的位置
 * @created: 2023/03/02 19:58
 */
public class BinarySearch3 {

    public static void main(String[] args) {
        int[] array = {1,2,2,2,3,4};
        System.out.println(search(array,2));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int index = biSearch(nums, low, high, target);
        if (index == -1) {
            return -1;
        }
        int i = index;
        for (; i <= high; i++) {
            if (nums[i] > nums[index]) {
                break;
            }
        }
        return i - 1;
    }

    private static int biSearch(int[] nums, int low, int high, int target) {
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
