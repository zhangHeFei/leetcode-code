package com.leetcode.algorithm;

import java.util.Stack;

/**
 * 用栈实现一个队列
 */
public class CQueue {

    /** stack1用于添加元素 */
    private Stack<Integer> stack1;

    /** stack2用于删除元素 */
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        if (stack1.empty() && !stack2.empty()){
            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }
        }
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack1.empty() && stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.empty()){
            return -1;
        }
        return stack2.pop();
    }
}
