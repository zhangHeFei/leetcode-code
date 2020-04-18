package com.leetcode.SortingAlgorithm;

/**
 * 堆排序：将数组构造为一个大根堆，然后堆顶和堆最后一个节点交换位置（就是将最大的数放到了数组的最后边），然后将堆的大小减1，重新调整为大根堆，以此类推...
 */
public class HeapSort implements Sort {
    @Override
    public void sort(int[] nums) {
        int heap_size = nums.length;
        buildHeap(nums, heap_size);
        while (heap_size > 0){
            heapify(nums,0,heap_size --);
            swap(nums,0,heap_size);
        }
    }

    private static void heapify(int[] nums, int root, int size){
        int left_child = root * 2 + 1;
        int right_child = root * 2 + 2;
        int max = root;
        if (left_child < size && nums[left_child] > nums[max]){
            max = left_child;
        }
        if (right_child < size && nums[right_child] > nums[max]){
            max = right_child;
        }
        if (max != root){
            swap(nums,max,root);
            heapify(nums,max,size);
        }
    }

    private static void buildHeap(int[] nums, int heap_size){
        for (int i = heap_size / 2 - 1; i >= 0; i --){
            heapify(nums,i,heap_size);
        }
    }

    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
