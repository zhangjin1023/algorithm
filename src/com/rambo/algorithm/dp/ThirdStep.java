package com.rambo.algorithm.dp;

/**
 * @description:
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 * 示例2:
 *
 *  输入：n = 5
 *  输出：13
 * 提示:
 *
 * n范围在[1, 1000000]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangjin27
 * @created: 2022/09/26 16:42
 */
public class ThirdStep {
    // 和青蛙跳台阶问题是类似的，可以推演出来f[n] = f[n-1] + f[n-2] + f[n-3];
    //f[1] = 1,f[2] = 2,f[3] = 4

    public static void main(String[] args) {
        System.out.println(thirdStep(5));
    }

    public static int thirdStep(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        int prePre = 1;
        int pre = 2;
        int cur = 4;
        int tmp;
        for (int i = 4; i <= n; i++) {
            tmp = cur;
            cur = (cur + (pre + prePre) % 1000000007) % 1000000007;
            prePre = pre;
            pre = tmp;
        }
        return cur;
    }
}
