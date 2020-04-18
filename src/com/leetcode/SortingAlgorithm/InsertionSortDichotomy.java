package com.leetcode.SortingAlgorithm;

/**
 * 二分插入排序：在查找插入到那个数之前时使用二分查找
 */
public class InsertionSortDichotomy implements Sort {
    @Override
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i ++){
            int insertion = nums[i];
            int left = 0;
            int right = i - 1;
            while (left <= right){
                int mid = (left + right) / 2;
                if (nums[mid] > insertion){
                    right = mid - 1;
                }else if (nums[mid] < insertion){
                    left = mid + 1;
                }else{
                    left = right = mid;
                }
            }
            for (int j = i - 1; j >= left; j --){
                nums[j+1] = nums[j];
            }
            nums[left] = insertion;
        }
    }
}
