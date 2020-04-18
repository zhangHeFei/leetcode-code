package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数相加
 */
public class Two_Sum {

    public int[] towSum_1(int[] nums, int target){
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i ++){
            for (int j = i + 1; j < nums.length; j ++){
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    private int[] towSum_2(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            if (map.get(target - nums[i]) != null){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        Two_Sum solution = new Two_Sum();
        for (int num : solution.towSum_2(nums,target)){
            System.out.print(num);
            System.out.print("  ");
        }
    }
}
