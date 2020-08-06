package com.leetcode.algorithm;

import java.util.Stack;

/**
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 * 注意：n 的值小于15000。
 *
 * 示例1:
 *
 * 输入: [1, 2, 3, 4]
 *
 * 输出: False
 *
 * 解释: 序列中不存在132模式的子序列。
 *
 *
 * 示例 2:
 *
 * 输入: [3, 1, 4, 2]
 *
 * 输出: True
 *
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 *
 *
 * 示例 3:
 *
 * 输入: [-1, 3, 2, 0]
 *
 * 输出: True
 *
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Find132pattern {

    public boolean find132pattern(int[] nums) {

        if (nums.length < 3){
            return false;
        }

        // 1. 从左至右获取每个值左侧的最小值
        int[] minNums = new int[nums.length];
        minNums[0] = nums[0];
        for (int i = 1; i < nums.length; i ++){
            minNums[i] = Math.min(minNums[i - 1], nums[i]);
        }

        // 2.构建一个栈，从右向左遍历，如果num[j] <= miNum[j], 就跳过该元素；如果栈顶元素 > num[j], 当前元素入栈；
        // 如果小于当前元素，就通过出栈的方式，在栈中找一个大于minNum[j]的元素
        Stack<Integer> stack = new Stack<>();
        for (int j = nums.length - 1; j >= 0; j --){
            if (nums[j] <= minNums[j]){
                continue;
            }
            if (stack.isEmpty() || stack.peek() >= nums[j]){
                stack.push(nums[j]);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() < nums[j]){
                if (stack.pop() > minNums[j]){
                    return true;
                }
            }
        }

        return false;
    }
}
