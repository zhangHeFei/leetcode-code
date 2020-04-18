package com.leetcode.SortingAlgorithm;

/**
 * 冒泡排序：依次比较相邻的两个数，大的放在后边，一趟排序之后最大数将被移动至最右侧
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i ++){
            for (int j = 0; j < nums.length - i - 1; j ++){
                if (nums[j] > nums[j + 1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }

    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
