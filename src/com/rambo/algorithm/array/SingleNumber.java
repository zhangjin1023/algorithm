package com.rambo.algorithm.array;

/**
 * @description:数组中数字出现的次数
 * @Date : 2019/11/22 16:29
 * @Author : zhang_jin
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 1, 4};
        System.out.println(singleNumber(a));
    }

    /**
     * @description在一个数组中除了一个数字只出现一次之外，其他数字都出现了2次，请找出那个只出现了一次的数字。
     * 要求：线性时间复杂度O(N)，空间复杂度为O(1)
     * 用位运算来解决XOR异或来解决该问题。由于两个相同的数字的异或结果是0，我们可以把数组中的所有数字进行异或操作，结果就是唯一出现的那个数字。
     * @param a
     * @return int
     */
    public static int singleNumber(int[] a) {
        int result = a[0];
        for (int i = 1; i < a.length; i++) {
            result = result ^ a[i];
        }
        return result;
    }
}
