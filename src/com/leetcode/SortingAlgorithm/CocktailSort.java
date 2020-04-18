package com.leetcode.SortingAlgorithm;


/**
 * 鸡尾酒排序算法：第一轮从左至右将最大数冒泡至最右侧，第二轮从右至左将最小数冒泡至最左侧，以此类推
 */
public class CocktailSort implements Sort{
    @Override
    public void sort(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            for (int i = left; i < right; i ++){
                if (nums[i] > nums[i + 1]){
                    swap(nums,i,i+1);
                }
            }
            right --;
            for (int i = right; i > left; i --){
                if (nums[i] < nums[i - 1]){
                    swap(nums,i,i - 1);
                }
            }
            left ++;
        }
    }

    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
