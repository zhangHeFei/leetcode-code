package com.leetcode.algorithm;

import java.util.Stack;

/**
 * 难度简单45收藏分享切换为英文关注反馈输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 解法 ： 栈
 */
public class ReversePrint {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        while (head.next != null){
            stack.push(head.val);
            head = head.next;
        }
        stack.push(head.val);
        int[] result = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()){
            result[index] = stack.pop();
            index ++;
        }
        return result;
    }
}
