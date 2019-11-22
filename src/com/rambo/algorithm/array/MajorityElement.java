package com.rambo.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:寻找多数元素：找出一个数组中占50%以上的元素，即寻找多数元素，并且多数元素是一定存在的假设。
 * @Date : 2019/11/22 10:49
 * @Author : zhang_jin
 */
public class MajorityElement {


    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 3, 1, 3, 3};
        int majorityElement = majorityElement1(a);
        System.out.println(majorityElement);
        int majorityElement2 = majorityElement2(a);
        System.out.println(majorityElement2);
        int majorityElement3 = majorityElement3(a);
        System.out.println(majorityElement3);
    }

    /**
     * @description 思路1：将数组排序，则中间的那个元素一定是多数元素
     * 时间复杂度为O（NlogN）
     * @param a
     * @return int
     */
    public static int majorityElement1(int[] a) {
        Arrays.sort(a);
        return a[a.length / 2];
    }

    /**
     * @description 思路2：利用HashMap来记录每个元素的出现次数
     * 时间复杂度为O（N），空间复杂度为O（N）
     * @param a
     * @return int
     */
    public static int majorityElement2(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                ++count;
                map.put(i, count);
            } else {
                map.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > a.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * @description多数投票算法(Boyer-Moore Algorithm)
     * 时间复杂度为O(n)，空间复杂度为O(1)
     * 理解：类似于投票，赞成票抵消掉反对票后剩余的就是多数票。
     * 1、将数组的元素抽象为模型：多数元素和非多数元素。多数元素的总个数减去非多数元素总个数一定大于0
     * 2、我们利用一个count值来表示多数元素总个数与非多数元素总个数之间的差，然后选择第一个元素当做候选者，遍历数组
     * 3、当count值变为0的时候，意味着之前经过的所有元素中，多数元素与非多数元素总个数相等。
     * 那么剩下的元素中，多数元素依然是多数元素。
     * 4、循环结束后count值依然大于0，那么候选者就是多数元素
     * @param a
     * @return int
     */
    public static int majorityElement3(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("the input array is null or empty");
        }
        int element = 0;
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            if (count == 0) {
                element = a[i];
                count = 1;
            } else {
                if (element == a[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return element;
    }
}
