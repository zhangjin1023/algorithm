package com.rambo.algorithm.sort;

import java.util.Arrays;

/**
 * @description: 冒泡排序:两层循环，外层循环是数组的长度次数，内层循环是数组的长度减去外层循环所在的轮次i。内层循环进行数组的两两相邻数据的比较与交换
 * @author: zhangjin27
 * @created: 2023/02/26 18:26
 */
public class BubbleSort {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 6, 3, 5, 8, 4};
        int[] result = bubbleSort(nums);
        System.out.println("最终排序结果：" + Arrays.toString(result));
    }

    public static int[] bubbleSort(int[] nums) {
      if (nums == null || nums.length <= 1) {
        return nums;
      }

      for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < nums.length - 1 - i; j++) {
          if (nums[j + 1] < nums[j]) {
            int tmp = nums[j + 1];
            nums[j + 1] = nums[j];
            nums[j] = tmp;
          }
        }

        System.out.println("第" + (i + 1) + "轮排序后数组为：" + Arrays.toString(nums));
      }
      return nums;
    }

}
