package com.leetcode.SortingAlgorithm;

/**
 * 希尔排序：相对于直接插入排序加入了增量递减。
 */
public class ShellSort implements Sort {
    @Override
    public void sort(int[] nums) {
        int increase = 0;
        while (increase < nums.length){
            increase = increase * 3 + 1;
        }
        while (increase >= 1){
            for (int i = increase; i < nums.length; i ++){
                int insertion = nums[i];
                int j = i - increase;
                while (j >= 0 && nums[j] > insertion){
                    nums[j + increase] = nums[j];
                    j = j - increase;
                }
                nums[j + increase] = insertion;
            }
            increase = (increase - 1) / 3;
        }
    }
}
