package com.rambo.algorithm.dp;

/**
 * @description:198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/house-robber
 * @author: zhangjin27
 * @created: 2022/09/25 21:41
 */
public class HouseRobber {
    //1.确定状态dp[i] = i个房间的最大偷窃金额；
    //2.确定转移方程：dp[i] = Math.max(dp[i-2]+nums[i],dp(i-1));
    //3.初始值和边界情况：空数组，返回0，一个房间返回nums[0],两个房间返回Math.max(nums[0],nums[1]);
    //4.计算顺序，从小到大

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        int[] b = {2, 7, 9, 3, 1};
        int robA = rob(a);
        int robB = rob(b);
        int rob2A = rob2(a);
        int rob2B = rob2(b);
        System.out.println(robA);
        System.out.println(robB);
        System.out.println(rob2A);
        System.out.println(rob2B);
    }

    /**
     * 标准动态规划写法，使用dp数组形式，空间复杂度O(n)
     *
     * @param a
     * @return
     */
    public static int rob(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int[] dp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                dp[i] = a[0];
            }
            if (i == 1) {
                dp[i] = Math.max(a[0], a[1]);
            }
            if (i >= 2) {
                dp[i] = Math.max(dp[i - 2] + a[i], dp[i - 1]);
            }
        }
        return dp[a.length - 1];
    }

    /**
     * 优化后动态规划写法，使用滚动数组形式，空间复杂度O(1)
     *
     * @param a
     * @return
     */
    public static int rob2(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int pre = 0;
        int cur = 0;
        int tmp;
        for (int i = 0; i < a.length; i++) {
            tmp = cur;
            cur = Math.max(pre + a[i], cur);
            pre = tmp;
        }
        return cur;
    }
}
