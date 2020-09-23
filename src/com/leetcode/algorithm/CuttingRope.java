package com.leetcode.algorithm;

import java.math.BigInteger;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 *
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 提示：
 *
 *
 * 	2 <= n <= 58
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 动态规划
 * 状态转移方程:  dp[i] = max(max(j, dp[j]) * max(i-j, dp(i-j)))
 */
public class CuttingRope {

    public int cuttingRope(int n) {

        int[] dp = new int[n + 1];

        dp[2] = 1;
        for (int i = 3; i <= n; i ++){
            for (int j = 1; j <= Math.ceil(i / 2.0); j ++){
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }

    /**
     * 新版的 dp数组代表max(出现的乘积，自身的长度)
     * @param n
     * @return
     */
    public int newCuttingRope(int n){
        if (n == 2){
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i ++){
            for (int j = 1; j <= Math.ceil(i / 2.0); j ++){
                dp[i] = Math.max(dp[i], dp[j] * dp[i -j]);
            }
        }
        return dp[n];
    }


    public int cuttingRope2(int n){
        BigInteger[] dp = new BigInteger[n + 1];
        dp[1] = new BigInteger("0");
        dp[2] = new BigInteger("1");
        for (int i = 3; i <= n; i ++){
            dp[i] = new BigInteger("0");
            for (int j = 1; j <= Math.ceil(i / 2.0); j ++){
                dp[i] = dp[i].max(dp[j].max(new BigInteger(String.valueOf(j))).multiply(dp[i-j].max(new BigInteger(String.valueOf(i - j)))));
            }
        }
        return dp[n].mod(new BigInteger("1000000007")).intValue();
    }
}
