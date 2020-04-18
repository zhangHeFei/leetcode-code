package com.leetcode.SortingAlgorithm;

/**
 * 插入排序：遍历数组，如果所取得数字小于以排序得数据，就将排序数字后移，如果大于，就将该数字插入到该处。
 */
public class InsertSort implements Sort{
    @Override
    public void sort(int[] nums) {
        int insertNum;
        for (int i = 1; i < nums.length; i ++){
            insertNum = nums[i];
            int j;
            for (j = i - 1; j >= 0; -- j){
                if (insertNum < nums[j]){
                    nums[j+1] = nums[j];
                }else{
                    break;
                }
            }
            nums[j + 1] = insertNum;
        }
    }
}
