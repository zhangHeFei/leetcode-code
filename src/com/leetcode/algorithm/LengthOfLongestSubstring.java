package com.leetcode.algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个字符串，找出其中最长的字串
 *
 * 使用队列，动态窗口
 */
public class LengthOfLongestSubstring {

    private static int getResult(String s) {
        Queue<Character> queue = new LinkedList<>();
        char[] chars = new char[s.length()];
        s.getChars(0, s.length(), chars, 0);
        int max = 0;
        for (Character c : chars) {
            if (!queue.contains(c)) {
                queue.offer(c);
                if (queue.size() > max) {
                    max = queue.size();
                }
            } else {
                while (true) {
                    if (c.equals(queue.poll())) {
                        break;
                    }
                }
                queue.offer(c);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getResult("aab"));
        System.out.println(getResult("bbbbb"));
        System.out.println(getResult("pwwkew"));

        System.out.println("-------------------------------");

    }
}
