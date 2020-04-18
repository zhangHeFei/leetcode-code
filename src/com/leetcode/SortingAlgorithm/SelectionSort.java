package com.leetcode.SortingAlgorithm;

public class SelectionSort implements Sort {
    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i ++){
            int min = i;
            for (int j = i + 1; j < nums.length; j ++){
                if (nums[j] < nums[min]){
                    min = j;
                }
            }
            swap(nums,i,min);
        }
    }

    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
