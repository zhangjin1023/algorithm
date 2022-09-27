package com.rambo.algorithm.dp;

/**
 * @description: 【例题：LintCode 669:Coin Change】
 * 你有三种硬币，分别面值2元，5元，7元，每种硬币都足够多，买一本书需要27元，如何用最少的硬币组合正好付清，不需要对方找钱。
 * 思路：求最大值，最小值，可考虑动态规划。
 * @author: zhangjin27
 * @created: 2022/09/25 13:32
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {2, 5, 7};
        int coinChange = coinChange(coins, 27);
        System.out.println(coinChange);
    }

    /**
     * @param A [2,5,7]
     * @param M 27
     * @return
     */
    public static int coinChange(int[] A, int M) {
        int[] f = new int[M + 1];
        int n = A.length;

        f[0] = 0;

        int i, j;
        for (i = 1; i <= M; ++i) {
            f[i] = Integer.MAX_VALUE;
            for (j = 0; j < n; ++j) {
                if (i >= A[j] && f[i - A[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - A[j]] + 1, f[i]);
                }
            }
        }

        if (f[M] == Integer.MAX_VALUE) {
            f[M] = -1;
        }
        return f[M];
    }
}
