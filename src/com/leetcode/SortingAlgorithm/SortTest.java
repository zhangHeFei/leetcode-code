package com.leetcode.SortingAlgorithm;

public class SortTest {
    public static void main(String[] args){
        int[] nums = {6,5,3,1,8,7,2,4};
//        Sort sort = new BubbleSort();
//        Sort sort = new CocktailSort();
//        Sort sort = new SelectionSort();
//        Sort sort = new InsertSort();
//        Sort sort = new InsertionSortDichotomy();
//        Sort sort = new ShellSort();
//        Sort sort = new MergeSort();
        Sort sort = new HeapSort();
        sort.sort(nums);
        for (int num : nums){
            System.out.print(num);
            System.out.print("  ");
        }
    }
}
