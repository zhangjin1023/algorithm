package com.rambo.algorithm.array;

/**
 * @description:在排序数组中查找数字出现的次数:
 * 例如，输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，所以输出4.
 *
 * 分析：看到排序数组，需要迅速联想到二分法。
 * 二分算法，我们先比较中间的值和目标target的关系，然后分区间找出该数组中第一次出现目标target和最后一次出现target的位置，
 * 两者相减即为该目标出现的次数。整体的时间复杂度为O(logN)
 * @Date : 2019/11/22 15:49
 * @Author : zhang_jin
 */
public class CountKey {

}
