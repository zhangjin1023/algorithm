package com.rambo.algorithm.dp;

/**
 * @description:青蛙跳台阶问题 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级台阶总共有多少种跳法？
 * @Date : 2019/11/23 17:26
 * @Author : zhang_jin
 */
public class FrogJump {
    public static void main(String[] args) {
        int n = 42;

        long start2 = System.currentTimeMillis();
        System.out.println(frogJump2(n));
        System.out.println("frogJump2 cost:" + String.valueOf(System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();
        System.out.println(frogJump3(n));
        System.out.println("frogJump3 cost:" + String.valueOf(System.currentTimeMillis() - start3));

        long start1 = System.currentTimeMillis();
        System.out.println(frogJump1(n));
        System.out.println("frogJump1 cost:" + String.valueOf(System.currentTimeMillis() - start1));

        long start4 = System.currentTimeMillis();
        System.out.println(frogJumpDp(n));
        System.out.println("frogJumpDp cost:" + String.valueOf(System.currentTimeMillis() - start4));

        long start5 = System.currentTimeMillis();
        System.out.println(frogJumpDp2(n));
        System.out.println("frogJumpDp2 cost:" + String.valueOf(System.currentTimeMillis() - start5));
    }

    /**
     * @param n
     * @return int
     * @description 斐波那契数列解法
     * 时间复杂度：O(2^n)
     * 问题：存在大量的重复求解子问题的问题。
     */
    public static int frogJump1(int n) {
        if (n <= 2) {
            return n;
        }
        return frogJump1(n - 1) + frogJump1(n - 2);
    }

    /**
     * @param n
     * @return int
     * @description 备忘录解法（自顶向下）：优化递归中重复求解子问题的问题
     * 问题：时间复杂度O(n),空间复杂度O(n)
     */
    public static int frogJump2(int n) {
        int[] memo = new int[n + 1];// 从数组第二个开始填值，便于理解
        return jumpWithMemo(n, memo);
    }

    private static int jumpWithMemo(int n, int[] memo) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = jumpWithMemo(n - 1, memo) + jumpWithMemo(n - 2, memo);
        return memo[n];
    }

    /**
     * @param n
     * @return int
     * @description 迭代法（自底向上）,时间复杂度0(n),空间复杂度O(1)
     */
    public static int frogJump3(int n) {
        if (n <= 2) {
            return n;
        }
        int jumpOne = 2;
        int jumpTwo = 1;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = jumpOne + jumpTwo;
            jumpTwo = jumpOne;
            jumpOne = result;
        }
        return result;
    }

    /**
     * @param n
     * @return int
     * @description dp解法（自底向上）,时间复杂度0(n),空间复杂度O(n)
     */
    public static int frogJumpDp(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i <= 2) {
                dp[i] = i;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    /**
     * @param n
     * @return int
     * @description dp滚动数组解法（自底向上）,时间复杂度0(n),空间复杂度O(1)
     */
    public static int frogJumpDp2(int n) {
        if (n <= 2) {
            return n;
        }
        int pre = 1;
        int cur = 2;
        int tmp;
        for (int i = 3; i <= n; i++) {
            tmp = cur;
            cur = cur + pre;
            pre = tmp;
        }
        return cur;
    }


}
