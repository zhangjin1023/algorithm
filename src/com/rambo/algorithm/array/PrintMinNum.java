package com.rambo.algorithm.array;

import java.util.Arrays;

/**
 * @description:1、将数组排成最小的数：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 * @Date : 2019/11/22 19:05
 * @Author : zhang_jin
 */
public class PrintMinNum {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{3, 32, 321};
        printMinNum(a);
    }

    /**
     * @description 插曲：int[] 声明的参数类型，不可以传Integer[] 类型的数组
     * @param a
     * @return void
     */
    public static void printMinNum(Integer[] a) {
        Arrays.sort(a, (o1, o2) -> Integer.valueOf(o1 + "" + o2).compareTo(Integer.valueOf(o2 + "" + o1)));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
        }
        System.out.println(sb.toString());
    }
}
