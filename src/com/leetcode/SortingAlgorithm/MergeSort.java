package com.leetcode.SortingAlgorithm;

/**
 * 归并排序；将数组拆分，排序，在合并
 */
public class MergeSort implements Sort{
    @Override
    public void sort(int[] nums) {
        mergeSortRecursion(nums,0,nums.length - 1);
//        mergeSortIterator(nums);
    }

    /**
     * 非递归实现归并排序
     * @param nums
     */
    public void mergeSortIterator(int[] nums){
        int left,right,mid;
        for (int i = 1; i < nums.length; i = i * 2){
            left = 0;
            while (left + i < nums.length){
                mid = left + i - 1;
                right = mid + i < nums.length ? mid + i : nums.length - 1;
                merge(nums,left,right,mid);
                left = right + 1;
            }
        }
    }

    /**
     * 递归实现归并排序
     * @param nums
     * @param left
     * @param right
     */
    public void mergeSortRecursion(int[] nums, int left, int right){
        if (left == right){
            return;
        }
        mergeSortRecursion(nums,left,(left + right) / 2);
        mergeSortRecursion(nums,(left + right) / 2 + 1,right);
        merge(nums,left,right,(left + right) / 2);
    }

    private static void merge(int[] nums, int left, int right, int mid){
        int i = left, j = mid + 1;
        int[] temp = new int[right - left + 1];
        int index = 0;
//        while (i <= mid || j <= right){
//            if (j > right || (i <= mid && nums[i] <= nums[j])) {
//                temp[index++] = nums[i++];
//            }else{
//                temp[index ++] = nums[j++];
//            }
//        }
        while (i <= mid && j <= right){
            temp[index ++] = nums[i] <= nums[j] ? nums[i ++] : nums[j ++];
        }
        while (i <= mid){
            temp[index ++] = nums[i ++];
        }
        while (j <= right){
            temp[index ++] = nums[j ++];
        }
        for (int k = 0; k < temp.length; k ++){
            nums[left ++] = temp[k];
        }
    }
}
