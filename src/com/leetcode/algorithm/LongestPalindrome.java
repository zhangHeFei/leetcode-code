package com.leetcode.algorithm;

import jdk.nashorn.internal.objects.annotations.Where;

import java.util.*;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {

    /**
     * 使用队列实现动态窗口（理解错题目了，以为收尾相同便是回文）
     * @param s 字符串
     * @return 最大回文字符串
     */
    private static String longestPalindrome(String s) {

        char[] chars = s.toCharArray();
        for (int i = s.length(); i >0; i --){

            // 1.初始化长度为i大小的双向队列
            Deque<Character> deque = new LinkedList<>();

            // 2.初始化队列数据
            for (int j = 0; j < i; j ++){
                deque.offerLast(chars[j]);
            }

            int a = i - 1;
            do {
                // 3.判断队列是否为回文字符串
                if (deque.getFirst().equals(deque.getLast())){
                    Iterator iterator = deque.iterator();
                    StringBuilder stringBuilder = new StringBuilder();
                    while (iterator.hasNext()){
                        stringBuilder.append(iterator.next());
                    }
                    return stringBuilder.toString();
                }

                // 4.将动态窗口向后移动
                if (++a < chars.length){
                    deque.pollFirst();
                    deque.offerLast(chars[a]);
                }
            } while (a < chars.length);
        }
        return "";
    }

    /**
     * 回文字符串，左右对称
     * @param s s
     * @return 回文字符串
     */
    private static String longestPalindrome_2(String s){
        return null;
    }

    public static void main(String... args){

        System.out.println(longestPalindrome("cbaa"));
    }
}
