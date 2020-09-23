package com.leetcode.algorithm;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 *
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 *
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：快速幂 （原理见题解吧）
 * x^n = (x^2)^(n / 2) ---> (1) n是偶数时，令 x = x^2，继续循环 （2）n是奇数时，x = x * (x ^ 2) ^ (n / 2), 令 x = x^2，继续循环
 * 当 n = 0 为止
 *
 * 注意：int的最小值取反后，会越界，要对其进行特殊处理
 */
public class MyPow {

    public static double myPow(double x, int n) {
        double originX= x;
        boolean flag = n == Integer.MIN_VALUE;
        x = flag ? 1 / x : n < 0 ? 1 / x : x;
        n = flag ? Integer.MAX_VALUE : n < 0 ? -n : n;
        double res = 1;
        while (n > 0){
            if (n % 2 == 1){
                res = res * x;
            }
            n = n >>> 1;
            x = x * x;
        }
        return flag ? originX * res : res;
    }

    public static void main(String... args){
        System.out.println(myPow(2.0, -2));
    }
}
