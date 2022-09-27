package com.rambo.algorithm.dp;

/**
 * @description:你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HouseRobberII {
    //1.确定状态dp[i] = i个房间的最大偷窃金额；
    //2.确定转移方程：有环，考虑最后一步，如果要偷最后一间nums[i]，则不允许偷开头的房间nums[0];如果不偷最后一间，则可以偷开头的房间
    // 理解为求[0,i-2],和[1,i-1]两个数组的状态求最大值，状态转移方程还是下边的：
    // dp[i] = Math.max(dp[i-2]+nums[i],dp(i-1));
    //3.初始值和边界情况：空数组，返回0，一个房间返回nums[0],两个房间返回Math.max(nums[0],nums[1]);
    //4.计算顺序，从小到大

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        int[] b = {1, 2, 3};
        int[] c = {2, 3, 2};

        System.out.println(rob(a));
        System.out.println(rob(b));
        System.out.println(rob(c));
    }

    public static int rob(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        if (a.length == 1) {
            return a[0];
        }
        int v1 = doRob(a, 0, a.length - 2);
        int v2 = doRob(a, 1, a.length - 1);
        return Math.max(v1, v2);
    }

    /**
     * 优化后动态规划写法，使用滚动数组形式，空间复杂度O(1)
     *
     * @param a
     * @return
     */
    public static int doRob(int[] a, int start, int end) {
        int pre = 0;
        int cur = 0;
        int tmp;
        for (int i = start; i <= end; i++) {
            tmp = cur;
            cur = Math.max(pre + a[i], cur);
            pre = tmp;
        }
        return cur;
    }
}
