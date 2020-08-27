package com.leetcode.algorithm;

import java.util.Queue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 *
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 *
 * 提示：
 *
 *
 * 	1 <= n,m <= 100
 * 	0 <= k <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：广度优先搜索
 */
public class MovingCount {

    public int movingCount(int m, int n, int k) {

        // 1.生成一个二维数组，用来记录那些位置已经被检测过了
        int[][] ints = new int[m][n];

        return count(0, 0, ints, m, n, k);
    }


    private int count(int x, int y, int[][] ints, int m, int n, int k){

        // 1.边界判断
        if (x < 0 || y < 0 || x > m -1 || y > n -1){
            return 0;
        }
        // 2.该节点是否已经检测过
        if (ints[x][y] == 1){
            return 0;
        }
        // 3.判断该节点是否符合相加小于k的约束
        if (sum(x) + sum(y) > k){
            return 0;
        }
        // 4.所有条件均符合，机器人可以到达这个点，递归判断上、左、下、右四个方向
        ints[x][y] = 1;
        return 1 + count(x + 1, y, ints, m, n, k) + count(x, y + 1, ints, m, n, k);
    }

    private int sum(int num){
        int result = 0;
        while (num > 0){
            result += num % 10;
            num /= 10;
        }
        return result;
    }
}
