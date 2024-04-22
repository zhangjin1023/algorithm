package com.rambo.algorithm.dp;

/**
 * @description:https://leetcode.cn/problems/unique-paths/
 * @author: zhangjin27
 * @created: 2024/04/21 16:16
 */
public class UniquePaths {
    //dp数组和下标的含义：dp[m,n]表示从一个mxn网格的左上角移动到右下角的路径数量
    //递推公式：dp[m,n] = dp[m-1,n] + dp[m,n-1]
    //dp数组初始化：dp[0,0]=0，dp[0,1]=0，dp[1,0]=0 无意义，dp[1,1]=0,dp[1,2]=1,dp[2,1]=1
    //遍历方向：从小到大
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i == 2&&j<=1 || i == 1&&j<=2){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
