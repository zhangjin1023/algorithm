package com.rambo.algorithm.dp;

/**
 * @description:给定一个参数N，返回：1！+2！+3!+4!+***+N！的结果
 * @author: zhangjin27
 * @created: 2024/03/03 10:22
 */
public class FactorialSum {
    //把上一步计算的结果存起来，下一步计算可以直接复用
    public static long function(int n) {
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= n; i++) {
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }
}
