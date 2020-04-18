package com.leetcode.algorithm;

public class Sort_Colors {
    public void sortColors(int[] nums){
        buildHeap(nums);
        int size = nums.length;
        while (size > 0){
            heapify(nums,0,size);
            swap(nums,0,-- size);
        }
    }

    private static void buildHeap(int[] nums){
        for (int i = nums.length / 2 - 1; i >= 0; i --){
            heapify(nums,i,nums.length);
        }
    }

    private static void heapify(int[] nums, int root, int size){
        int max = root;
        int left_child = root * 2 + 1;
        int right_child = root * 2 + 2;

        if (left_child < size && nums[left_child] > nums[root]){
            max = left_child;
        }
        if (right_child < size && nums[right_child] > nums[max]){
            max = right_child;
        }
        if (max != root){
            swap(nums,root,max);
            heapify(nums,max,size);
        }
    }

    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static void sortColors_2(int[] nums) {
        int minIndexOne = -1;
        int minIndexTwo = -1;
        for (int i = 0; i < nums.length; i ++){
            if (i == 0 || nums[i] >= nums[i - 1]){
                if (nums[i] == 1 && minIndexOne == -1){
                    minIndexOne = i;
                }
                if (nums[i] == 2 && minIndexTwo == -1){
                    minIndexTwo = i;
                }
                continue;
            }
            if (nums[i - 1] - nums[i] == 1){
                if (nums[i] == 1){
                    swap(nums, i, minIndexTwo);
                    if (minIndexOne == -1){
                        minIndexOne = minIndexTwo;
                    }
                    minIndexTwo ++;
                }
                if (nums[i] == 0){
                    swap(nums, i, minIndexOne);
                    minIndexOne ++;
                }
            }
            if (nums[i - 1] - nums[i] == 2){
                swap(nums, i, minIndexTwo);
                if (minIndexOne != -1){
                    swap(nums, minIndexTwo, minIndexOne);
                    minIndexOne ++;
                }
                minIndexTwo ++;
            }
        }
    }

    /**
     * 标记0得最右边界（p0）和2得最左边界(p2)，遍历当前数组，curr == 0，swap(curr, p0) curr ++ ; curr == 2, swap(curr, p2)
     * @param nums 数字数组
     */
    private static void sortColor_3(int[] nums){

        // 1.初始化p0, p2, curr
        int curr = 0, p0 = 0, p2 = nums.length - 1;

        // 2.遍历数组
        while (curr <= p2){
            if (nums[curr] == 0){
                swap(nums, curr, p0);
                p0 ++;
                curr ++;
            } else if (nums[curr] == 2){
                swap(nums, curr, p2);
                p2 --;
            } else {
                curr ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,1};
        sortColor_3(nums);
        for (int num : nums) {
            System.out.print(num);
            System.out.print("  ");
        }
    }
}
